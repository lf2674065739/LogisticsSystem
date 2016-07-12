package com.fh.service.system.demo.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.demo.DemoManager;
import com.fh.util.PageData;

@Service("demoService")
public class DemoService implements DemoManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/*
	 * public demo findById(String id) throws Exception {
	 * 
	 * return (demo) dao.findById("demoMapper.findById", id); }
	 */

	/*
	 * public List<demo> findAll() throws Exception { List<demo> list = new
	 * ArrayList<demo>(); for (demo d : list) { d.setId("id=" + d.getId());
	 * d.setAge("age=" + d.getAge()); d.setName("name=" + d.getName());
	 * d.setSal(d.getSal());
	 * 
	 * } return list; }
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> demoList(Page page) throws Exception {
		return (List<PageData>) dao.findForList("demoMapper.demoList", page);
	}

	public void demoSave(PageData pd) throws Exception {
		dao.save("demoMapper.goDemoSave", pd);

	}

	public void deletedemo(PageData pd) throws Exception {
		dao.delete("demoMapper.delete", pd);

	}

	public PageData findMaxId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("demoMapper.findMaxId", pd);
	}

	public void update(PageData pd) throws Exception {
		dao.update("demoMapper.update", pd);

	}

}

/*
 * public void update(String id) throws Exception {
 * dao.update("demoMapper.update", id);
 * 
 * }
 * 
 * public void save(demo d) throws Exception { dao.save("demoMapper.save", d); }
 * 
 * public void delete(String id) throws Exception {
 * dao.delete("demoMapper.delete", id); }
 */
