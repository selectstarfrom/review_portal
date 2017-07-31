package com.reviewportal.model.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected Date createdDate;

	protected String createdBy;

	protected Date modifiedDate;

	protected String modifiedBy;

	public AbstractEntity() {
		super();
	}

	public AbstractEntity(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy) {
		super();
		id = pId;
		createdDate = pCreatedDate;
		createdBy = pCreatedBy;
		modifiedDate = pModifiedDate;
		modifiedBy = pModifiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date pCreatedDate) {
		createdDate = pCreatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String pCreatedBy) {
		createdBy = pCreatedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date pModifiedDate) {
		modifiedDate = pModifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String pModifiedBy) {
		modifiedBy = pModifiedBy;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + "]";
	}

}
