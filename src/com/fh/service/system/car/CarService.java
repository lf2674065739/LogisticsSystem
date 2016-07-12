package com.fh.service.system.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

@Service("carService")
public class CarService {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	/*
	*用户列表(用户组)
	*/
	public List<PageData> listAllCar(Page page)throws Exception{
		return (List<PageData>) dao.findForList("CarMapper.carListPage", page);
	}
/*	
	*用户列表(全部)
	
	public List<PageData> listAllCar(PageData pd)throws Exception{
		return (List<PageData>) dao.findForList("CarMapper.carList", pd);
	}*/
}
