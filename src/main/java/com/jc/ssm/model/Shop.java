package com.jc.ssm.model;

public class Shop {
	private Long id;
	private long userId;
	private String shopName;
	private Long placeId; //地区表ID
	private String marketPlaceId; //亚马逊定义的地区市场ID
	private String contryNo;
	private String country;
	private String url; //服务访问地址
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName.trim();
	}
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public String getMarketPlaceId() {
		return marketPlaceId;
	}
	public void setMarketPlaceId(String marketPlaceId) {
		this.marketPlaceId = marketPlaceId;
	}
	public String getContryNo() {
		return contryNo;
	}
	public void setContryNo(String contryNo) {
		this.contryNo = contryNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
