package com.myorg.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Stock {
	private String symbol;
	private float ask;
	private float bid;
	private Date date;

	 
	
	public Stock()
	{
		setSymbol("None");
		setAsk(0);
		setBid(0);
		date=new Date();
	}
	
	public Stock(String symbol, float ask, float bid, Date date)
	{
		setSymbol(symbol);
		setAsk(ask);
		setBid(bid);
		setDate(date);
	}
	public Stock(Stock stock)
	{
		setSymbol(stock.getSymbol());
		setAsk(stock.getAsk());
		setBid(stock.getBid());
		setDate(stock.getDate());
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
	
	
	
	public Date getDate() {
		return date;
	}
	

	
	public  void setDate(Date date)
	{
		this.date = date;
		
	}

	public  void remove () throws Throwable {
	    
		super.finalize();
	}

	public String getHtmlDescription()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = df.format(getDate());
		String resultStr = new String("<b>Stock symbol</b>: "+this.getSymbol()+"  <b>Ask</b>: "+this.getAsk()+"  <b>Bid</b>: "+this.getBid()+"  <b>Date</b>: "+dateStr);
		return resultStr;}
}
