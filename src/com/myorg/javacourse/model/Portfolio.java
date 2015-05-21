package com.myorg.javacourse.model;
import com.myorg.javacourse.model.Stock;

public class Portfolio {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private float balance=0;
	
	public  enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	
	
	public Portfolio()
	{
		this.portfolioSize = 0;
		this.balance=0;
		this.setTitle("portfolio");
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
		

	public Portfolio(String t) {
		this.portfolioSize = 0;
		this.balance=0;
		t=this.title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE]; 
		
	}
	public Portfolio(Portfolio portfolio)
	{
		this();
		setTitle(portfolio.getTitle());
		setStockSize(portfolio.getStockSize());
		setBalance(portfolio.getBalance());

		for(int i=0; i<portfolioSize; i++)
			stocks[i]= new Stock(portfolio.getStocks()[i]);
		
	
		
	}
	
	
	public void addStock(Stock stock) {
			
				if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE ) 
				{
				this.stocks[portfolioSize] = stock;
			
				portfolioSize++;
				}else {
				System.out.println("Can�t add new stock, portfolio can have only" +MAX_PORTFOLIO_SIZE+"stocks");
				}
				
	
		
			
	}
	
	public void removeStock(String symbol) 
	{
		Stock[] newStocks= new Stock[MAX_PORTFOLIO_SIZE];
		int j=0;
		sellStock(symbol,-1) ;
		for (int i =0; i<portfolioSize ;i++)
		{
		
			if(symbol.equals(stocks[i].getSymbol())==false )
			{
				newStocks[j]=stocks[i];
				j++;
			}
			
		}
		stocks=newStocks;
		portfolioSize--;
		
	}
	

	
	public void updateBalance(float amount)
	{
		balance+=amount;
	}
	
	

	
	
	public boolean sellStock(String symbol,int quantity) 
	{

		for(int i=0; i<portfolioSize; i++)
			if(symbol.equals(stocks[i].getSymbol()))
			{
				if(quantity == -1) {
					float NewAmount=stocks[i].getQuantity()*stocks[i].getBid();
					updateBalance(NewAmount);
					stocks[i].setQuantity(0);
					return true;
				}
				else if(stocks[i].getQuantity()-quantity < 0){
					System.out.println("Not enough stocks to sell");
					return false;
				}
				else if (stocks[i].getQuantity()-quantity >= 0){
					stocks[i].setQuantity(stocks[i].getQuantity()-quantity);
					float amount = quantity*stocks[i].getBid();
					updateBalance(amount);
					return true;
					
				}
			}
	
		
		return false;
	}
	
	public boolean buyStock(Stock stock, int quantity )
	{

		for(int i=0; i<portfolioSize; i++)
		{
			if(stock.getSymbol().equals(stocks[i].getSymbol()))
			{
				if( quantity == -1)
				{
					float spent = ((int)(balance/stocks[i].getAsk()) *stocks[i].getAsk())/(-1); 
					if (spent/(-1) > balance)
					{
						System.out.println(" Not enough balance to complete purchase.");
					return false;
					}
					else
					{
					stocks[i].setQuantity(stocks[i].getQuantity()+ (int)(balance/stocks[i].getAsk()));
					updateBalance(spent);
					return true;
					}
				}
				else
				{
					float spent1=(quantity*stocks[i].getAsk())/(-1);
					if (spent1/(-1) > balance)
					{
						System.out.println(" Not enough balance to complete purchase.");
					return false;
					}
					else
					{
					stocks[i].setQuantity(stocks[i].getQuantity()+quantity);
					updateBalance(spent1);
					return true;
					}
				}
			}
		
			
		}
		
			System.out.println("The stock is not exists");
			addStock(stock);
			return true;
	
	}
	
	


	
	
		
	
	
		public String getHtmlString() {
			
			String str = new String( "<h1>" + title + "</h1> <br>" );
			
			str +="<b>Total Portfolio Value: </b>" + getTotalValue() +"$ <b>Total Stocks Value: </b>"+ getStocksValue() + "$ <b>Balance: </b>"+ getBalance() +"$<br>";
			for(int i = 0; i < portfolioSize ;i++) {
				Stock current = this.stocks[i];
				str += current.getHtmlDescription() + "<br>";
			}
			
			return str;
		}
		
	
		public float getStocksValue()
		{
			float sum =0;
			for(int i =0; i<portfolioSize; i++)
				sum+=stocks[i].getQuantity() * stocks[i].getBid();

			return  sum;
		}
		
		public float getTotalValue()
		{
			return getBalance() + getStocksValue();
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
	
	//setter
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public void setStockSize(int stockIndex) {
		this.portfolioSize = stockIndex;
	}
	public int getStockSize() {
		return portfolioSize;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getBalance() {
		return balance;
	}




	
	
	
	
	
}
