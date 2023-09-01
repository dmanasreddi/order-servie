package com.order.manage.exception;

@SuppressWarnings("serial")
public class OrderNotFound extends RuntimeException{
	public OrderNotFound(String message){
	    super(message);
	  }
}
