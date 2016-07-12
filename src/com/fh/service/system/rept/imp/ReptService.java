package com.fh.service.system.rept.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.rept.ReptManager;
import com.fh.util.PageData;

@Service("reptService")
public class ReptService implements ReptManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	// 查询全部
	public List<PageData> reptList(Page page) throws Exception {

		return (List<PageData>) dao.findForList("reptMapper.reptList", page);

	}

	public void save(PageData pd) throws Exception {
		dao.save("reptMapper.savedemo", pd);

	}

	public void update(PageData page) throws Exception {
		dao.update("reptMapper.update", page);

	}

	public void delete(PageData page) throws Exception {
		dao.delete("reptMapper.deleteU", page);

	}

	// 通过ID读取
	public PageData findById(PageData pd) throws Exception {

		return (PageData) dao.findForObject("reptMapper.findById", pd);
	}

	public PageData findMaxId(PageData pd) throws Exception {

		return (PageData) dao.findForObject("reptMapper.findMaxId", pd);
	}

	// public List<Rept> listAllReptsByPId(PageData pd) throws Exception {

	// return (List<Rept>) dao.findForList("reptMapper.listAllReptsByPId", pd);
	// }

}
