package com.fh.service.system.realorderinfo.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.realorderinfo.RealorderinfoManager;
import com.fh.util.PageData;

@Service("realorderinfoService")
public class RealorderinfoService implements RealorderinfoManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> realorderinfoList(Page page) throws Exception {

		return (List<PageData>) dao.findForList("realorderinfoMapper.realorderinfoList", page);
	}

	public void save(PageData pd) throws Exception {
		dao.save("realorderinfoMapper.save", pd);

	}

	public void update(PageData page) throws Exception {
		dao.update("realorderinfoMapper.updateP", page);

	}

	public void delete(PageData pd) throws Exception {
		dao.delete("realorderinfoMapper.delete", pd);

	}

	public PageData findMaxId(PageData pd) throws Exception {

		return (PageData) dao.findForObject("realorderinfoMapper.findMaxId", pd);
	}

	public PageData findById(PageData pd) throws Exception {

		return (PageData) dao.findForObject("realorderinfoMapper.findById", pd);
	}

}
