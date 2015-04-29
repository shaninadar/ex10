package com.myorg.javacourse.service;
import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {
	
	
	public Portfolio getPortfolio() {
		Portfolio portfolio = new Portfolio(" ");
		portfolio.setTitle("Exercise 5 - portfolio");
		Date date1 = new Date();
		date1.setYear(2014 - 1900);
		date1.setMonth(10);
		date1.setDate(15);
		Stock stock = new Stock("PIH",(float) 13.1,(float) 12.4, date1);
		portfolio.addStock(stock);
		
		stock = new Stock("AAL",(float) 5.78,(float) 5.5,date1);
		portfolio.addStock(stock);
		
		
		stock = new Stock("CAAS",(float) 32.2,(float) 31.5,date1);
		portfolio.addStock(stock);
		

		return portfolio;
	}
}
