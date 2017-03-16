package com.jp.market.model;

import java.util.Date;

import com.jp.market.model.StockInstructions.TradeType;

public class ReportModel {

	private Date instructionDate;
	private Date settlementDate;
	private Double amountOfTrade;

	private TradeType tradeType;
	private Double tradeAmount;

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public Double getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Double tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Double getAmountOfTrade() {
		return amountOfTrade;
	}

	public void setAmountOfTrade(Double amountOfTrade) {
		this.amountOfTrade = amountOfTrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOfTrade == null) ? 0 : amountOfTrade.hashCode());
		result = prime * result + ((instructionDate == null) ? 0 : instructionDate.hashCode());
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + ((tradeAmount == null) ? 0 : tradeAmount.hashCode());
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportModel other = (ReportModel) obj;
		if (amountOfTrade == null) {
			if (other.amountOfTrade != null)
				return false;
		} else if (!amountOfTrade.equals(other.amountOfTrade))
			return false;
		if (instructionDate == null) {
			if (other.instructionDate != null)
				return false;
		} else if (!instructionDate.equals(other.instructionDate))
			return false;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		if (tradeAmount == null) {
			if (other.tradeAmount != null)
				return false;
		} else if (!tradeAmount.equals(other.tradeAmount))
			return false;
		if (tradeType != other.tradeType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReportModel [instructionDate=" + instructionDate + ", settlementDate=" + settlementDate
				+ ", amountOfTrade=" + amountOfTrade + ", tradeType=" + tradeType + ", tradeAmount=" + tradeAmount
				+ "]";
	}

}
