package org.javachina.shangpin.view.action;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class UpdateDoForm extends ActionForm {
	private int id;
	private String name;
	private double price; 
	private Date intputDate;
	private int leixingId;
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
	public Date getIntputDate() {
		return intputDate;
	}
	public void setIntputDate(Date intputDate) {
		this.intputDate = intputDate;
	}
	public int getLeixingId() {
		return leixingId;
	}
	public void setLeixingId(int leixingId) {
		this.leixingId = leixingId;
	}
}
