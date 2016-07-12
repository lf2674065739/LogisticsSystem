package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
   /**
    * ��ȡ���ݿ�����
    * @return
    * @throws Exception
    */
   public Connection getConnection() throws Exception{
	   Class.forName(PropertiesUtil.getProperties("driverClassName")).toString();
	   Connection con = (Connection) DriverManager.getConnection(PropertiesUtil.getProperties("url"),PropertiesUtil.getProperties("username"),PropertiesUtil.getProperties("password"));
	   return con;
   }
   /**
    * �ر����ݿ�����
    * @param con
    * @throws Exception
    */
   public void closeConnection(Connection con) throws Exception{
	   if(con!=null){
		   con.close();
	   }
   }
   public static void main(String[] args) throws Exception {
	   DbUtil dbUtil = new DbUtil();
	   System.out.println(dbUtil.getConnection());
   }
}
