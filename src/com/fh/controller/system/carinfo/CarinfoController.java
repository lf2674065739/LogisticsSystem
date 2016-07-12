package com.fh.controller.system.carinfo;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.carinfo.CarinfoManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("/carinfo")

public class CarinfoController extends BaseController {
	String menuUrl = "carinfo.do"; // 菜单地址(权限用)
	@Resource(name = "carinfoService")
	private CarinfoManager carinfoService;

	@RequestMapping(value = "/carinfoList")
	public ModelAndView carinfoList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> carinfoList = carinfoService.carinfoList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/carinfo/carinfo_list");
		mv.addObject("carinfoList", carinfoList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/carinfosave")
	public ModelAndView carinfosave() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "carinfosave")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// List<PageData> saveList = save.demoList(getPage());// 列出所有系统用户角色
		mv.setViewName("system/carinfo/carinfo_save");
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
		pd.put("CARID", Integer.parseInt(carinfoService.findMaxId(pd).get("MID").toString()) + 1);
		carinfoService.save(pd);
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
	@RequestMapping(value = "/edit")
	public ModelAndView edit() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改Dictionaries");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		carinfoService.update(pd);
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
		// String CARID = pd.getString("CARID");
		pd = carinfoService.findById(pd); // 根据ID读取
		// mv.addObject("pd", pd);
		// pd.put("ORDERID", ORDERID);
		// pd.put("CARID", pd.get("CARID").toString());
		// pd.put("CARID", CARID);
		// pd.put("ROLE_ID", "2");
		// List<Role> roleList = reptpService.listAllRolesByPId(pd);//
		// 列出会员组角色
		// pd = reptpService.findByUiId(pd); // 根据ID读取
		mv.setViewName("system/carinfo/carinfo_save");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		// mv.addObject("roleList", roleList);

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
		carinfoService.delete(pd);
		out.write("success");
		out.close();
	}
}
