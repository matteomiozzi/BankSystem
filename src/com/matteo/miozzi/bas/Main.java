package com.matteo.miozzi.bas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BankServer server = new BankServer(Integer.valueOf(args[0]));
        server.setImaServer(true);
        server.start();
        
        BankServer client = new BankServer(Integer.valueOf(args[0]));
        client.setImaServer(false);
        client.start();
        
		
	}

}
