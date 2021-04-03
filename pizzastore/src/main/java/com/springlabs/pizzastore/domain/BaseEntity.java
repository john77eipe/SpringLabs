package com.springlabs.pizzastore.domain;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;

public abstract class BaseEntity implements Persistable<Long>, Serializable {

	@Override
	public boolean isNew() {
		return this.getId() == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getId() == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}
		BaseEntity that = (BaseEntity) obj;
		return this.getId().equals(that.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.getId() == null ? 0 : this.getId().hashCode();
	}
	
}