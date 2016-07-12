package com.fh.service.system.appuser;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

/**
 * 会员接口类
 * 
 * @author fh313596790qq(青苔) 修改时间：2015.11.2
 */
public interface AppuserManager1 {

	/**
	 * 列出某角色下的所有会员
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllAppuserByRorlid(PageData pd) throws Exception;

	/**
	 * 会员列表
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listPdPageAppUser(Page page) throws Exception;

	/**
	 * 通过用户名获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByPhone(PageData pd) throws Exception;

	/**
	 * 通过手机号获取用户的审核状态
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData getAppUserCheckInByPhone(PageData pd) throws Exception;

	/**
	 * 通过用户ID获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUserId(PageData pd) throws Exception;

	/**
	 * 通过邮箱获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByEmail(PageData pd) throws Exception;

	/**
	 * 通过编号获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByNumber(PageData pd) throws Exception;

	/**
	 * 保存用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public int saveAppUser(PageData pd) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void deleteU(PageData pd) throws Exception;

	/**
	 * 修改用户
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void editAppUser(PageData pd) throws Exception;

	/**
	 * 审核时的修改
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void editAppUserByCheck(PageData pd) throws Exception;

	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUiId(PageData pd) throws Exception;

	/**
	 * 全部会员
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllUser(PageData pd) throws Exception;

	/**
	 * 批量删除用户
	 * 
	 * @param USER_IDS
	 * @throws Exception
	 */
	public void deleteAllU(String[] USER_IDS) throws Exception;

	/**
	 * 获取总数
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public PageData getAppUserCount(String value) throws Exception;

	/**
	 * 查询最大App用户ID
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findMaxId(PageData pd) throws Exception;
}
