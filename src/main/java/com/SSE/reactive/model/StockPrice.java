package com.SSE.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class StockPrice {

	private Integer current;
	private Integer voltage;
	private String status;
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getVoltage() {
		return voltage;
	}
	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StockPrice(Integer current, Integer voltage) {
		super();
		this.current = current;
		this.voltage = voltage;
		this.status= current>voltage?"High":"Low";
	}
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
