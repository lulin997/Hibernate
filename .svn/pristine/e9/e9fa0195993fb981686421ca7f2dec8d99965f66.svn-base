package com.wangqingbo.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 护照信息表
 * 
 * @author oracle
 *
 */
public class PassportInfo {
	// id
	private String passportId;
	// 编号
	private String passportBh;
	
	// 和person做一对一关联，使用对方的对象,和配置文件中的name对应
	private PersonInfo personInfo;

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getPassportBh() {
		return passportBh;
	}

	public void setPassportBh(String passportBh) {
		this.passportBh = passportBh;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
	

}
