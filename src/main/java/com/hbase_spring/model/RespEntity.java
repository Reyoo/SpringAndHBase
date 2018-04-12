package com.hbase_spring.model;

import java.io.Serializable;

import com.sun.source.doctree.SerialDataTree;

/**
 * @deprecated 和hbase响应实体对象
 */

public class RespEntity implements Serializable {

	// 主键
	private String rowName;

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// 列族
	private String familyName;
	// 可以看做列
	private String qualifier;
	// 值
	private String value;

}