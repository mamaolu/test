package tw;

import java.util.Map;
import java.util.TreeMap;

/**
 * 生成旅馆Map
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
	 * 获取TreeMap
	 */
	private static void setHotel() {
		putTreeMap(new HotelMsg("Lakewood", 3, 110, 80, 90, 80));
		putTreeMap(new HotelMsg("Bridgewood", 4, 160, 110, 60, 50));
		putTreeMap(new HotelMsg("Ridgewood", 5, 220, 100, 150, 40));
	}
	
	/**
	 * 将旅馆信息转化为TreeMap
	 * 
	 * @param hotel  旅馆实例
	 */
	private static void putTreeMap(HotelMsg hotel) {
		// 将旅馆按照星级从小到大排序
		hotelMap.put(hotel.rating + hotel.hotelName, hotel);
	}
}
