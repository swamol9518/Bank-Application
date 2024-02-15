package com.nit.exception;
public class InsufficientBalException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	public InsufficientBalException() 
	{
		super();
	}
	public InsufficientBalException(String info) 
	{
		super(info);
	}
}
