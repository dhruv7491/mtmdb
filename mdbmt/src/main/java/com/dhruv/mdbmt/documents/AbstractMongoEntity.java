package com.dhruv.mdbmt.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AbstractMongoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8210850594440682797L;

	@Id
	protected String id;

	protected Long timestamp = new Date().getTime();

	@CreatedDate
	protected Date createdDate;

	@LastModifiedDate
	protected Date lastModifiedDate;

	protected Boolean active = Boolean.TRUE;

	@Indexed(unique = true, sparse = true)
	protected Long customId;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCustomId() {
		return customId;
	}

	public void setCustomId(Long customId) {
		this.customId = customId;
	}

	public void copyEntityFrom(AbstractMongoEntity source) {
		this.id = source.id;
		this.active = source.active;
		this.createdDate = source.createdDate;
		this.lastModifiedDate = source.lastModifiedDate;
		this.customId = source.customId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractMongoEntity other = (AbstractMongoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
