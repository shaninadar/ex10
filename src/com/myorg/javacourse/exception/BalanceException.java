package com.myorg.javacourse.exception;
import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")

public class BalanceException extends PortfolioException{
	public BalanceException(){
		super("Balance is negative");
	}
}