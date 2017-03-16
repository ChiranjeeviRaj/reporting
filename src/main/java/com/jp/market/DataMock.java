package com.jp.market;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jp.market.model.StockInstructions.Currency;
import com.jp.market.model.StockInstructions.TradeType;

import org.apache.log4j.Logger;

import com.jp.market.model.StockInstructions;

public class DataMock {

	private static Logger log = Logger.getLogger(Client.class);

	// memory db
	public static Map<String, StockInstructions> Db() {
		HashMap<String, StockInstructions> db = new HashMap<String, StockInstructions>();
		db.put("FOO", new StockInstructions("FOO", TradeType.BUY, 0.50, Currency.SGP, getDate(01,01,2016), getDate(02,01,2016), 200l, 100.25));
		db.put("BAR", new StockInstructions("BAR", TradeType.SELL, 0.22, Currency.AED, getDate(05,01,2016), getDate(07,01,2016), 450l, 150.5));
		
		db.put("POP", new StockInstructions("POP", TradeType.BUY, 0.50, Currency.ANG, getDate(07,01,2016), getDate(9,01,2016), 210l, 101.25));
		db.put("ALE", new StockInstructions("ALE", TradeType.SELL, 0.22, Currency.INR, getDate(12,01,2016), getDate(14,01,2016), 460l, 151.5));
		
		db.put("GIN", new StockInstructions("GIN", TradeType.BUY, 0.50, Currency.SGP, getDate(14,02,2016), getDate(16,02,2016), 300l, 100.25));
		db.put("JOE", new StockInstructions("JOE", TradeType.SELL, 0.22, Currency.INR, getDate(13,02,2016), getDate(15,02,2016), 400l, 145.5));
		

		return db;
	}

	private static Date getDate(int day, int month, int year) {
		Calendar dateIns = Calendar.getInstance();
		dateIns.set(year, month, day);
		return dateIns.getTime();
	}

	
	
}
