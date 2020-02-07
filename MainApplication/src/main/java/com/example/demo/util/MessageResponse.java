package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageResponse {
	
	@Value("${codeSuccess}")
	private String codeSuccess;
	
	@Value("${mNotConnection}")
	private String mNotConnection;
	
	@Value("${codeError}")
	private String codeError;
		
	@Value("${mSuccess}")
	private String mSuccess;
	
	
	@Value("${mEmptyName}")
	private String mEmptyName;
	
	@Value("${mGetList}")
	private String mGetList;
	
	@Value("${mEmptyId}")
	private String mEmptyId;
		
	@Value("${mNotExist}")
	private String mNotExist;
	
	public String codeSuccess() {
		return codeSuccess;
	}
	
	public String codeError() {
		return codeError;
	}
	
	public String Success() {		
		return mSuccess;
	}
	
	public String EmptyName() {		
		return mEmptyName;
	}
	
	public String GetList() {		
		return mGetList;
	}
	
	public String EmptyId() {		
		return 	mEmptyId;
	}
	
	public String NotExist() {		
		return mNotExist;
	}
	
	public String NotConnection() {		
		return mNotConnection;
	}

}
