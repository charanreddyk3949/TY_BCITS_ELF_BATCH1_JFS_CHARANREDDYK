package com.bcits.exceptionhandling.customuncheckedexception;

public class AgeLimitException extends RuntimeException {
	String msg="age less the 18";
	public AgeLimitException() {
		
	}
    public AgeLimitException(String msg) {
		this.msg=msg;
	}
    @Override
    public String getMessage() {
    	return this.msg;
    	
    }
	

}
