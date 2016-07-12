package com.fh.controller.system.realorderinfo;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.realorderinfo.RealorderinfoManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("/realorderinfo")
public class RealorderinfoController extends BaseController {
	String menuUrl = "realorderinfo.do"; // 菜单地址(权限用)
	@Resource(name = "realorderinfoService")
	private RealorderinfoManager realorderinfoService;

	@RequestMapping(value = "/ realorderinfoList")
	public ModelAndView realorderinfoList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> realorderinfoList = realorderinfoService.realorderinfoList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/realorderinfo/realorderinfo_list");
		mv.addObject("realorderinfoList", realorderinfoList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/realorderinfosave")
	public ModelAndView realorderinfosave() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "realorderinfosave")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// List<PageData> saveList = save.demoList(getPage());// 列出所有系统用户角色
		mv.setViewName("system/realorderinfo/realorderinfo_save");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		// mv.addObject("saveList", )

		return mv;
	}

	@RequestMapping(value = "/save")

	public ModelAndView save() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "新增user");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// pd.put("NO",
		// (Integer.parseInt(reptpService.findMaxId(pd).get("NO").toString()) +
		// 1)); // ID
		// 主键
		// pd.put("NAME", ""); // 最后登录时间
		// pd.put("AGE", ""); //
		// pd.put("STATUS", "0"); //
		// pd.put("SAL", "");
		// pd.put("RIGHTS", "");
		// pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("USERNAME"),
		// pd.getString("PASSWORD")).toString ()); // 密码加密
		// if (null == demoService.findB(pd)) { // 判断用户名是否存在
		pd.put("ORDERID", Integer.parseInt(realorderinfoService.findMaxId(pd).get("MID").toString()) + 1);
		realorderinfoService.save(pd);
		// 执行保存
		// mv.addObject("msg", "demoSave");
		// } else {
		// mv.addObject("msg", "failed");
		// }
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateU")
	public ModelAndView updateU() throws Exception {

		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		// String ORDERID = pd.getString("ORDERID");
		// mv.addObject("pd", pd);
		pd = realorderinfoService.findById(pd); // 根据ID读取
		// pd.put("ORDERID", ORDERID);
		// pd.put("ORDERID", pd.get("ORDERID").toString());
		// pd.put("ORDERID", ORDERID);
		// pd.put("ROLE_ID", "2");
		// List<Role> roleList = reptpService.listAllRolesByPId(pd);//
		// 列出会员组角色
		// pd = reptpService.findByUiId(pd); // 根据ID读取
		mv.setViewName("system/realorderinfo/realorderinfo_save");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		// mv.addObject("roleList", roleList);

		return mv;
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改Dictionaries");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		realorderinfoService.update(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除用户
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	public void deleteU(PrintWriter out) throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "删除user");
		PageData pd = new PageData();
		pd = this.getPageData();
		realorderinfoService.delete(pd);
		out.write("delete");
		out.close();
	}
}
