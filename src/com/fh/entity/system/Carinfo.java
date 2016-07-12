package com.fh.entity.system;

public class Carinfo {
	private Integer CARID; // 车辆ID
	private String CARNUM; // 车牌号
	private String LICENSEID; // 行驶证号
	private String LICENSEPHOTOPATH; // 行驶证照片
	private String INSURANCEDATE; // 保险日期
	private Integer DRIVERID; // 司机ID
	private Integer OWNERID; // 车主ID
	private String STATUS; // 车辆状态
	private Integer CARTYPE; // 车辆类型
	private Integer CARLOAD; // 车辆载重

	public Integer getCARID() {
		return CARID;
	}

	public void setCARID(Integer cARID) {
		CARID = cARID;
	}

	public String getCARNUM() {
		return CARNUM;
	}

	public void setCARNUM(String cARNUM) {
		CARNUM = cARNUM;
	}

	public String getLICENSEID() {
		return LICENSEID;
	}

	public void setLICENSEID(String lICENSEID) {
		LICENSEID = lICENSEID;
	}

	public String getLICENSEPHOTOPATH() {
		return LICENSEPHOTOPATH;
	}

	public void setLICENSEPHOTOPATH(String lICENSEPHOTOPATH) {
		LICENSEPHOTOPATH = lICENSEPHOTOPATH;
	}

	public String getINSURANCEDATE() {
		return INSURANCEDATE;
	}

	public void setINSURANCEDATE(String iNSURANCEDATE) {
		INSURANCEDATE = iNSURANCEDATE;
	}

	public Integer getDRIVERID() {
		return DRIVERID;
	}

	public void setDRIVERID(Integer dRIVERID) {
		DRIVERID = dRIVERID;
	}

	public Integer getOWNERID() {
		return OWNERID;
	}

	public void setOWNERID(Integer oWNERID) {
		OWNERID = oWNERID;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public Integer getCARTYPE() {
		return CARTYPE;
	}

	public void setCARTYPE(Integer cARTYPE) {
		CARTYPE = cARTYPE;
	}

	public Integer getCARLOAD() {
		return CARLOAD;
	}

	public void setCARLOAD(Integer cARLOAD) {
		CARLOAD = cARLOAD;
	}

}
