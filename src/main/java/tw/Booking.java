package tw;

import java.util.List;
import java.util.Map;

/**
 * 主方法类
 * 
 * @author Hongtao
 * 
 */
public class Booking {

	public static void main(String args[]) {
		final String fileName = "source.txt";
		List<ReserMsg> reserList = ReserListGenerator.generate(fileName);
		Map<String, HotelMsg> hotelMap = HotelMapGenerator.generate();
		
		HotelCalculator hotelCalculator = new HotelCalculator();
		hotelCalculator.getResult(reserList, hotelMap);
	}
	
}
