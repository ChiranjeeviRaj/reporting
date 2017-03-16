package com.jp.market.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.jp.market.DataMock;
import com.jp.market.model.ReportModel;
import com.jp.market.model.StockInstructions;
import com.jp.market.model.StockInstructions.Currency;
import com.jp.market.model.StockInstructions.TradeType;
import com.jp.market.service.ReportService;

public class ReportServiceImpl implements ReportService {

	private static Logger log = Logger.getLogger(ReportServiceImpl.class);

	public List<ReportModel> getUSDSettledIncomingEverDay() {
		return getSettledIncome(TradeType.SELL);
	}

	public List<ReportModel> getUSDSettledOutcomingEverDay() {
		return getSettledIncome(TradeType.BUY);
	}

	public List<ReportModel> getEntitiesByRank() {
		List<ReportModel> reportModels = new ArrayList<ReportModel>();

		List<ReportModel> report1 = getUSDSettledIncomingEverDay();

		Collections.sort(report1, new Comparator<ReportModel>() {
			public int compare(ReportModel rm1, ReportModel rm2) {
				return rm1.getAmountOfTrade() > rm2.getAmountOfTrade() ? 1 : 0;
			}
		});

		List<ReportModel> report2 = getUSDSettledOutcomingEverDay();

		Collections.sort(report2, new Comparator<ReportModel>() {
			public int compare(ReportModel rm1, ReportModel rm2) {
				return rm1.getAmountOfTrade() > rm2.getAmountOfTrade() ? 1 : 0;
			}
		});

		reportModels.addAll(report1);
		reportModels.addAll(report2);

		return reportModels;
	}

	/**
	 * 
	 * @param tradeType
	 *            type of trade BUY/SELL
	 * @return amount of trade for each all the settlement days
	 */
	private List<ReportModel> getSettledIncome(TradeType tradeType) {
		Map<Date, Double> settledIncome = new TreeMap<Date, Double>();
		Double temp;
		/**
		 * Group by total trade amount for each day
		 */
		for (StockInstructions si : DataMock.Db().values()) {
			if (si.getType().equals(tradeType)) {
				if (settledIncome.containsKey(ruleTradeSettle(si))) {
					temp = settledIncome.get(ruleTradeSettle(si)) + si.getUSDAmountOfTrade();
				} else {
					temp = si.getUSDAmountOfTrade();
				}
				settledIncome.put(ruleTradeSettle(si), temp);
			}
		}

		// Build Reporting models for logging
		List<ReportModel> reportModels = new ArrayList<ReportModel>();
		for (Entry<Date, Double> entry : settledIncome.entrySet()) {
			ReportModel model = new ReportModel();
			model.setAmountOfTrade(entry.getValue());
			model.setSettlementDate(entry.getKey());
			log.info(model);
			reportModels.add(model);
		}
		return reportModels;
	}

	/**
	 * A work week starts Monday and ends Friday, unless the currency of the
	 * trade is AED or SAR, where the work week starts Sunday and ends Thursday.
	 * No other holidays to be taken into account.
	 * 
	 * @param si
	 * @return
	 */
	private Date ruleTradeSettle(StockInstructions si) {

		if (!(si.getCurrency().equals(Currency.AED) || si.getCurrency().equals(Currency.SAR))) {
			// 2,6
			return getDay(si.getSettlementDate()).ordinal() <= DayOfWeek.Monday.ordinal()
					&& getDay(si.getSettlementDate()).ordinal() >= DayOfWeek.Friday.ordinal() ? si.getSettlementDate()
							: getNextWorkingDate(si.getSettlementDate(), DayOfWeek.Monday.ordinal());
		} else {
			return getDay(si.getSettlementDate()).ordinal() <= DayOfWeek.Sunday.ordinal()
					&& getDay(si.getSettlementDate()).ordinal() >= DayOfWeek.Thursday.ordinal() ? si.getSettlementDate()
							: getNextWorkingDate(si.getSettlementDate(), DayOfWeek.Sunday.ordinal());
		}
	}

	private Date getNextWorkingDate(Date settlementDate, int ordinal) {
		Calendar c = Calendar.getInstance();
		c.setTime(settlementDate);
		c.set(Calendar.DAY_OF_YEAR, getNoDays(settlementDate, ordinal));
		return c.getTime();
	}

	private int getNoDays(Date settlementDate, int ordinal) {
		int day = getDay(settlementDate).ordinal();
		int targetDay = DayOfWeek.getDayByOrdinal(ordinal).ordinal();
		return targetDay > day ? (targetDay - day) : (7 - day + targetDay);
	}

	private DayOfWeek getDay(Date date) {
		// Sunday to Saturday.
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int day_of_week = c.get(Calendar.DAY_OF_WEEK);
		for (DayOfWeek day : DayOfWeek.values()) {
			if (day.ordinal() == day_of_week) {
				return day;
			}
		}

		return null;
	}

	public static enum DayOfWeek {
		None, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

		public static DayOfWeek getDayByOrdinal(int ordinal) {
			for (DayOfWeek day : DayOfWeek.values()) {
				if (day.ordinal() == ordinal) {
					return day;
				}
			}
			return null;
		}

	}

}
