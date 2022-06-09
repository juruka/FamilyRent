package com.scar.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

//中古車輛
public class ScarVO implements Serializable {

//	SCAR_NO	中古車輛編號(引擎編號)	VARCAHR
//	ST_NO	門市編號	VARCHAR
//	SCAR_BRAND	中古車品牌	VARCAHR
//	SCAR_MODEL	中古車車型	VARCAHR
//	SCAR_COLOR	中古車顏色	VARCAHR
//	SCAR_YEAR	中古車年分	VARCAHR
//	SCAR_CC	中午車排氣量	VARCAHR
//	SCAR_TRANS	中古車變速系統	VARCAHR
//	SCAR_FUEL	中古車燃料	VARCAHR
//	SCAR_CARRYING	最大乘載人數	TINYINT
//	SCAR_CARRINGPKG	最大乘載行李數	VARCAHR
//	SCAR_PRICE	底標價格	INT
//	SCAR_PHOTO	車輛照片	MEDIUMBLOB
//	SCAR_STARTDATE	起標日期	TIMESTAMP
//	SCAR_DATE	結標日期	TIMESTAMP
//	SCAR_STATUS	車輛狀況	TINYINT
//	SCAR_MILES	里程	INT

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String scar_no;
	private String st_no;
	private String scar_brand;
	private String scar_model;
	private String scar_color;
	private String scar_year;
	private String scar_cc;
	private String scar_trans;
	private String scar_fuel;
	private Integer scar_carrying;
	private String scar_carringkg;
	private Integer scar_price;
	private byte[] scar_photo;
	private Timestamp scar_startdate;
	private Timestamp scar_date;
	private Integer scar_status;
	private Integer scar_miles;

	public ScarVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScarVO(String scar_no, String st_no, String scar_brand, String scar_model, String scar_color,
			String scar_year, String scar_cc, String scar_trans, String scar_fuel, Integer scar_carrying,
			String scar_carringkg, Integer scar_price, byte[] scar_photo, Timestamp scar_startdate, Timestamp scar_date,
			Integer scar_status, Integer scar_miles) {
		super();
		this.scar_no = scar_no;
		this.st_no = st_no;
		this.scar_brand = scar_brand;
		this.scar_model = scar_model;
		this.scar_color = scar_color;
		this.scar_year = scar_year;
		this.scar_cc = scar_cc;
		this.scar_trans = scar_trans;
		this.scar_fuel = scar_fuel;
		this.scar_carrying = scar_carrying;
		this.scar_carringkg = scar_carringkg;
		this.scar_price = scar_price;
		this.scar_photo = scar_photo;
		this.scar_startdate = scar_startdate;
		this.scar_date = scar_date;
		this.scar_status = scar_status;
		this.scar_miles = scar_miles;
	}

	public String getScar_no() {
		return scar_no;
	}

	public void setScar_no(String scar_no) {
		this.scar_no = scar_no;
	}

	public String getSt_no() {
		return st_no;
	}

	public void setSt_no(String st_no) {
		this.st_no = st_no;
	}

	public String getScar_brand() {
		return scar_brand;
	}

	public void setScar_brand(String scar_brand) {
		this.scar_brand = scar_brand;
	}

	public String getScar_model() {
		return scar_model;
	}

	public void setScar_model(String scar_model) {
		this.scar_model = scar_model;
	}

	public String getScar_color() {
		return scar_color;
	}

	public void setScar_color(String scar_color) {
		this.scar_color = scar_color;
	}

	public String getScar_year() {
		return scar_year;
	}

	public void setScar_year(String scar_year) {
		this.scar_year = scar_year;
	}

	public String getScar_cc() {
		return scar_cc;
	}

	public void setScar_cc(String scar_cc) {
		this.scar_cc = scar_cc;
	}

	public String getScar_trans() {
		return scar_trans;
	}

	public void setScar_trans(String scar_trans) {
		this.scar_trans = scar_trans;
	}

	public String getScar_fuel() {
		return scar_fuel;
	}

	public void setScar_fuel(String scar_fuel) {
		this.scar_fuel = scar_fuel;
	}

	public Integer getScar_carrying() {
		return scar_carrying;
	}

	public void setScar_carrying(Integer scar_carrying) {
		this.scar_carrying = scar_carrying;
	}

	public String getScar_carringkg() {
		return scar_carringkg;
	}

	public void setScar_carringkg(String scar_carringkg) {
		this.scar_carringkg = scar_carringkg;
	}

	public Integer getScar_price() {
		return scar_price;
	}

	public void setScar_price(Integer scar_price) {
		this.scar_price = scar_price;
	}

	public byte[] getScar_photo() {
		return scar_photo;
	}

	public void setScar_photo(byte[] scar_photo) {
		this.scar_photo = scar_photo;
	}

	public Timestamp getScar_date() {
		return scar_date;
	}

	public void setScar_date(Timestamp scar_date) {
		this.scar_date = scar_date;
	}

	public Integer getScar_status() {
		return scar_status;
	}

	public void setScar_status(Integer scar_status) {
		this.scar_status = scar_status;
	}

	public Integer getScar_miles() {
		return scar_miles;
	}

	public void setScar_miles(Integer scar_miles) {
		this.scar_miles = scar_miles;
	}

	public Timestamp getScar_startdate() {
		return scar_startdate;
	}

	public void setScar_startdate(Timestamp scar_startdate) {
		this.scar_startdate = scar_startdate;
	}

	@Override
	public String toString() {
		return "ScarVO [scar_no=" + scar_no + ", st_no=" + st_no + ", scar_brand=" + scar_brand + ", scar_model="
				+ scar_model + ", scar_color=" + scar_color + ", scar_year=" + scar_year + ", scar_cc=" + scar_cc
				+ ", scar_trans=" + scar_trans + ", scar_fuel=" + scar_fuel + ", scar_carrying=" + scar_carrying
				+ ", scar_carringkg=" + scar_carringkg + ", scar_price=" + scar_price + ", scar_photo="
				+ Arrays.toString(scar_photo) + ", scar_startdate=" + scar_startdate + ", scar_date=" + scar_date
				+ ", scar_status=" + scar_status + ", scar_miles=" + scar_miles + "]";
	}

}
