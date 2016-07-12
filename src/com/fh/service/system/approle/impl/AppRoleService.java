package com.fh.service.system.approle.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.system.AppRole;
import com.fh.service.system.approle.AppRoleManager;
import com.fh.util.PageData;
@Service("appRoleService")
public class AppRoleService implements AppRoleManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	public List<AppRole> listAllRoles(PageData pd) throws Exception {
		return (List<AppRole>) dao.findForList("AppRoleMapper.listAllRoles", pd);
	}
}
