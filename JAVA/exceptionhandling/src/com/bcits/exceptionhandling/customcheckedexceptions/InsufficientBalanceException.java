package com.bcits.exceptionhandling.customcheckedexceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	String msg="less balance";
	public InsufficientBalanceException() {
		
	}
    public InsufficientBalanceException(String msg) {
		this.msg=msg;
	}
    @Override
    public String getMessage() {
    	
    	return this.msg;
    }

}
