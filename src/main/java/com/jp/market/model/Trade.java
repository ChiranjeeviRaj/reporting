package com.jp.market.model;

import com.jp.market.model.StockInstructions.TradeType;

/**
 * 
 * @author Chiraneevi
 *
 */
public class Trade {

	private TradeType type;
	private Integer quantity;
	private Double price;

	public Trade(TradeType type, Integer quantity, Double price) {
		this.setType(type);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	@Override
	public String toString() {
		return "Trade [type=" + type + ", quantity=" + quantity + ", price=" + price + "]";
	}

	/**
	 * @return the type
	 */
	public TradeType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TradeType type) {
		this.type = type;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}