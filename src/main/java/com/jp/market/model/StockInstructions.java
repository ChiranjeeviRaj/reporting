package com.jp.market.model;

import java.util.Date;

/**
 * 
 * @author Chiranjeevi
 *
 */
public class StockInstructions {

	private String entity;
	private TradeType type;
	private Double agreedFx;
	private Currency currency;
	private Date instructionDate;
	private Date settlementDate;
	private Long units;
	private Double pricePerUnits;

	public StockInstructions(String entity, TradeType type, Double agreedFx, Currency currency, Date instructionDate,
			Date settlementDate, Long units, Double pricePerUnits) {
		super();
		this.entity = entity;
		this.type = type;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnits = pricePerUnits;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

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

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public Double getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(Double pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	public double getUSDAmountOfTrade() {
		return this.pricePerUnits * this.units * this.pricePerUnits;
	}

	@Override
	public String toString() {
		return "StockInstructions [entity=" + entity + ", agreedFx=" + agreedFx + ", currency=" + currency
				+ ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", units=" + units
				+ ", pricePerUnits=" + pricePerUnits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreedFx == null) ? 0 : agreedFx.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((instructionDate == null) ? 0 : instructionDate.hashCode());
		result = prime * result + ((pricePerUnits == null) ? 0 : pricePerUnits.hashCode());
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		StockInstructions other = (StockInstructions) obj;
		if (agreedFx == null) {
			if (other.agreedFx != null)
				return false;
		} else if (!agreedFx.equals(other.agreedFx))
			return false;
		if (currency != other.currency)
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (instructionDate == null) {
			if (other.instructionDate != null)
				return false;
		} else if (!instructionDate.equals(other.instructionDate))
			return false;
		if (pricePerUnits == null) {
			if (other.pricePerUnits != null)
				return false;
		} else if (!pricePerUnits.equals(other.pricePerUnits))
			return false;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}

	public TradeType getType() {
		return type;
	}

	public void setType(TradeType type) {
		this.type = type;
	}

	/**
	 * The below codes copied from the below URL
	 * http://apps.cybersource.com/library/documentation/sbc/quickref/currencies.pdf
	 * 
	 * @author d609093
	 *
	 */
	public static enum Currency {
		AED, AFN, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD, BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, BWP, BYR, BZD, CAD, CDF, CHF, CLP, CNY, COP, CRC, CSK, CVE, CZK, DJF, DKK, DOP, DZD, EGP, ERN, ETB, EUR, FJD, FKP, GBP, GEL, GHS, GIP, GMD, GNF, GTQ, GYD, HKD, HNL, HRK, HTG, HUF, IDR, ILS, INR, ISK, JMD, JOD, JPY, KES, KGS, KHR, KMF, KRW, KWD, KYD, KZT, LAK, LBP, LKR, LRD, LTL, LVL, MAD, MDL, MGA, MKD, MMK, MNT, MOP, MRO, MUR, MVR, MWK, MXN, MYR, MZN, NAD, NGN, NIO, NOK, NPR, NZD, OMR, PAB, PEN, PGK, PHP, PKR, PLN, PYG, QAR, RON, RSD, RUB, RWF, SAR, SBD, SCR, SEK, SGD, SHP, SLL, SOS, SRD, STD, SYP, SZL, THB, TJS, TND, TOP, TRY, TTD, TWD, TZS, UAH, UGX, USD, UYU, UZS, VEF, VND, VUV, WST, XAF, XCD, XOF, XPF, YER, ZAR, ZMW, ZWD, SGP
	}

	public static enum TradeType {
		BUY, SELL
	}

}
