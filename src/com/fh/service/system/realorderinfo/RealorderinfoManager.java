package com.fh.service.system.realorderinfo;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

public interface RealorderinfoManager {
	public List<PageData> realorderinfoList(Page page) throws Exception;

	public void save(PageData pd) throws Exception;

	public void update(PageData pd) throws Exception;

	public void delete(PageData pd) throws Exception;

	public PageData findMaxId(PageData pd) throws Exception;

	public PageData findById(PageData pd) throws Exception;
}
