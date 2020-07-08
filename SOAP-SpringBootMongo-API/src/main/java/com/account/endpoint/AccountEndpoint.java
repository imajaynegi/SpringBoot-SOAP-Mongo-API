package com.account.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.account.acc_ws.AccountInfo;
import com.account.acc_ws.AccountRequest;
import com.account.acc_ws.AccountResponse;
import com.account.service.AccountService;


@Endpoint
public class AccountEndpoint {
	
	private static final String NAMESPACE = "http://www.account.com/spring/soap/api/getAccount";

	@Autowired
	private AccountService accountService;
	
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "AccountRequest")
	@ResponsePayload
	public AccountResponse getAccount(@RequestPayload AccountRequest request) throws BeansException, DatatypeConfigurationException {
		AccountResponse response = new AccountResponse();
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(accountService.getAccountById(request.getAccountNumber()), accountInfo);
		response.setAccountInfo(accountInfo);
		return response;
	}
	

}
