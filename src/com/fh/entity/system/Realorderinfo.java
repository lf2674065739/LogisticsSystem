package com.fh.entity.system;

import java.sql.Date;

public class Realorderinfo {
	private Integer ORDERID; // 订单ID
	private String ORDERNUM; // 订单号
	private Integer CARID; // 车辆ID
	private Integer DRIVERID; // 司机ID
	private String ORDERGOODS; // 订单货物
	private Integer SHIPPERGOODSWEIGHT; // 货主方货物重量
	private Integer RECEIPTGOODSWEIGHT; // 收货方货物重量
	private String ORDERCREATEDATE; // 订单生成时间
	private String ORDERFAILUREDATE; // 订单失效时间
	private String ORDERSTATUS; // 订单状态
	private Integer LOGISTICSID; // 物流ID
	private String FREIGHT; // 运费
	private Date FINISHTIME; // 完成时间

	public Integer getORDERID() {
		return ORDERID;
	}

	public void setORDERID(Integer oRDERID) {
		ORDERID = oRDERID;
	}

	public String getORDERNUM() {
		return ORDERNUM;
	}

	public void setORDERNUM(String oRDERNUM) {
		ORDERNUM = oRDERNUM;
	}

	public Integer getCARID() {
		return CARID;
	}

	public void setCARID(Integer cARID) {
		CARID = cARID;
	}

	public Integer getDRIVERID() {
		return DRIVERID;
	}

	public void setDRIVERID(Integer dRIVERID) {
		DRIVERID = dRIVERID;
	}

	public String getORDERGOODS() {
		return ORDERGOODS;
	}

	public void setORDERGOODS(String oRDERGOODS) {
		ORDERGOODS = oRDERGOODS;
	}

	public Integer getSHIPPERGOODSWEIGHT() {
		return SHIPPERGOODSWEIGHT;
	}

	public void setSHIPPERGOODSWEIGHT(Integer sHIPPERGOODSWEIGHT) {
		SHIPPERGOODSWEIGHT = sHIPPERGOODSWEIGHT;
	}

	public Integer getRECEIPTGOODSWEIGHT() {
		return RECEIPTGOODSWEIGHT;
	}

	public void setRECEIPTGOODSWEIGHT(Integer rECEIPTGOODSWEIGHT) {
		RECEIPTGOODSWEIGHT = rECEIPTGOODSWEIGHT;
	}

	public String getORDERCREATEDATE() {
		return ORDERCREATEDATE;
	}

	public void setORDERCREATEDATE(String oRDERCREATEDATE) {
		ORDERCREATEDATE = oRDERCREATEDATE;
	}

	public String getORDERFAILUREDATE() {
		return ORDERFAILUREDATE;
	}

	public void setORDERFAILUREDATE(String oRDERFAILUREDATE) {
		ORDERFAILUREDATE = oRDERFAILUREDATE;
	}

	public String getORDERSTATUS() {
		return ORDERSTATUS;
	}

	public void setORDERSTATUS(String oRDERSTATUS) {
		ORDERSTATUS = oRDERSTATUS;
	}

	public Integer getLOGISTICSID() {
		return LOGISTICSID;
	}

	public void setLOGISTICSID(Integer lOGISTICSID) {
		LOGISTICSID = lOGISTICSID;
	}

	public String getFREIGHT() {
		return FREIGHT;
	}

	public void setFREIGHT(String fREIGHT) {
		FREIGHT = fREIGHT;
	}

	public Date getFINISHTIME() {
		return FINISHTIME;
	}

	public void setFINISHTIME(Date fINISHTIME) {
		FINISHTIME = fINISHTIME;
	}

}
