package com.myorg.javacourse.model;
import com.myorg.javacourse.exception.*;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;


public class Portfolio implements PortfolioInterface {
	private static final int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private float balance=0;
	
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD}
	
	
	
	public Portfolio()
	{
		this.portfolioSize = 0;
		this.balance=0;
		this.setTitle("portfolio");
		stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio(Stock[] stockArray) {
		this.title = new String();
		this.portfolioSize = getPortfolioSize();
		this.balance = getBalance();
		this.stocks = stockArray;
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
		setStockSize(portfolio.getPortfolioSize());
		setBalance(portfolio.getBalance());

		for(int i=0; i<portfolioSize; i++)
			stocks[i]= new Stock(new Stock(portfolio.stocks[i]));
	
		
	
		
	}
	
	
	public void addStock(Stock stock) throws PortfolioFullException,StockAlreadyExistsException, StockNotExistException{
			
		if (this.portfolioSize == MAX_PORTFOLIO_SIZE) {
			throw new PortfolioFullException();
		}
		if (stock == null) {
			throw new StockNotExistException("Check input validance!");
		}
		for (int i = 0; i < this.portfolioSize; i++) {
			if (stock.getSymbol().equals(stocks[i].getSymbol())) {
				throw new StockAlreadyExistsException(
						"You already own that stock!");
			}
		}
		if (this.portfolioSize < MAX_PORTFOLIO_SIZE) {
			stocks[this.portfolioSize] = stock;
			((Stock) stocks[this.portfolioSize]).setStockQuantity(0);
																	
																
			this.portfolioSize++;
		}
	}
	
	
		
			
	
	
	
		public void removeStock(String symbol) throws StockNotExistException, BalanceException
		 {
	boolean StillRun = true;
	if (symbol == null) { 
							
		throw new StockNotExistException("invalid input, please try again");
	}
	if (portfolioSize == 1
			|| symbol.equals(stocks[portfolioSize - 1].getSymbol())) {
		
		
		this.sellStock(stocks[portfolioSize - 1].getSymbol(), -1);

		stocks[portfolioSize - 1] = null;
		portfolioSize--;
		// operation succeed
	}
	for (int i = 0; i < portfolioSize && StillRun; i++) { 
		if (symbol.equals(stocks[i].getSymbol())) {
			this.sellStock(stocks[portfolioSize - 1].getSymbol(), -1);
			stocks[i] = stocks[portfolioSize - 1];
			stocks[portfolioSize - 1] = null;
			portfolioSize--;
			StillRun = false; 
		}
	}
	if (StillRun == true){
		throw new StockNotExistException();
	}
}

	
	public void updateBalance(float amount) throws BalanceException {
		float temp = this.balance + amount;
		if (temp < 0) {
			throw new BalanceException();
		} else {
			this.balance = temp;
			System.out.println("Balance updated!");
		}
	}
	
	

	
	
	public boolean sellStock(String symbol,int quantity) throws StockNotExistException, BalanceException
	 {
	

		for(int i=0; i<portfolioSize; i++)
			if(symbol.equals(stocks[i].getSymbol()))
			{
				if(quantity == -1) {
					float NewAmount=stocks[i].getStockQuantity()*stocks[i].getBid();
					updateBalance(NewAmount);
					stocks[i].setStockQuantity(0);
					return true;
				}
				else if(stocks[i].getStockQuantity()-quantity < 0){
					throw new StockNotExistException();
				}
				else if (stocks[i].getStockQuantity()-quantity >= 0){
					stocks[i].setStockQuantity(stocks[i].getStockQuantity()-quantity);
					float amount = quantity*stocks[i].getBid();
					updateBalance(amount);
					return true;
					
				}
				else
					throw new StockNotExistException(symbol);
			}
	
		
		return false;
	}
	
	public boolean buyStock(Stock stock, int quantity )throws StockNotExistException, BalanceException, PortfolioFullException, StockAlreadyExistsException
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
						throw new BalanceException();
					}
					else
					{
					stocks[i].setStockQuantity(stocks[i].getStockQuantity()+ (int)(balance/stocks[i].getAsk()));
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
					stocks[i].setStockQuantity(stocks[i].getStockQuantity()+quantity);
					updateBalance(spent1);
					return true;
					}
				}
			}
			else
			throw new StockNotExistException();
		
			
		}
		
			
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
				sum+=stocks[i].getStockQuantity() * stocks[i].getAsk();

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

	public StockInterface[] getStocks() {
		return (StockInterface[]) stocks;
	}
	
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public void setStockSize(int stockIndex) {
		this.portfolioSize = stockIndex;
	}
	public int getPortfolioSize() {
		return portfolioSize;
	}
	
	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getBalance() {
		return balance;
	}
	
public StockInterface findStock(String symbol) {
		
		for (int i = 0; i < getPortfolioSize(); i++) {
			if (stocks[i].getSymbol().equals(symbol)) 
					return this.stocks[i];
		}
		return null;
		}
	





	
	
	
	
	
}
