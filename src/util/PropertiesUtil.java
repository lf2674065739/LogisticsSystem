package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * ��ȡ���ò���
	 * @param property
	 * @return
	 */
    public static String getProperties(String property){
       InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/dbconfig.properties");
 	   Properties p = new Properties();
 	   try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	return p.getProperty(property);
    }
}
