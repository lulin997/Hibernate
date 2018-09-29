package com.wangqingbo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 工程师类
 * @author oracle
 *
 */
public class EngineerInfo {

	// id
	private String id;
	// 名称
	private String name;
	// 年龄
	private Integer age;
	// 公司
	private String company;
	// 配置多对多的关系,对应配置文件中set的name
	private Set<TechnologyInfo> technologyInfos;
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Set<TechnologyInfo> getTechnologyInfos() {
		return technologyInfos;
	}
	public void setTechnologyInfos(Set<TechnologyInfo> technologyInfos) {
		this.technologyInfos = technologyInfos;
	}
	
	
}
