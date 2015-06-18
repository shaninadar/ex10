package com.myorg.javacourse.exception;
import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class PortfolioFullException extends PortfolioException{
	public PortfolioFullException(){
		super("Portfolio is Full");
	}
}
