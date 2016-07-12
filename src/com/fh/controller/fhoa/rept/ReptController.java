package com.fh.controller.fhoa.rept;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.rept.ReptManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping(value = "/rept")
public class ReptController extends BaseController {
	String menuUrl = "rept.do"; // 菜单地址(权限用)
	@Resource(name = "reptService")
	private ReptManager reptService;

	@RequestMapping(value = "/reptList")
	public ModelAndView reptList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> reptList = reptService.reptList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/rept/rept_list");
		mv.addObject("reptList", reptList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/savedemo")
	public ModelAndView savedemo() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		// String DICTIONARIES_ID = null == pd.get("DICTIONARIES_ID") ? "" :
		// pd.get("DICTIONARIES_ID").toString();
		// pd.put("DICTIONARIES_ID", DICTIONARIES_ID); // 上级ID
		// mv.addObject("pds", reptService.findById(pd)); // 传入上级所有信息
		// mv.addObject("", DICTIONARIES_ID); // 传入ID，作为子级ID用
		mv.setViewName("system/rept/rept_save");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
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
		pd.put("RECEIVINGPARTYID", Integer.parseInt(reptService.findMaxId(pd).get("MID").toString()) + 1);
		reptService.save(pd);
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
	 * 
	 * 
	 * /* 删除
	 * 
	 */
	@RequestMapping(value = "/deleteU")
	public void deleteU(PrintWriter out) throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
		reptService.delete(pd);
		out.write("success");

		out.close();
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
		// String RECEIVINGPARTYID = pd.getString("RECEIVINGPARTYID");

		// pd.put("ORDERID", ORDERID);
		pd = reptService.findById(pd);
		// mv.addObject("pd", pd);
		// pd.put("RECEIVINGPARTYID", pd.get("RECEIVINGUNIT").toString());
		// mv.addObject("pds", reptService.findById(pd));
		// mv.addObject("DICTIONARIES_ID", pd.get("RECEIVINGUNIT").toString());
		// pd.put("RECEIVINGPARTYID", RECEIVINGPARTYID);

		// pd.put("ROLE_ID", "2");
		// List<Role> roleList = reptpService.listAllRolesByPId(pd);//
		// 列出会员组角色
		// pd = reptpService.findByUiId(pd); // 根据ID读取
		mv.setViewName("system/rept/rept_save");
		mv.addObject("msg", "update");
		mv.addObject("pd", pd);
		// mv.addObject("roleList", roleList);

		return mv;
	}

	/**
	 * 修改保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	public ModelAndView update() throws Exception {
		/*
		 * logBefore(logger, Jurisdiction.getUsername() + "修改Dictionaries"); if
		 * (!Jurisdiction.buttonJurisdiction(menuUrl, "updatU")) { return null;
		 * } // 校验权限
		 */ ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		reptService.update(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

}
