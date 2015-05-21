package com.myorg.javacourse.service;


import java.util.Date;

import com.myorg.javacourse.model.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {
	
	
	public Portfolio getPortfolio() {
		
		Portfolio myPortfolio = new Portfolio();
				myPortfolio.setTitle("Exercise 7 portfolio");
		Date date1 = new Date();
		date1.setYear(2014 - 1900);
		date1.setMonth(11);
		date1.setDate(15);
		Stock stock = new Stock("PIH",(float) 10.0,(float) 8.5, date1,20);
		myPortfolio.addStock(stock);
		/*myPortfolio.buyStock(stock, 20);*/
			

		stock = new Stock("AAL",(float) 30.0,(float) 25.5,date1,30);
		myPortfolio.addStock(stock);
		myPortfolio.buyStock(stock, 30);
		
		stock = new Stock("CAAS",(float) 20.0,(float) 15.5,date1,40);
		myPortfolio.addStock(stock);
		myPortfolio.buyStock(stock, 40);
	
		myPortfolio.updateBalance(10000);
		
		myPortfolio.removeStock("CAAS");
		myPortfolio.sellStock("AAL",-1);
		return myPortfolio;
	
	}
	

	
	

}
