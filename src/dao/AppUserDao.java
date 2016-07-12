package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AppUser;
import util.DateUtil;

public class AppUserDao {
	/**
	 * APP���û���¼
	 * 
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public AppUser appUserLogin(Connection con, AppUser appUser) throws Exception {
		AppUser resultUser = null;
		String sql = "select * from T_APP_USER where PHONE='"+appUser.getPHONE()+"' and PASSWORD='"+appUser.getPASSWORD()+"'";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			resultUser = new AppUser();
			resultUser.setUSERID(rs.getInt("USERID"));
			resultUser.setNAME(rs.getString("NAME"));
			resultUser.setROLEID(rs.getInt("ROLEID"));
			resultUser.setPHONE(rs.getString("PHONE"));
			resultUser.setCHECKIN(rs.getInt("CHECKIN"));
		}
		return resultUser;
	}

	/**
	 * APP���û�ע��
	 * 
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int addAppUser(Connection con, AppUser appUser) throws Exception {
		String sql = "insert into T_APP_USER(USERID,NAME,PASSWORD,ROLEID,STATUS,PHONE,CHECKIN) values(?,?,?,?,0,?,1)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, appUser.getUSERID());
		ps.setString(2, appUser.getNAME());
		ps.setString(3, appUser.getPASSWORD());
		ps.setInt(4, appUser.getROLEID());
		ps.setString(5, appUser.getPHONE());
		return ps.executeUpdate();
	}

	/**
	 * ��ȡAPP������û�ID
	 * 
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int getMaxUserId(Connection con) throws Exception {
		String sql = "select max(USERID) as MID from T_APP_USER";
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt("MID");
		} else {
			return 0;
		}
	}

	/**
	 * APP���ж��û��Ƿ����
	 * 
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public boolean isAppUser(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from T_APP_USER");
		if ((appUser.getPHONE() != null) && (!"".equals(appUser.getPHONE()))) {
			sb.append(" and PHONE = " + appUser.getPHONE());
		}
		PreparedStatement ps = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * APP�˸���û�ID��ȡ�û���Ϣ
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public AppUser getAppUser(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from T_APP_USER");
		if ((appUser.getUSERID() != null) && (!"".equals(appUser.getUSERID()))) {
			sb.append(" and USERID = " + appUser.getUSERID());
		}
		PreparedStatement ps = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = ps.executeQuery();
		AppUser resultUser = new AppUser(); 
		if (rs.next()) {
			resultUser.setUSERID(rs.getInt("USERID"));
			resultUser.setNAME(rs.getString("NAME"));
			resultUser.setROLEID(rs.getInt("ROLEID"));
			resultUser.setPHONE(rs.getString("PHONE"));
			resultUser.setCHECKIN(rs.getInt("CHECKIN")); 
		}
		return resultUser;
	}
	/**
	 * APP���ϴ����֤��Ƭ
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int uploadCardId(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set CARDPHOTOPATH = '"+appUser.getCARDPHOTOPATH() + "',CHECKIN=2 where USERID = "+appUser.getUSERID());
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeUpdate();
	}
	/**
	 * APP端上传驾驶证照片
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int uploadLicenseId(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set LICENSEPHOTOPATH = '"+appUser.getLICENSEPHOTOPATH() + "',CHECKIN=2 where USERID = "+appUser.getUSERID());
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeUpdate();
	}
	/**
	 * APP端上传法人身份证照片
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int uploadLegalPersonCardId(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set LEGALPERSONCARDPHOTOPATH = '"+appUser.getLEGALPERSONCARDPHOTOPATH() + "',CHECKIN=2 where USERID = "+appUser.getUSERID());
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeUpdate();
	}
	/**
	 * APP端上传营业执照
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int uploadLicenseNum(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set LICENSENUMPHOTOPATH = '"+appUser.getLICENSENUMPHOTOPATH() + "',CHECKIN=2 where USERID = "+appUser.getUSERID());
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeUpdate();
	}
	/**
	 * APP端上传行驶证
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public int uploadCarLicenseId(Connection con, AppUser appUser) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set CARLICENSEPHOTOPATH = '"+appUser.getCARLICENSEPHOTOPATH() + "',CHECKIN=2 where USERID = "+appUser.getUSERID());
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeUpdate();
	}
	/**
	 * 修改登录时间
	 * @param con
	 * @param appUser
	 * @return
	 * @throws Exception
	 */
	public void uploadLastTime(Connection con, String appUserId) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("update T_APP_USER set LASTTIME = '"+DateUtil.getCurrentDate()+"' where USERID = "+appUserId);
		PreparedStatement ps = con.prepareStatement(sb.toString());
		System.out.println("-----------------:"+sb.toString());
		ps.executeUpdate();
	}
}
