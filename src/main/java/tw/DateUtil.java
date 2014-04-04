package tw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间处理辅助类
 * @author Hongtao
 *
 */
public class DateUtil {

	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy", Locale.US);
	
	/**
	 * 格式化当前日期
	 */
	public static Date formatDate(Date date){
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取预订时间的星期值
	 * @param date 预定日期
	 * @return int
	 */
	public static int getWeekNum(Date reseDdate){
		calendar.setTime(reseDdate);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}
	
	/**
	 * 日期校验
	 * 
	 * @param dateStr  字符串日期
	 * @return Date
	 */
	public static Date verifyDate(String dateStr) {
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("日期格式错误，错误内容：" + dateStr);
			e.printStackTrace();
		}
		if (dateStr.toLowerCase().equals(sdf.format(date).toLowerCase())) {
			return date;
		}
		return null;
	}
}
