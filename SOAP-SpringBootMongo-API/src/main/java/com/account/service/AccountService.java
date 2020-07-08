package com.account.service;


import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Optional;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.acc_ws.AccountInfo;
import com.account.model.Account;
import com.account.repository.AccountRepository;


@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public AccountInfo getAccountById(long acc) throws DatatypeConfigurationException {
		Optional<Account> optional= accountRepository.findById((int) (acc));
		AccountInfo accountInfo=new AccountInfo();
		
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(optional.get().getOpen_date());	 
		try{
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}catch(Exception e){
			e.printStackTrace();
		}
		if (optional.isPresent()) 
		{  
			accountInfo.setId(createRandomId());
			accountInfo.setAccountNumber(optional.get().getAccount_number());
			accountInfo.setType(optional.get().getType());
			accountInfo.setOpenDate(xmlDate);
			accountInfo.setCurrency(optional.get().getCurrency());
			accountInfo.setScheme(optional.get().getScheme());
			accountInfo.setCardNumber(optional.get().getCard_number());
			accountInfo.setCharges(optional.get().getCharges());
			accountInfo.setOverdraftLimit(optional.get().getOverdraft_amount());
			accountInfo.setOverdraftLimit(optional.get().getOverdraft_limit());
			accountInfo.setSortCode(optional.get().getSort_code());
			accountInfo.setActive(optional.get().getActive());
		} 
		return accountInfo;
	}

	private static long createRandomId(){    
		return (long)(Math.random()*100000 + 3333300000L);
	}

}
