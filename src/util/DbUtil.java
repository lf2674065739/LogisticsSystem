package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
   /**
    * 获取数据库连接
    * @return
    * @throws Exception
    */
   public Connection getConnection() throws Exception{
	   Class.forName(PropertiesUtil.getProperties("driverClassName")).toString();
	   Connection con = (Connection) DriverManager.getConnection(PropertiesUtil.getProperties("url"),PropertiesUtil.getProperties("username"),PropertiesUtil.getProperties("password"));
	   return con;
   }
   /**
    * 关闭数据库连接
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
