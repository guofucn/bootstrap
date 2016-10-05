package com.jc.ssm.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalesOrder {
	private long id;
	private long userId;
	private String amazonOrderId;
	private String sellerOrderId;
	private Date purchaseDate;
	private Date lastUpdateDate;
	private String orderStatus;
	private String fulfillmentChannel;
	private String salesChannel;
	private String orderChannel;
	private String shipServiceLevel;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String county;
	private String district;
	private String stateOrRegion;
	private String postalCode;
	private String countryCode;
	private String phone;
	private BigDecimal amount;
	private String currencyCode;
	private int numberOfItemsShipped;
	private int numberOfItemsUnshipped;
	private String paymentMethod;
	private String marketplaceId;
	private String buyerEmail;
	private String buyerName;
	private String shipmentServiceLevelCategory;
	private boolean shippedByAmazonTFM;
	private String cbaDisplayableShippingLabel;
	private String orderType;
	private Date earliestShipDate;
	private Date latestShipDate;
	private Date earliestDeliveryDate;
	private Date latestDeliveryDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAmazonOrderId() {
		return amazonOrderId;
	}
	public void setAmazonOrderId(String amazonOrderId) {
		this.amazonOrderId = amazonOrderId;
	}
	public String getSellerOrderId() {
		return sellerOrderId;
	}
	public void setSellerOrderId(String sellerOrderId) {
		this.sellerOrderId = sellerOrderId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}
	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}
	public String getSalesChannel() {
		return salesChannel;
	}
	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	public String getOrderChannel() {
		return orderChannel;
	}
	public void setOrderChannel(String orderChannel) {
		this.orderChannel = orderChannel;
	}
	public String getShipServiceLevel() {
		return shipServiceLevel;
	}
	public void setShipServiceLevel(String shipServiceLevel) {
		this.shipServiceLevel = shipServiceLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStateOrRegion() {
		return stateOrRegion;
	}
	public void setStateOrRegion(String stateOrRegion) {
		this.stateOrRegion = stateOrRegion;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public int getNumberOfItemsShipped() {
		return numberOfItemsShipped;
	}
	public void setNumberOfItemsShipped(int numberOfItemsShipped) {
		this.numberOfItemsShipped = numberOfItemsShipped;
	}
	public int getNumberOfItemsUnshipped() {
		return numberOfItemsUnshipped;
	}
	public void setNumberOfItemsUnshipped(int numberOfItemsUnshipped) {
		this.numberOfItemsUnshipped = numberOfItemsUnshipped;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getShipmentServiceLevelCategory() {
		return shipmentServiceLevelCategory;
	}
	public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
		this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
	}
	public boolean isShippedByAmazonTFM() {
		return shippedByAmazonTFM;
	}
	public void setShippedByAmazonTFM(boolean shippedByAmazonTFM) {
		this.shippedByAmazonTFM = shippedByAmazonTFM;
	}
	public String getCbaDisplayableShippingLabel() {
		return cbaDisplayableShippingLabel;
	}
	public void setCbaDisplayableShippingLabel(String cbaDisplayableShippingLabel) {
		this.cbaDisplayableShippingLabel = cbaDisplayableShippingLabel;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Date getEarliestShipDate() {
		return earliestShipDate;
	}
	public void setEarliestShipDate(Date earliestShipDate) {
		this.earliestShipDate = earliestShipDate;
	}
	public Date getLatestShipDate() {
		return latestShipDate;
	}
	public void setLatestShipDate(Date latestShipDate) {
		this.latestShipDate = latestShipDate;
	}
	public Date getEarliestDeliveryDate() {
		return earliestDeliveryDate;
	}
	public void setEarliestDeliveryDate(Date earliestDeliveryDate) {
		this.earliestDeliveryDate = earliestDeliveryDate;
	}
	public Date getLatestDeliveryDate() {
		return latestDeliveryDate;
	}
	public void setLatestDeliveryDate(Date latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}
}
