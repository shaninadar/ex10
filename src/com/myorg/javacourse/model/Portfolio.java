package com.myorg.javacourse.model;
import com.myorg.javacourse.model.Stock;

public class Portfolio {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int stockIndex = 0;
	public  enum recommendation {BUY,SELL,REMOVE,HOLD};
	
	
	public Portfolio()
	{
		stockIndex = 0;
		this.setTitle("portfolio");
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
		

	public Portfolio(String t) {
		stockIndex = 0;
		t=this.title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE]; 
		
	}
	public Portfolio(Portfolio portfolio)
	{
		this();
		setTitle(portfolio.getTitle());
		setStockIndex(portfolio.getStockIndex());

		for(int i=0; i<stockIndex; i++)
			stocks[i]= new Stock(portfolio.getStocks()[i]);
		
	
		
	}
	
	
	public void addStock(Stock stock) {
		
		if(stock != null && stockIndex < MAX_PORTFOLIO_SIZE) {
			this.stocks[stockIndex] = stock;
			stockIndex++;
		}else {
			System.out.println("Sorry, the portfolio is full, or is stock is null!");
		}
	
	}
	
	public void removeStockAtIndex(int index)
	{
		Stock[] newStocks= new Stock[MAX_PORTFOLIO_SIZE];
		int j=0;
		for (int i =0; i<MAX_PORTFOLIO_SIZE ;i++)
		{
			if (i!=index)
			{
				newStocks[j]=stocks[i];
				j++;
			}
			
		}
		stocks=newStocks;
		stockIndex--;
		
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

	public void setStockIndex(int stockIndex) {
		this.stockIndex = stockIndex;
	}
	public int getStockIndex() {
		return stockIndex;
	}
	
	
}
