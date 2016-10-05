package com.jc.ssm.model;

public class MarketPlace {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarketPlaceId() {
		return marketPlaceId;
	}
	public void setMarketPlaceId(String marketPlaceId) {
		this.marketPlaceId = marketPlaceId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MarketPlace [id=" + id + ", marketPlaceId=" + marketPlaceId + ", url=" + url + ", countryNo="
				+ countryNo + ", country=" + country + "]";
	}
	public String getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String marketPlaceId;
	private String url;
	private String countryNo;
	private String country;
}
