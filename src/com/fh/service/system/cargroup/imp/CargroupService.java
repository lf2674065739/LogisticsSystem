package com.fh.service.system.cargroup.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.cargroup.CargroupManager;
import com.fh.util.PageData;

@Service("cargroupService")
public class CargroupService implements CargroupManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> cargroupList(Page page) throws Exception {

		return (List<PageData>) dao.findForList("cargroupMapper.cargroupList", page);
	}

	public void save(PageData pd) throws Exception {
		dao.save("cargroupMapper.saveup", pd);

	}

	public void update(PageData pd) throws Exception {
		dao.update("cargroupMapper.update", pd);

	}

	public PageData findById(PageData pd) throws Exception {

		return (PageData) dao.findForObject("cargroupMapper.findById", pd);
	}

	public void delete(PageData pd) throws Exception {
		dao.delete("cargroupMapper.delete", pd);

	}

}
