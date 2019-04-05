package com.krill.spring.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="line_item")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="item_number")
	private int itemNumber;
	
	@Column(name="description_of_work")
	private String descriptionOfWork;
	
	@Column(name="scheduled_value")
	private BigDecimal scheduledValue;
	
	@Column(name="previous_applications")
	private BigDecimal previousApplications;
	
	@Column(name="this_period")
	private BigDecimal thisPeriod;
	
	@Column(name="materials_stored_on_site")
	private BigDecimal materialsStoredOnSite;
	
	@Column(name="total_completed_and_stored")
	private BigDecimal totalCompletedAndStored;
	
	@Column(name="general_completion")
	private BigDecimal generalCompletion;
	
	@Column(name="balance_to_finish")
	private BigDecimal balanceToFinish;
	
	// ManyToOne to Draw
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REFRESH})
	@JoinColumn(name="draw_id") // in draw we use OneToMany so it joins the drawId to this lineItem
	private Draw draw;
	
	public LineItem() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionOfWork() {
		return descriptionOfWork;
	}

	public void setDescriptionOfWork(String drecriptionOfWork) {
		this.descriptionOfWork = drecriptionOfWork;
	}

	public BigDecimal getScheduledValue() {
		return scheduledValue;
	}

	public void setScheduledValue(BigDecimal scheduledValue) {
		this.scheduledValue = scheduledValue;
	}

	public BigDecimal getPreviousApplications() {
		return previousApplications;
	}

	public void setPreviousApplications(BigDecimal previousApplications) {
		this.previousApplications = previousApplications;
	}

	public BigDecimal getThisPeriod() {
		return thisPeriod;
	}

	public void setThisPeriod(BigDecimal thisPeriod) {
		this.thisPeriod = thisPeriod;
	}

	public BigDecimal getMaterialsStoredOnSite() {
		return materialsStoredOnSite;
	}

	public void setMaterialsStoredOnSite(BigDecimal materialsStoredOnSite) {
		this.materialsStoredOnSite = materialsStoredOnSite;
	}

	public BigDecimal getTotalCompletedAndStored() {
		return totalCompletedAndStored;
	}

	public void setTotalCompletedAndStored(BigDecimal totalCompletedAndStored) {
		this.totalCompletedAndStored = totalCompletedAndStored;
	}

	public BigDecimal getGeneralCompletion() {
		return generalCompletion;
	}

	public void setGeneralCompletion(BigDecimal generalCompletion) {
		this.generalCompletion = generalCompletion;
	}

	public BigDecimal getBalanceToFinish() {
		return balanceToFinish;
	}

	public void setBalanceToFinish(BigDecimal balanceToFinish) {
		this.balanceToFinish = balanceToFinish;
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	
}
