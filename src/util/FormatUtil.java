package util;

public class FormatUtil {
	/**
	 * ±àÂë¸ñÊ½×ª»»
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public String formatConversion(String value) throws Exception{
		String returnValue = new String(value.getBytes("ISO-8859-1"), "utf-8"); 
		return returnValue;
	}
}
