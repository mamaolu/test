package tw;

import java.util.Map;
import java.util.TreeMap;

/**
 * �����ù�Map
 * @author Hongtao
 *
 */
public class HotelMapGenerator {

	private static Map<String, HotelMsg> hotelMap;
	
	public static Map<String, HotelMsg> generate() {
		hotelMap = new TreeMap<String, HotelMsg>();
		setHotel();
		return hotelMap;
	}
	
	/**
	 * ��ȡTreeMap
	 */
	private static void setHotel() {
		putTreeMap(new HotelMsg("Lakewood", 3, 110, 80, 90, 80));
		putTreeMap(new HotelMsg("Bridgewood", 4, 160, 110, 60, 50));
		putTreeMap(new HotelMsg("Ridgewood", 5, 220, 100, 150, 40));
	}
	
	/**
	 * ���ù���Ϣת��ΪTreeMap
	 * 
	 * @param hotel  �ù�ʵ��
	 */
	private static void putTreeMap(HotelMsg hotel) {
		// ���ùݰ����Ǽ���С��������
		hotelMap.put(hotel.rating + hotel.hotelName, hotel);
	}
}
