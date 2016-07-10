package org.javachina.shangpin.dto;

import java.sql.Date;

public class ShangpinDto {
	private int id; 
	private String name;
	private double price;
	private Date inputDate;
	private int leixingId;
	public ShangpinDto(int id, String name, double price, Date inputDate, int leixingId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inputDate = inputDate;
		this.leixingId = leixingId;
	}
	public ShangpinDto() {
		super();
	}
	private String leixingName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public int getLeixingId() {
		return leixingId;
	}
	public void setLeixingId(int leixingId) {
		this.leixingId = leixingId;
	}
	public String getLeixingName() {
		return leixingName;
	}
	public void setLeixingName(String leixingName) {
		this.leixingName = leixingName;
	}
}
