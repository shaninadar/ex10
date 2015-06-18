package com.myorg.javacourse.exception;
import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockAlreadyExistsException extends PortfolioException{
	public StockAlreadyExistsException(){
		super("Stock's already exists");
	}
	public StockAlreadyExistsException(String message){
		super(message);
	}
}