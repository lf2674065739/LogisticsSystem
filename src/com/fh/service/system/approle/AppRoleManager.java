package com.fh.service.system.approle;

import java.util.List;

import com.fh.entity.system.AppRole;
import com.fh.util.PageData;

public interface AppRoleManager {
	
	public List<AppRole> listAllRoles(PageData pd) throws Exception;

}
