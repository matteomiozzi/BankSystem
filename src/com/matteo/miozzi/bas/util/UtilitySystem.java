package com.matteo.miozzi.bas.util;

import java.util.Hashtable;

import com.matteo.miozzi.bas.domain.Bank;

public class UtilitySystem {

	//Host e porta del server in esecuzione
	private String remoteHost;
	private int remotePort;
	
	private Hashtable<Integer,Bank> serverTable;
	
	public UtilitySystem() {
		this.remoteHost="localhost";
		this.remotePort=9001;
		
		this.initServerTable();
	}
	public UtilitySystem(String host, int port) {
		this.remoteHost=host;
		this.remotePort=port;
	}
	public String getRemoteHost() {
		return remoteHost;
	}
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	public int getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}
	
	private void initServerTable() {
		serverTable = new Hashtable<>();
		
	}
	
	public Bank getNextServer(){
	//Leggere la lista di server e ritornare un host random	
	return null;	
	}
	
	
	
}
