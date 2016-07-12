package com.fh.controller.system.demo;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.demo.DemoManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping(value = "/demo")

public class DemoController extends BaseController {
	String menuUrl = "demo.do"; // 菜单地址(权限用)
	@Resource(name = "demoService")
	private DemoManager demoService;

	@RequestMapping(value = "/demoList")
	public ModelAndView carList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> demoList = demoService.demoList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/demo/demo_list");
		mv.addObject("demoList", demoList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/goDemoSave")
	public ModelAndView goDemoSave() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "save")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// List<PageData> saveList = save.demoList(getPage());// 列出所有系统用户角色
		mv.setViewName("system/demo/demo_save");
		mv.addObject("msg", "demoSave");
		mv.addObject("pd", pd);
		// mv.addObject("saveList", )

		return mv;
	}

	@RequestMapping(value = "/demoSave")

	public ModelAndView saveU() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "新增user");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		pd.put("NO", (Integer.parseInt(demoService.findMaxId(pd).get("NO").toString()) + 1)); // ID
		// 主键
		// pd.put("NAME", ""); // 最后登录时间
		// pd.put("AGE", ""); //
		// pd.put("STATUS", "0"); //
		// pd.put("SAL", "");
		// pd.put("RIGHTS", "");
		// pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("USERNAME"),
		// pd.getString("PASSWORD")).toString ()); // 密码加密
		// if (null == demoService.findB(pd)) { // 判断用户名是否存在
		demoService.update(pd);
		demoService.demoSave(pd);
		// 执行保存
		// mv.addObject("msg", "demoSave");
		// } else {
		// mv.addObject("msg", "failed");
		// }
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除用户
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/deletedemo")
	public void deletedemo(PrintWriter out) throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
			// logBefore(logger, Jurisdiction.getUsername() + "删除user");
		PageData pd = new PageData();
		pd = this.getPageData();
		demoService.deletedemo(pd);
		out.write("success");
		out.close();
	}

	/**
	 * 去修改用户页面(个人修改)
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	public ModelAndView update(String id) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// mv.addObject("fx", "head");
		// pd.put("ID", "1");
		// List<> roleList = demoService.listAllRolesByPId(pd); //
		// 列出所有系统用户角色
		// pd.put("NAME", Jurisdiction.getUsername());
		// pd.put("ID", ID);
		// pd = demoService.); // 根据用户名读取
		mv.setViewName("system/demo/demo_save");
		mv.addObject("msg", "demoSave");
		mv.addObject("pd", pd);

		// mv.addObject("roleList", roleList);
		return mv;
	}

}
