package com.jc.ssm.model;

import java.math.BigDecimal;

public class OrderDetail {
	private long id;
	private long salesOrderId;
	private String  asin;
	private String sellerSKU;
	private String orderItemId;
	private String title;
	private int quantityOrdered;
	private int quantityShipped;
	private String giftMessageText;
	private String giftWrapLevel;
	private BigDecimal itemPrice;
	private String itemPriceCurrencyCode;
	private BigDecimal shippingPrice;
	private String shippingPriceCurrencyCode;
	private BigDecimal giftWrapPrice;
	private String giftWrapPriceCurrencyCode;
	private BigDecimal itemTax;
	private String itemTaxCurrencyCode;
	private BigDecimal shippingTax;
	private String shippingTaxCurrencyCode;
	private BigDecimal giftWrapTax;
	private String giftWrapTaxCurrencyCode;
	private BigDecimal shippingDiscount;
	private String shippingDiscountCurrencyCode;
	private BigDecimal promotionDiscount;
	private String promotionDiscountCurrencyCode;
	private BigDecimal codFee;
	private String codFeeCurrencyCode;
	private BigDecimal codFeeDiscount;
	private String codFeeDiscountCurrencyCode;
	
	public BigDecimal getCodFee() {
		return codFee;
	}
	public void setCodFee(BigDecimal codFee) {
		this.codFee = codFee;
	}
	public String getCodFeeCurrencyCode() {
		return codFeeCurrencyCode;
	}
	public void setCodFeeCurrencyCode(String codFeeCurrencyCode) {
		this.codFeeCurrencyCode = codFeeCurrencyCode;
	}
	public String getCodFeeDiscountCurrencyCode() {
		return codFeeDiscountCurrencyCode;
	}
	public void setCodFeeDiscountCurrencyCode(String codFeeDiscountCurrencyCode) {
		this.codFeeDiscountCurrencyCode = codFeeDiscountCurrencyCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getSellerSKU() {
		return sellerSKU;
	}
	public void setSellerSKU(String sellerSKU) {
		this.sellerSKU = sellerSKU;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public int getQuantityShipped() {
		return quantityShipped;
	}
	public void setQuantityShipped(int quantityShipped) {
		this.quantityShipped = quantityShipped;
	}
	public String getGiftMessageText() {
		return giftMessageText;
	}
	public void setGiftMessageText(String giftMessageText) {
		this.giftMessageText = giftMessageText;
	}
	public String getGiftWrapLevel() {
		return giftWrapLevel;
	}
	public void setGiftWrapLevel(String giftWrapLevel) {
		this.giftWrapLevel = giftWrapLevel;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemPriceCurrencyCode() {
		return itemPriceCurrencyCode;
	}
	public void setItemPriceCurrencyCode(String itemPriceCurrencyCode) {
		this.itemPriceCurrencyCode = itemPriceCurrencyCode;
	}
	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public String getShippingPriceCurrencyCode() {
		return shippingPriceCurrencyCode;
	}
	public void setShippingPriceCurrencyCode(String shippingPriceCurrencyCode) {
		this.shippingPriceCurrencyCode = shippingPriceCurrencyCode;
	}
	public BigDecimal getGiftWrapPrice() {
		return giftWrapPrice;
	}
	public void setGiftWrapPrice(BigDecimal giftWrapPrice) {
		this.giftWrapPrice = giftWrapPrice;
	}
	public BigDecimal getItemTax() {
		return itemTax;
	}
	public void setItemTax(BigDecimal itemTax) {
		this.itemTax = itemTax;
	}
	public String getItemTaxCurrencyCode() {
		return itemTaxCurrencyCode;
	}
	public void setItemTaxCurrencyCode(String itemTaxCurrencyCode) {
		this.itemTaxCurrencyCode = itemTaxCurrencyCode;
	}
	public BigDecimal getShippingTax() {
		return shippingTax;
	}
	public void setShippingTax(BigDecimal shippingTax) {
		this.shippingTax = shippingTax;
	}
	public String getShippingTaxCurrencyCode() {
		return shippingTaxCurrencyCode;
	}
	public void setShippingTaxCurrencyCode(String shippingTaxCurrencyCode) {
		this.shippingTaxCurrencyCode = shippingTaxCurrencyCode;
	}
	public BigDecimal getGiftWrapTax() {
		return giftWrapTax;
	}
	public void setGiftWrapTax(BigDecimal giftWrapTax) {
		this.giftWrapTax = giftWrapTax;
	}
	public String getGiftWrapTaxCurrencyCode() {
		return giftWrapTaxCurrencyCode;
	}
	public void setGiftWrapTaxCurrencyCode(String giftWrapTaxCurrencyCode) {
		this.giftWrapTaxCurrencyCode = giftWrapTaxCurrencyCode;
	}
	public BigDecimal getShippingDiscount() {
		return shippingDiscount;
	}
	public void setShippingDiscount(BigDecimal shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
	}
	public String getShippingDiscountCurrencyCode() {
		return shippingDiscountCurrencyCode;
	}
	public void setShippingDiscountCurrencyCode(String shippingDiscountCurrencyCode) {
		this.shippingDiscountCurrencyCode = shippingDiscountCurrencyCode;
	}
	public BigDecimal getPromotionDiscount() {
		return promotionDiscount;
	}
	public void setPromotionDiscount(BigDecimal promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
	}
	public String getPromotionDiscountCurrencyCode() {
		return promotionDiscountCurrencyCode;
	}
	public void setPromotionDiscountCurrencyCode(String promotionDiscountCurrencyCode) {
		this.promotionDiscountCurrencyCode = promotionDiscountCurrencyCode;
	}
	public long getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public String getGiftWrapPriceCurrencyCode() {
		return giftWrapPriceCurrencyCode;
	}
	public void setGiftWrapPriceCurrencyCode(String giftWrapPriceCurrencyCode) {
		this.giftWrapPriceCurrencyCode = giftWrapPriceCurrencyCode;
	}
	public BigDecimal getCodFeeDiscount() {
		return codFeeDiscount;
	}
	public void setCodFeeDiscount(BigDecimal codFeeDiscount) {
		this.codFeeDiscount = codFeeDiscount;
	}
}