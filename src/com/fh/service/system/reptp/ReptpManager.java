package com.fh.service.system.reptp;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

public interface ReptpManager {
	public List<PageData> reptpList(Page page) throws Exception;

	public void saveU(PageData pd) throws Exception;

	public void updateU(PageData pd) throws Exception;

	public void deleteU(PageData pd) throws Exception;

	public PageData findMaxId(PageData pd) throws Exception;

	public PageData findById(PageData pd) throws Exception;

}
