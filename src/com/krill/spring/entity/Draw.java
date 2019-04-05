package com.krill.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="draw")
public class Draw {
	
	// define fields & annotate
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="application_number")
	private int applicationNumber;
	
	@Column(name="ending_period")
	private String endingPeriod;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REFRESH})
	@JoinColumn(name="job_id") // job_id, job = name of class, _ , then the 'id' column
	private Job job; // in job we use @OneToMany(mappedBy="job") to associate the job with it's draws
	
	@OneToMany(mappedBy="draw", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<LineItem> lineItemList;

	// add convenience methods for bi-directional relationship with LineItem
	public void add(LineItem tempLineItem) {
		// check if list exists, if not make one
		if (lineItemList == null) {
			lineItemList = new ArrayList<LineItem>();
		}
		
		// add line item to list
		lineItemList.add(tempLineItem);
		
		// tell tempLineItem what draw it's connected to
		tempLineItem.setDraw(this);
	}
	
	// define constructors, getters/setters, to string
	
	public Draw() {
	}
	
	public Draw(Job job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getEndingPeriod() {
		return endingPeriod;
	}

	public void setEndingPeriod(String endingPeriod) {
		this.endingPeriod = endingPeriod;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Draw [id=" + id + ", applicationNumber=" + applicationNumber + ", endingPeriod=" + endingPeriod
				+ ", job=" + job + "]";
	}

	public List<LineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(List<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}
	
}
