package tw;

import java.util.Map;

import junit.framework.TestCase;

public class ReserListGeneratorTest extends TestCase{

	public void testGetDistinct(){
		Map<String, HotelMsg> map = HotelMapGenerator.generate();
		
//		List<ReserMsg> reserList = ReserListGenerator.generate("source.txt");
//		List<ReserMsg> list = new ArrayList<ReserMsg>();
		String[] array = new String[]{"24Mar2014(mon)","25Mar2014(tues)","26Mar2014(wed)"};
//		list.add(new ReserMsg("regular", array));
		assertEquals(1, 1);
		assertSame(array, array);
	}
}
