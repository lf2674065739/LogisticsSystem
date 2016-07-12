package web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.system.appuser.AppuserManager1;
import util.*;

import dao.AppUserDao;
import model.AppUser;
import net.sf.json.JSONObject;

public class AppUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
    private FormatUtil formatUtil = new FormatUtil();
    private AppUserDao appUserDao = new AppUserDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if("loginAppUser".equals(action)){
			this.loginAppUser(request, response);
		}else if("addAppUser".equals(action)){
			try {
				this.addAppUser(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getAppUser".equals(action)){
			this.getAppUser(request, response);
		}else if("uploadCardId".equals(action)){
			this.uploadCardId(request, response);
		}else if("uploadLicenseId".equals(action)){
			this.uploadLicenseId(request, response);
		}else if("uploadLegalPersonCardId".equals(action)){
			this.uploadLegalPersonCardId(request, response);
		}else if("uploadLicenseNum".equals(action)){
			this.uploadLicenseNum(request, response);
		}else if("uploadCarLicenseId".equals(action)){
			this.uploadCarLicenseId(request, response);
		}
	}
	/**
	 * APP端用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void loginAppUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String PHONE = request.getParameter("PHONE");
		String PASSWORD = request.getParameter("PASSWORD");
		AppUser appUser = new AppUser();
		appUser.setPHONE(PHONE);
		appUser.setPASSWORD(PASSWORD);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			AppUser resultUser = appUserDao.appUserLogin(con, appUser);
			JSONObject result = new JSONObject();
			if(resultUser != null){
				appUserDao.uploadLastTime(con, resultUser.getUSERID().toString());
				result.put("status", 0);
				result.put("message", "登录成功！");
				result.put("USERID", resultUser.getUSERID());
				result.put("NAME", resultUser.getNAME());
				result.put("ROLEID", resultUser.getROLEID());
				result.put("PHONE", resultUser.getPHONE());
				result.put("CHECKIN", resultUser.getCHECKIN());
			}else{
				result.put("status", 1);
				result.put("message", "登录失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * APP端用户注册
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	protected void addAppUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String NAME = request.getParameter("NAME");//formatUtil.formatConversion(request.getParameter("NAME"));
		String PASSWORD = request.getParameter("PASSWORD");
		String ROLEID = request.getParameter("ROLEID");
		String PHONE = request.getParameter("PHONE");
		
		AppUser appUser = new AppUser();
		appUser.setNAME(NAME);
		appUser.setROLEID(Integer.parseInt(ROLEID));
		appUser.setPHONE(PHONE);
		appUser.setPASSWORD(PASSWORD);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			JSONObject result = new JSONObject();
			if(!appUserDao.isAppUser(con, appUser)){
				int USERID = appUserDao.getMaxUserId(con)+1;
				appUser.setUSERID(USERID);
				int resultCount = appUserDao.addAppUser(con, appUser);
				
				if(resultCount == 1){
					result.put("status", 0);
					result.put("message", "注册成功！");
					result.put("USERID", USERID);
				}else{
					result.put("status", 1);
					result.put("message", "注册失败！");
				}
			}else{
				result.put("status", 1);
				result.put("message", "该手机号已注册！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * APP端根据用户ID获取用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAppUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String USERID = request.getParameter("USERID");
		AppUser appUser = new AppUser();
		appUser.setUSERID(Integer.parseInt(USERID));
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			JSONObject result = new JSONObject();
			AppUser resultUser = appUserDao.getAppUser(con, appUser);
			if(resultUser != null){
				result.put("USERID", resultUser.getUSERID());
				result.put("NAME", resultUser.getNAME()==null?"":resultUser.getNAME());
				result.put("ROLEID", resultUser.getROLEID());
				result.put("PHONE", resultUser.getPHONE()==null?"":resultUser.getPHONE());
				result.put("CHECKIN", resultUser.getCHECKIN());
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * APP端上传身份证照片
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uploadCardId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=(List<FileItem>)upload.parseRequest(new ServletRequestContext(request));//upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> itr=items.iterator();
		AppUser appUser = new AppUser();
		while(itr.hasNext()){
			FileItem item=(FileItem)itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("USERID".equals(fieldName)){
					appUser.setUSERID(Integer.parseInt(item.getString("utf-8")));
				}
			}else if(!"".equals(item.getName())){
				try{
					//imageChange=true;
					String imageName= MD5.md5("CardId"+DateUtil.getCurrentDateStr());
					appUser.setCARDPHOTOPATH(imageName+"."+item.getName().split("\\.")[1]); 
					String filePath=PropertiesUtil.getProperties("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int resultCount = appUserDao.uploadCardId(con, appUser);
			JSONObject result = new JSONObject();
			if(resultCount == 1){
				result.put("status", 0);
				result.put("message", "上传成功！");
			}else{
				result.put("status", 1);
				result.put("message", "上传失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * APP端上传驾驶证照片
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uploadLicenseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=(List<FileItem>)upload.parseRequest(new ServletRequestContext(request));//upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> itr=items.iterator();
		AppUser appUser = new AppUser();
		while(itr.hasNext()){
			FileItem item=(FileItem)itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("USERID".equals(fieldName)){
					appUser.setUSERID(Integer.parseInt(item.getString("utf-8")));
				}
			}else if(!"".equals(item.getName())){
				try{
					//imageChange=true;
					String imageName=MD5.md5("LicenseId"+DateUtil.getCurrentDateStr());
					appUser.setLICENSEPHOTOPATH(imageName+"."+item.getName().split("\\.")[1]); 
					String filePath=PropertiesUtil.getProperties("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int resultCount = appUserDao.uploadLicenseId(con, appUser);
			JSONObject result = new JSONObject();
			if(resultCount == 1){
				result.put("status", 0);
				result.put("message", "上传成功！");
			}else{
				result.put("status", 1);
				result.put("message", "上传失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * APP端上传法人身份证照片
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uploadLegalPersonCardId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=(List<FileItem>)upload.parseRequest(new ServletRequestContext(request));//upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> itr=items.iterator();
		AppUser appUser = new AppUser();
		while(itr.hasNext()){
			FileItem item=(FileItem)itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("USERID".equals(fieldName)){
					appUser.setUSERID(Integer.parseInt(item.getString("utf-8")));
				}
			}else if(!"".equals(item.getName())){
				try{
					//imageChange=true;
					String imageName=MD5.md5("LegalPersonCardId"+DateUtil.getCurrentDateStr());
					appUser.setLEGALPERSONCARDPHOTOPATH(imageName+"."+item.getName().split("\\.")[1]); 
					String filePath=PropertiesUtil.getProperties("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int resultCount = appUserDao.uploadLegalPersonCardId(con, appUser);
			JSONObject result = new JSONObject();
			if(resultCount == 1){
				result.put("status", 0);
				result.put("message", "上传成功！");
			}else{
				result.put("status", 1);
				result.put("message", "上传失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * APP端上传营业执照
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uploadLicenseNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=(List<FileItem>)upload.parseRequest(new ServletRequestContext(request));//upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> itr=items.iterator();
		AppUser appUser = new AppUser();
		while(itr.hasNext()){
			FileItem item=(FileItem)itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("USERID".equals(fieldName)){
					appUser.setUSERID(Integer.parseInt(item.getString("utf-8")));
				}
			}else if(!"".equals(item.getName())){
				try{
					//imageChange=true;
					String imageName=MD5.md5("LicenseNum"+DateUtil.getCurrentDateStr());
					appUser.setLICENSENUMPHOTOPATH(imageName+"."+item.getName().split("\\.")[1]); 
					String filePath=PropertiesUtil.getProperties("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int resultCount = appUserDao.uploadLicenseNum(con, appUser);
			JSONObject result = new JSONObject();
			if(resultCount == 1){
				result.put("status", 0);
				result.put("message", "上传成功！");
			}else{
				result.put("status", 1);
				result.put("message", "上传失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * APP端上传行驶证
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uploadCarLicenseId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=(List<FileItem>)upload.parseRequest(new ServletRequestContext(request));//upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> itr=items.iterator();
		AppUser appUser = new AppUser();
		while(itr.hasNext()){
			FileItem item=(FileItem)itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("USERID".equals(fieldName)){
					appUser.setUSERID(Integer.parseInt(item.getString("utf-8")));
				}
			}else if(!"".equals(item.getName())){
				try{
					//imageChange=true;
					String imageName=MD5.md5("CarLicenseId"+DateUtil.getCurrentDateStr());
					appUser.setCARLICENSEPHOTOPATH(imageName+"."+item.getName().split("\\.")[1]); 
					String filePath=PropertiesUtil.getProperties("imagePath")+imageName+"."+item.getName().split("\\.")[1];
					item.write(new File(filePath));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int resultCount = appUserDao.uploadCarLicenseId(con, appUser);
			JSONObject result = new JSONObject();
			if(resultCount == 1){
				result.put("status", 0);
				result.put("message", "上传成功！");
			}else{
				result.put("status", 1);
				result.put("message", "上传失败！");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
