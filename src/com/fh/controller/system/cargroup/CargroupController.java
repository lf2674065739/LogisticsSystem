package com.fh.controller.system.cargroup;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.cargroup.CargroupManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("/cargroup")
public class CargroupController extends BaseController {
	String menuUrl = "cargroup.do"; // 菜单地址(权限用)
	@Resource(name = "cargroupService")
	private CargroupManager cargroupService;

	@RequestMapping("/cargroupList")
	public ModelAndView cargroupList(Page page) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		page.setPd(pd);
		List<PageData> cargroupList = cargroupService.cargroupList(page); // 列出用户列表
		// List<Role> roleList = roleService.listAllERRoles(); //列出所有二级角色

		mv.setViewName("system/cargroup/cargroup_list");
		mv.addObject("cargroupList", cargroupList);
		/* mv.addObject("roleList", roleList); */
		mv.addObject("pd", pd);
		// mv.addObject(Const.SESSION_QX,this.getHC()); //按钮权限
		return mv;

	}

	@RequestMapping(value = "/carsave")
	public ModelAndView carsave() throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "cargroupsave")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		// List<PageData> saveList = save.demoList(getPage());// 列出所有系统用户角色
		mv.setViewName("system/cargroup/cargroup_save");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		// mv.addObject("saveList", )

		return mv;
	}

	// 增加保存
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
		// pd.put("GROUPID",
		// Integer.parseInt(cargroupService.findMaxId(pd).get("MID").toString())
		// + 1);
		cargroupService.save(pd);
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
	 * 去修改页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/goEdit")
	public ModelAndView goEdit() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		// String GROUPID = pd.getString("GROUPID");

		pd = cargroupService.findById(pd); // 根据ID读取
		// 放入视图容器
		// pd.put("GROUPID", pd.get("GROUPID").toString()); // 用作上级信息
		// mv.addObject("pds", cargroupService.findById(pd)); // 传入上级所有信息
		// mv.addObject("GROUPID", pd.get("GROUPDES").toString()); //
		// 传入上级ID，作为子ID用
		// pd.put("GROUPID", GROUPID); // 复原本ID
		mv.setViewName("system/cargroup/cargroup_save");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
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
		cargroupService.update(pd);
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
	@RequestMapping(value = "/deleteU")
	public void deleteU(PrintWriter out) throws Exception {
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		logBefore(logger, Jurisdiction.getUsername() + "删除user");
		PageData pd = new PageData();
		pd = this.getPageData();
		cargroupService.delete(pd);
		out.write("success");
		out.close();
	}
}
