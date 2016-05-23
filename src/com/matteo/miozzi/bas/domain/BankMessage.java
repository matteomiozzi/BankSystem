package com.matteo.miozzi.bas.domain;

import java.io.Serializable;
import java.util.Date;

public class BankMessage implements Serializable{
	private int bankAccountID;
	private Double money;
	private Date messageDate;
	private Boolean isMessageInError = true;
	
	public BankMessage() {
		
	}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public Boolean getIsMessageInError() {
		return isMessageInError;
	}

	public void setIsMessageInError(Boolean isMessageInError) {
		this.isMessageInError = isMessageInError;
	}
	
	

}
