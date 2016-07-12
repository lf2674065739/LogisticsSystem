package com.fh.service.system.demo;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

public interface DemoManager {
	// public demo findById(String id) throws Exception;
	// 查询
	public List demoList(Page page) throws Exception;

	public void demoSave(PageData pd) throws Exception;

	// 增加
	public void deletedemo(PageData pd) throws Exception;

	// 获取最大ID
	public PageData findMaxId(PageData pd) throws Exception;

	// 修改
	public void update(PageData pd) throws Exception;

	/*
	 * public void update(String id) throws Exception;
	 * 
	 * public void save(demo d) throws Exception;
	 * 
	 * public void delete(String id) throws Exception;
	 */

}
