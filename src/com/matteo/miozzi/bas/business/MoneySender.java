package com.matteo.miozzi.bas.business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import com.matteo.miozzi.bas.domain.Bank;
import com.matteo.miozzi.bas.domain.BankMessage;
import com.matteo.miozzi.bas.util.UtilitySystem;

public class MoneySender {
	private static UtilitySystem configUtility = new UtilitySystem();
	private static ErrorProcessor errorProcessor = new ErrorProcessor();
	

	public static Boolean sendMoney(int accountId,Double money) {
		
		Boolean errorExist = true;
		
		
		//Create new message
		BankMessage message = new BankMessage();
		message.setBankAccountID(accountId);
		message.setMoney(money);
		message.setMessageDate(new Date());
		
		//Open the socket
		Socket socket = null;
		try {
			
			Bank nextBank = configUtility.getNextServer();
			socket = new Socket(nextBank.getIP(), nextBank.getPort());
			socket.setSoTimeout(10000);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			//Send the message
			oos.writeObject(message);
			
			//CLose the socket
			socket.close();
			errorExist = false;
			
			
			
		} catch (UnknownHostException e) {
			errorProcessor.processError();
			e.printStackTrace();
			
		} catch (IOException e) {
			errorProcessor.processError();
			e.printStackTrace();
		}
		return errorExist;
		

	}

}
