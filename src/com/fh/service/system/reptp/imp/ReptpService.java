package com.fh.service.system.reptp.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.reptp.ReptpManager;
import com.fh.util.PageData;

@Service("reptpService")
public class ReptpService implements ReptpManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<PageData> reptpList(Page page) throws Exception {

		return (List<PageData>) dao.findForList("reptpMapper.reptpList", page);
	}

	public void saveU(PageData pd) throws Exception {
		dao.save("reptpMapper.saveU", pd);
	}

	public void updateU(PageData pd) throws Exception {
		dao.update("reptpMapper.updateU", pd);
	}

	public void deleteU(PageData pd) throws Exception {
		dao.delete("reptpMapper.deleteU", pd);
	}

	public PageData findMaxId(PageData pd) throws Exception {

		return (PageData) dao.findForObject("reptpMapper.findMaxId", pd);
	}

	public PageData findById(PageData pd) throws Exception {

		return (PageData) dao.findForObject("reptpMapper.findById", pd);
	}

}
