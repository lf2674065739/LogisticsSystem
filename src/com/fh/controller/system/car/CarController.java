package com.fh.controller.system.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.car.CarService;
import com.fh.util.PageData;

@Controller
@RequestMapping(value="/car")
public class CarController extends BaseController{
	@Resource(name="carService")
	private CarService carService;
	
	@RequestMapping(value="/carList")
	public ModelAndView carList(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		/*String USERNAME = pd.getString("USERNAME");
		
		if(null != USERNAME && !"".equals(USERNAME)){
			USERNAME = USERNAME.trim();
			pd.put("USERNAME", USERNAME);
		}
		
		String lastLoginStart = pd.getString("lastLoginStart");
		String lastLoginEnd = pd.getString("lastLoginEnd");
		
		if(lastLoginStart != null && !"".equals(lastLoginStart)){
			lastLoginStart = lastLoginStart+" 00:00:00";
			pd.put("lastLoginStart", lastLoginStart);
		}
		if(lastLoginEnd != null && !"".equals(lastLoginEnd)){
			lastLoginEnd = lastLoginEnd+" 00:00:00";
			pd.put("lastLoginEnd", lastLoginEnd);
		} */
		
		page.setPd(pd);
		List<PageData>	carList = carService.listAllCar(page);		//列出用户列表
		//List<Role> roleList = roleService.listAllERRoles();						//列出所有二级角色
		
		mv.setViewName("system/car/car_list");
		mv.addObject("carList", carList);
		/*mv.addObject("roleList", roleList);*/
		mv.addObject("pd", pd);
		//mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		return mv;
	}
}
