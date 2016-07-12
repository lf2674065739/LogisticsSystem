package com.fh.service.system.appuser.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.appuser.AppuserManager1;
import com.fh.util.PageData;

/**
 * 类名称：AppuserService
 * 
 * @author FH Q313596790 修改时间：2015年11月6日
 */
@Service("appUserService")
public class AppuserService1 implements AppuserManager1 {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 列出某角色下的所有会员
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*
	 * @SuppressWarnings("unchecked") public List<PageData>
	 * listAllAppuserByRorlid(PageData pd) throws Exception { return
	 * (List<PageData>) dao.findForList("AppuserMapper.listAllAppuserByRorlid",
	 * pd); }
	 */

	/**
	 * 会员列表
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listPdPageAppUser(Page page) throws Exception {
		return (List<PageData>) dao.findForList("AppuserMapper1.appuserlistPage", page);
	}

	/**
	 * 取最大ID
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findMaxId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper1.findMaxId", pd);
	}

	/**
	 * 通过手机号获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByPhone(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper1.findByPhone", pd);
	}

	/**
	 * 通过手机号获取用户的审核状态
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData getAppUserCheckInByPhone(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper1.getAppUserCheckInByPhone", pd);
	}

	/**
	 * 通过用户ID获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUserId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper1.findByUserId", pd);
	}

	/**
	 * 通过邮箱获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*
	 * public PageData findByEmail(PageData pd)throws Exception{ return
	 * (PageData)dao.findForObject("AppuserMapper.findByEmail", pd); }
	 */

	/**
	 * 通过编号获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*
	 * public PageData findByNumber(PageData pd)throws Exception{ return
	 * (PageData)dao.findForObject("AppuserMapper.findByNumber", pd); }
	 */

	/**
	 * 保存用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public int saveAppUser(PageData pd) throws Exception {
		int resultCount = (Integer) dao.save("AppuserMapper1.saveAppUser", pd);
		return resultCount;
	}

	/**
	 * 删除用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void deleteAppUser(PageData pd) throws Exception {
		dao.delete("AppuserMapper1.deleteAppUser", pd);
	}

	/**
	 * 修改用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void editAppUser(PageData pd) throws Exception {
		dao.update("AppuserMapper1.editAppUser", pd);
	}

	/**
	 * 审核时的修改
	 */
	public void editAppUserByCheck(PageData pd) throws Exception {
		dao.update("AppuserMapper1.editAppUserByCheck", pd);
	}

	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*
	 * public PageData findByUiId(PageData pd)throws Exception{ return
	 * (PageData)dao.findForObject("AppuserMapper.findByUiId", pd); }
	 */
	@Override
	public List<PageData> listAllAppuserByRorlid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageData findByEmail(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageData findByNumber(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteU(PageData pd) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public PageData findByUiId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PageData> listAllUser(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllU(String[] USER_IDS) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public PageData getAppUserCount(String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 全部会员
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	/*
	 * @SuppressWarnings("unchecked") public List<PageData> listAllUser(PageData
	 * pd)throws Exception{ return (List<PageData>)
	 * dao.findForList("AppuserMapper.listAllUser", pd); }
	 */

	/**
	 * 批量删除用户
	 * 
	 * @param USER_IDS
	 * @throws Exception
	 */
	/*
	 * public void deleteAllU(String[] USER_IDS)throws Exception{
	 * dao.delete("AppuserMapper.deleteAllU", USER_IDS); }
	 */

	/**
	 * 获取总数
	 * 
	 * @param pd
	 * @throws Exception
	 *//*
		 * public PageData getAppUserCount(String value)throws Exception{ return
		 * (PageData)dao.findForObject("AppuserMapper.getAppUserCount", value);
		 * }
		 */

}
