package com.matteo.miozzi.bas.domain;

public class Bank {
	private String IP;
	private int Port;

	public Bank(String ip, int port){
		IP = ip;
		Port = port;
	}
	
	public int getPort(){
		return Port;
	}
	
	public String getIP(){
		return IP;
	}
}
