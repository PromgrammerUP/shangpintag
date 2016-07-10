package org.javachina.shangpin.view.action;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class AdddoForm extends ActionForm {
	private String name;
	private double price;
	private Date inputDate;
	private int leixingId;
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
}