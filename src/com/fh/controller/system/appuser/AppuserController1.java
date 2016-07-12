package com.fh.controller.system.appuser;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.AppRole;
import com.fh.service.system.approle.AppRoleManager;
import com.fh.service.system.appuser.AppuserManager1;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
import com.fh.util.Watermark;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/appUser")
public class AppuserController1 extends BaseController {

	String menuUrl = "appUser/appUserList.do"; // 菜单地址(权限用)
	@Resource(name = "appUserService")
	private AppuserManager1 appUserService;
	@Resource(name = "appRoleService")
	private AppRoleManager appRoleService;

	/**
	 * 显示用户列表
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/appUserList")
	public ModelAndView listUsers(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			System.out.println(page.getPageStr());
			page.setPd(pd);
			/*
			 * List<PageData> userList = appuserService.listPdPageUser(page);
			 * //列出会员列表 pd.put("ROLE_ID", "2");
			 */

			List<PageData> appUserList = appUserService.listPdPageAppUser(page);
			mv.setViewName("system/appuser1/appuser_list");
			mv.addObject("appUserList", appUserList);

			mv.addObject("pd", pd);
			// mv.addObject("QX",Jurisdiction.getHC()); //按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 去新增用户页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAddAppUser")
	public ModelAndView goAddU() throws Exception {
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		// //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<AppRole> appRoleList = appRoleService.listAllRoles(pd);

		// List<AppRole> appRoleList = appRoleService.listAllRoles(pd);
		mv.setViewName("system/appuser1/appuser_add");
		mv.addObject("msg", "saveAppUser");
		mv.addObject("appRoleList", appRoleList);
		mv.addObject("pd", pd);
		// mv.addObject("appRoleList", appRoleList);
		return mv;
	}

	/**
	 * 去审核界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goCheckAppUser")
	public ModelAndView goCheckAppUser() throws Exception {
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		// //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<AppRole> appRoleList = appRoleService.listAllRoles(pd);
		pd = appUserService.findByUserId(pd);
		mv.setViewName("system/appuser1/appuser_check");
		mv.addObject("msg", "checkAppUser");
		mv.addObject("appRoleList", appRoleList);
		mv.addObject("pd", pd);
		// mv.addObject("appRoleList", appRoleList);
		return mv;
	}

	/**
	 * 审核App用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkAppUser")
	public ModelAndView checkAppUser() throws Exception {
		/*
		 * if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		 * //校验权限 logBefore(logger, Jurisdiction.getUsername()+"新增user");
		 */
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		appUserService.editAppUserByCheck(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 新增
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(@RequestParam(required = false) MultipartFile file) throws Exception {
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		// //校验权限
		// logBefore(logger, Jurisdiction.getUsername()+"新增图片");
		Map<String, String> map = new HashMap<String, String>();
		String ffile = DateUtil.getDays(), fileName = "";
		PageData pd = new PageData();
		if (Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			if (null != file && !file.isEmpty()) {
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile; // 文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID()); // 执行上传
			} else {
				System.out.println("上传失败");
			}
			pd.put("USERID", Integer.parseInt(appUserService.findMaxId(pd).get("MID").toString()) + 1); // 主键
			pd.put("LICENSEPHOTOPATH", ffile + "/" + fileName); // 路径
			pd.put("PHONE", 21); // 主键
			pd.put("CARDPHOTOPATH", ffile + "/" + fileName);
			Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);// 加水印
			appUserService.editAppUser(pd);
		}
		map.put("result", "ok");
		return AppUtil.returnObject(pd, map);
	}

	/**
	 * 保存用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveAppUser")
	public ModelAndView saveU() throws Exception {
		/*
		 * if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		 * //校验权限 logBefore(logger, Jurisdiction.getUsername()+"新增user");
		 */
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERID", Integer.parseInt(appUserService.findMaxId(pd).get("MID").toString()) + 1);
		/*
		 * pd.put("USER_ID", this.get32UUID()); //ID 主键 pd.put("LAST_LOGIN",
		 * ""); //最后登录时间 pd.put("IP", ""); //IP pd.put("STATUS", "0"); //状态
		 * pd.put("SKIN", "default"); pd.put("RIGHTS", ""); pd.put("PASSWORD",
		 * new SimpleHash("SHA-1", pd.getString("USERNAME"),
		 * pd.getString("PASSWORD")).toString()); //密码加密
		 */ /*
			 * if(null == userService.findByUsername(pd)){ //判断用户名是否存在
			 * userService.saveU(pd); //执行保存 mv.addObject("msg","success");
			 * }else{ mv.addObject("msg","failed"); }
			 */
		appUserService.saveAppUser(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * app用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginAppUserP")
	public void loginAppUserP(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = appUserService.findByPhone(pd);
		JSONObject result = new JSONObject();
		if (pd == null) {
			result.put("status", 1);
		} else {
			result.put("status", 0);
			result.put("USERID", pd.get("USERID"));
			// String s = new String("中文".getBytes(), "UTF-8");
			result.put("NAME", "中文");
			result.put("ROLEID", pd.get("ROLEID"));
			result.put("PHONE", pd.get("PHONE"));
			result.put("CHECKIN", pd.get("CHECKIN"));
		}
		out.println(result.toString());
		out.close();
	}

	/**
	 * 保存用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveAppUserP")
	public void saveAppUserP(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERID", Integer.parseInt(appUserService.findMaxId(pd).get("MID").toString()) + 1);
		int resultCount = appUserService.saveAppUser(pd);
		JSONObject result = new JSONObject();
		if (resultCount == 1) {
			result.put("status", 0);
		} else {
			result.put("status", 1);
		}
		out.println(result.toString());
		out.close();
	}

	/**
	 * 通过手机号获取用户的审核状态
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAppUserCheckInByPhone")
	public void getAppUserCheckInByPhone(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = appUserService.getAppUserCheckInByPhone(pd);
		JSONObject result = new JSONObject();
		result.put("checkStatus", pd.get("CHECKIN"));
		out.println(result.toString());
		out.close();
	}

	/**
	 * 删除App用户
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAppUser")
	public void deleteAppUser(PrintWriter out) throws Exception {
		/*
		 * if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		 * logBefore(logger, Jurisdiction.getUsername()+"删除会员");
		 */
		PageData pd = new PageData();
		pd = this.getPageData();

		// appUserService.deleteAppUser(pd);
		out.write("success");
		out.close();
	}

	/**
	 * 跳转到上传图片的界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goUploadCardId")
	public ModelAndView goUploadCardId() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/appuser1/appuserimage");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 上传图片
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadCardId")
	public Object uploadCardId(@RequestParam(required = false) MultipartFile file) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		String ffile = DateUtil.getDays(), fileName = "";
		PageData pd = new PageData();
		if (Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			if (null != file && !file.isEmpty()) {
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile; // 文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID()); // 执行上传
			} else {
				System.out.println("上传失败");
			}
			/*
			 * pd.put("USERID",
			 * Integer.parseInt(appUserService.findMaxId(pd).get("MID").toString
			 * ())+1); //主键 pd.put("LICENSEPHOTOPATH", ffile + "/" + fileName);
			 * //路径
			 */ pd.put("PHONE", 1); // 主键
			pd.put("CARDPHOTOPATH", ffile + "/" + fileName);
			Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);// 加水印
			appUserService.editAppUser(pd);
		}
		map.put("result", "ok");
		return AppUtil.returnObject(pd, map);
	}
}
