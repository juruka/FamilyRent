package com.store.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




//門市
@Entity
@Table(name = "STORE")
public class Store_hib implements Serializable{
	
//	ST_NO	門市編號	VARCHAR
//	ST_NAME	門市名稱	VARCHAR
//	ST_ADRS	門市地址	VARCHAR
//	ST_TEL	門市電話	VARCHAR
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "ST_NO")
	private String st_no;
//	@Column(name = "ST_NAME")
	private String st_name;
//	@Column(name = "ST_ADRS")
	private String st_adrs;
//	@Column(name = "ST_TEL")
	private String st_tel;
	
	
	
	
	
	public Store_hib() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store_hib(String st_no, String st_name, String st_adrs, String st_tel) {
		super();
		this.st_no = st_no;
		this.st_name = st_name;
		this.st_adrs = st_adrs;
		this.st_tel = st_tel;
	}
	public String getSt_no() {
		return st_no;
	}
	public void setSt_no(String st_no) {
		this.st_no = st_no;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_adrs() {
		return st_adrs;
	}
	public void setSt_adrs(String st_adrs) {
		this.st_adrs = st_adrs;
	}
	public String getSt_tel() {
		return st_tel;
	}
	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}
	@Override
	public String toString() {
		return "Store [st_no=" + st_no + ", st_name=" + st_name + ", st_adrs=" + st_adrs + ", st_tel=" + st_tel + "]";
	}
	
	
}
