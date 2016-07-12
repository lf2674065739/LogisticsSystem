package com.fh.service.system.rept;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

public interface ReptManager {
	public List<PageData> reptList(Page page) throws Exception;

	public void save(PageData pd) throws Exception;

	public void update(PageData pd) throws Exception;

	public void delete(PageData pd) throws Exception;

	// 通过Id读取
	public PageData findById(PageData pd) throws Exception;

	public PageData findMaxId(PageData pd) throws Exception;

	// public List<Rept> listAllReptsByPId(PageData pd) throws Exception;

}
