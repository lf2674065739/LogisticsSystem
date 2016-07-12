package com.fh.controller.fhoa.reptp;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.reptp.ReptpManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("/reptp")
public class ReptpController extends BaseController {
	String menuUrl = "reptp.do"; // 菜单地址(权限用)
	@Resource(name = "reptpService")
	private ReptpManager reptpService;

	@RequestMapping(value = "/reptpList")
	public ModelAndView reptList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> reptpList = reptpService.reptpList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/reptp/reptp_list");
		mv.addObject("reptpList", reptpList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/saveb")
	public ModelAndView saveb() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "save")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// List<PageData> saveList = save.demoList(getPage());// 列出所有系统用户角色
		mv.setViewName("system/reptp/reptp_save");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		// mv.addObject("saveList", )

		return mv;
	}

	@RequestMapping(value = "/saveU")

	public ModelAndView saveU() throws Exception {
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
		pd.put("PEOPLEID", Integer.parseInt(reptpService.findMaxId(pd).get("MID").toString()) + 1);
		reptpService.saveU(pd);
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
	@RequestMapping(value = "/update")
	public ModelAndView update() throws Exception {

		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		// String PEOPLEID = pd.getString("PEOPLEID");
		pd = reptpService.findById(pd); // 根据ID读取
		// pd.put("ORDERID", ORDERID);
		// pd.put("PEOPLEID", pd.get("PEOPLEID").toString());
		// pd.put("PEOPLEID", PEOPLEID);
		// pd.put("ROLE_ID", "2");
		// List<Role> roleList = reptpService.listAllRolesByPId(pd);//
		// 列出会员组角色
		// pd = reptpService.findByUiId(pd); // 根据ID读取
		mv.setViewName("system/reptp/reptp_save");
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
		reptpService.updateU(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteU")
	public void deleteU(PrintWriter out) throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "删除reptp");
		PageData pd = new PageData();
		pd = this.getPageData();
		reptpService.deleteU(pd);

		out.write("success");

		out.close();
	}
}
