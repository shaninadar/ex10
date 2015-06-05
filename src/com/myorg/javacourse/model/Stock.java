package com.myorg.javacourse.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.algo.model.StockInterface;
import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;



public class Stock implements StockInterface {
	private String symbol;
	private float ask;
	private float bid;
	private int quantity;
	private transient java.util.Date date;
	private com.myorg.javacourse.service.PortfolioManager.ALGO_RECOMMENDATION recommendation;

	 
	
	public Stock()
	{
		setSymbol("None");
		setAsk(0);
		setBid(0);
		setStockQuantity(0);
		date=new Date(0);
	}
	
	public Stock(String symbol, float ask, float bid, Date date,int quantity)
	{
		setSymbol(symbol);
		setAsk(ask);
		setBid(bid);
		setStockQuantity(quantity);
		this.date = date;
	}
	public Stock(Stock stock)
	{
		
		setSymbol(stock.getSymbol());
		setAsk(stock.getAsk());
		setBid(stock.getBid());
		setStockQuantity(stock.getStockQuantity());
		this.date = new java.util.Date(stock.getDate().getTime());
	}


	 public String getSymbol() {
		return symbol;
	}
	 
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	
	
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	
	
	
	public java.util.Date getDate() {
		return date;
	}
	

	
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public void setDate(long time) {
		this.date = new Date(time * 1000);
	}
	public int getStockQuantity()
	{
		return quantity;
	}
	public void setStockQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public com.myorg.javacourse.service.PortfolioManager.ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(com.myorg.javacourse.service.PortfolioManager.ALGO_RECOMMENDATION algo_RECOMMENDATION) {
		this.recommendation = algo_RECOMMENDATION;
	}


	public String getHtmlDescription()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = df.format(getDate());
		String resultStr = new String("<b>Stock symbol</b>: "+this.getSymbol()+"  <b>Ask</b>: "+this.getAsk()+"  <b>Bid</b>: "+this.getBid()+"  <b>Date</b>: "+dateStr+"<b>Stock Quantity</b>: "+this.getStockQuantity());
		return resultStr;}
}

