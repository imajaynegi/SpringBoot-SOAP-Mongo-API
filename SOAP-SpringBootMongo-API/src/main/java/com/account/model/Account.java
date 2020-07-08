package com.account.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {

	@Id
	protected long account_number;
	protected String type;
	protected Date open_date;
	protected String currency;
	protected String scheme;
	protected long card_number;
	protected int charges;
	protected int overdraft_amount; 
	protected int overdraft_limit;
	protected int sort_code;
	protected String active;
	
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public long getCard_number() {
		return card_number;
	}
	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public int getOverdraft_amount() {
		return overdraft_amount;
	}
	public void setOverdraft_amount(int overdraft_amount) {
		this.overdraft_amount = overdraft_amount;
	}
	public int getOverdraft_limit() {
		return overdraft_limit;
	}
	public void setOverdraft_limit(int overdraft_limit) {
		this.overdraft_limit = overdraft_limit;
	}
	public int getSort_code() {
		return sort_code;
	}
	public void setSort_code(int sort_code) {
		this.sort_code = sort_code;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", type=" + type + ", open_date=" + open_date
				+ ", currency=" + currency + ", scheme=" + scheme + ", card_number=" + card_number + ", charges="
				+ charges + ", overdraft_amount=" + overdraft_amount + ", overdraft_limit=" + overdraft_limit
				+ ", sort_code=" + sort_code + ", active=" + active + "]";
	}  
	
	


}
