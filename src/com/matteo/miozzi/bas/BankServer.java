package com.matteo.miozzi.bas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import com.matteo.miozzi.bas.business.MoneyReceiver;
import com.matteo.miozzi.bas.business.MoneySender;
import com.matteo.miozzi.bas.domain.Bank;
import com.matteo.miozzi.bas.domain.BankMessage;
import com.matteo.miozzi.bas.util.UtilitySystem;

public class BankServer extends Thread{
	private int serverId;
	private Double serverBallance;
	private UtilitySystem utilitySystem;
	private Boolean imaServer = false;
	
	
	public BankServer(int serverId){
		this.serverBallance=Double.valueOf("1.000.000");
		this.serverId = serverId;
		utilitySystem = new UtilitySystem();
		
		System.out.println("New server id "+serverId+"was created");
	}
	
	public void run(){
		if(this.imaServer){
			initServer();
		}else{
			this.sendMoney((Double)(Math.random()*100));
		}
	}
	
	
		
	

	

	public Boolean getImaServer() {
		return imaServer;
	}

	public void setImaServer(Boolean imaServer) {
		this.imaServer = imaServer;
	}

	public void initServer(){
		try {
			ServerSocket serverSocket =new ServerSocket(3);
			while(true){
				Socket clientSocket = serverSocket.accept();
				
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				
				BankMessage message = (BankMessage) ois.readObject();
				if(MoneyReceiver.receiveAmount(message.getMoney())){
					this.decreaseBallance(message.getMoney());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void sendMoney(Double amount){
		if(!MoneySender.sendMoney(serverId,amount)){
			decreaseBallance(amount);
		}
	}

	private void decreaseBallance(Double amount) {
		serverBallance = serverBallance-amount;
		
	}
	private void increaseBallance(Double amount) {
		serverBallance = serverBallance+amount;
		
	}
	
	
}
