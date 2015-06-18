package com.myorg.javacourse.exception;
import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockNotExistException extends PortfolioException{
	public StockNotExistException(){
		super("Stock's not exists");
	}
	public StockNotExistException(String message){
		super(message);
	}
}
