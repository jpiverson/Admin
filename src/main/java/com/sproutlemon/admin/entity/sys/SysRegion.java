package com.sproutlemon.admin.entity.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_region")
public class SysRegion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154871338712531332L;

	@Id
	@Column(name = "id")
	private int id; // 城市ID

	@Column(name = "name", length = 50, nullable = false)
	private String name; // 城市名称

	@Column(name = "parent_id")
	private int parentId; // 上级城市ID

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
