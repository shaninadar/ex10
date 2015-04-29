package com.myorg.javacourse.model;
import com.myorg.javacourse.Stock;

public class Portfolio {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int stockIndex = 0;
	
	
	public Portfolio() {}
	
		

	public Portfolio(String t) {
		t=this.title;
		
	}
	
	
	public void addStock(Stock stock) {
		
		if(stock != null && stockIndex < MAX_PORTFOLIO_SIZE) {
			this.stocks[stockIndex] = stock;
			stockIndex++;
		}else {
			System.out.println("Sorry, the portfolio is full, or is stock is null!");
		}
	}
		
		
		public String getHtmlString() {
			
			String ret = new String( "<h1>" + title + "</h1> <br>" );
			
			for(int i = 0; i < stockIndex ;i++) {
				Stock current = this.stocks[i];
				ret += this.stocks[i].getHtmlDescription() + "<br>";
			}
			
			return ret;
		}
		
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public Stock[] getStocks() {
		return stocks;
	}
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	
	
}
