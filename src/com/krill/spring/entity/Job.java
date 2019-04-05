package com.krill.spring.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String name;
	
	@Column(name="address")
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String address;
	
	@Column(name="owner")
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String owner;
	
	@Column(name="contractor")
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String contractor;
	
	// this should probably come from a total of line items in DrawTemplate with the TDC
	@Column(name="total_cost")
	private BigDecimal totalCost;
	
	// looks at the "job" property in the draw class '@JoinColumn name="job"'
	@OneToMany(mappedBy="job",cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Draw> drawList;
	
	// add convenience methods for bi-directional relationship with Draw
	public void add(Draw tempDraw) {
		
		// check if the list exists, if not make it
		if(drawList == null) {
			drawList = new ArrayList<Draw>();
		}
		
		// add tempDraw to the draw list
		drawList.add(tempDraw);
		
		// set the draw to the job it's connected to
		tempDraw.setJob(this);
	}
	
	public Job() {}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public List<Draw> getDrawList() {
		return drawList;
	}

	public void setDrawList(List<Draw> drawList) {
		this.drawList = drawList;
	}

	@Override
	public String toString() {
		return "JobEntity [id=" + id + ", name=" + name + ", address=" + address + ", owner=" + owner + ", contractor="
				+ contractor + ", totalCost=" + totalCost + "]";
	}
	
	
}
