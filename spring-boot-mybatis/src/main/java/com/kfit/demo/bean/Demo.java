package com.kfit.demo.bean;

import java.util.Date;

import com.kfit.demo.enums.SexEnum;

/**
 * 测试实体类.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年8月16日
 */
public class Demo {
	private int id;//主键.
	private String name;//姓名.
	private Date updateTime;//修改时间.
	private SexEnum sexEnum;//性别.
	private String email;//邮箱
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SexEnum getSexEnum() {
		return sexEnum;
	}
	public void setSexEnum(SexEnum sexEnum) {
		this.sexEnum = sexEnum;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
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
}
