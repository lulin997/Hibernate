package com.wangqingbo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 技术类
 * @author oracle
 *
 */
public class TechnologyInfo {

	// id
	private String id;
	// 名称
	private String name;
	// 分类
	private String category;
	// 配置多对多的关联
	private Set<EngineerInfo> engineerInfos;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<EngineerInfo> getEngineerInfos() {
		return engineerInfos;
	}
	public void setEngineerInfos(Set<EngineerInfo> engineerInfos) {
		this.engineerInfos = engineerInfos;
	}
	
	
}
