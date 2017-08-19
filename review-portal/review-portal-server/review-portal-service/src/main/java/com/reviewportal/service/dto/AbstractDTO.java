package com.reviewportal.service.dto;


import java.util.Date;

/**
 * @author imfroz
 *
 */
public abstract class AbstractDTO {

	protected Long id;

	protected Date createdDate;

	protected String createdBy;

	protected Date modifiedDate;

	protected String modifiedBy;

	public AbstractDTO() {
		super();
	}

	public AbstractDTO(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy) {
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
        return "AbstractDTO [id=" + id + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", modifiedDate="
                + modifiedDate + ", modifiedBy=" + modifiedBy + "]";
    }

}
