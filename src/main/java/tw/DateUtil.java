package tw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * ʱ�䴦������
 * @author Hongtao
 *
 */
public class DateUtil {

	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy", Locale.US);
	
	/**
	 * ��ʽ����ǰ����
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
	 * ��ȡԤ��ʱ�������ֵ
	 * @param date Ԥ������
	 * @return int
	 */
	public static int getWeekNum(Date reseDdate){
		calendar.setTime(reseDdate);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}
	
	/**
	 * ����У��
	 * 
	 * @param dateStr  �ַ�������
	 * @return Date
	 */
	public static Date verifyDate(String dateStr) {
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("���ڸ�ʽ���󣬴������ݣ�" + dateStr);
			e.printStackTrace();
		}
		if (dateStr.toLowerCase().equals(sdf.format(date).toLowerCase())) {
			return date;
		}
		return null;
	}
}
