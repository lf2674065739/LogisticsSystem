package com.fh.service.system.carinfo.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.carinfo.CarinfoManager;
import com.fh.util.PageData;

@Service("carinfoService")
public class CarinfoService implements CarinfoManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> carinfoList(Page page) throws Exception {

		return (List<PageData>) dao.findForList("carinfoMapper.carinfoList", page);
	}

	public void save(PageData pd) throws Exception {
		dao.save("carinfoMapper.save", pd);
	}

	public void update(PageData pd) throws Exception {
		dao.update("carinfoMapper.update", pd);
	}

	public void delete(PageData pd) throws Exception {
		dao.delete("carinfoMapper.delete", pd);
	}

	public PageData findMaxId(PageData pd) throws Exception {

		return (PageData) dao.findForObject("carinfoMapper.findMaxId", pd);
	}

	public PageData findById(PageData pd) throws Exception {

		return (PageData) dao.findForObject("carinfoMapper.findById", pd);
	}

}
