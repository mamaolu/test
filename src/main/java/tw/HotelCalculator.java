package tw;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 计算出最便宜最好的旅馆
 * @author Hongtao
 *
 */
public class HotelCalculator {
	
	/* 工作日天数 */
	private int weekdayCount;

	/* 周末天数 */
	private int weekendCount;
	
	public void getResult(List<ReserMsg> reserList,Map<String, HotelMsg> hotelMap){
		if (reserList.size() > 0) {
			for (ReserMsg item : reserList) {
				int temp = 0;
				boolean init = true;
				String result = "";
				countWeeks(item.ReserDates);
				// 验证方法，测试时启用
				//System.out.println("工作日天数为：" + weekdayCount +",周末天数为：" + weekendCount);
				if (weekdayCount == 0 && weekendCount == 0) {
					System.out.println("未找到有效的预订日期");
					break;
				}
				// 根据预订信息，计算每一个旅馆的价格，并选出最便宜的，如果价格相等，则选择星级最高的
				// hotelMap已将旅馆按照星级从小到大排序
				for (Map.Entry<String, HotelMsg> hm : hotelMap.entrySet()) {
					// 计算该旅馆价格
					int rate = countRate(hm.getValue(), item.customerType);
					if (init) {
						temp = rate;
						init = false;
					}
					if (rate <= temp) {
						result = hm.getValue().hotelName;
					}
				}
				System.out.println(result);
			}
		} else {
			System.out.println("请输入有效的预订信息，例如：Regular: 20Mar2009(fri), 21Mar2009(sat)");
		}
	}
	
	/**
	 * 计算一条预订信息的工作日天数和周末天数
	 * 
	 * @param reserDate 预订日期数组
	 */
	private void countWeeks(String[] reserDate) {
		weekdayCount = 0;
		weekendCount = 0;
		Date now = DateUtil.formatDate(new Date());
		for (String r : reserDate) {
			String subStr = r.substring(0, Constants.DATE_LENGTH);
			Date choiceDate = DateUtil.verifyDate(subStr);
			if (null == choiceDate) {
				System.out.println("预订日期不存在，错误日期：" + subStr);
				continue;
			}
			// 如果格式化的预订日期小于今天，则判定不合法，-1表示小于今天
			if (choiceDate.compareTo(now) == -1) {
				System.out.println("预订日期不得小于当前日期，错误日期：" + subStr);
				continue;
			}
			// 获取预订时间的星期值
			int week = DateUtil.getWeekNum(choiceDate);
			// 根据星期标记，分别计算工作日天数和周末天数,0代表星期日，6代表星期六，1~5表示星期一到星期五
			if (week == 0 || week == 6) {
				weekendCount++;
			} else {
				weekdayCount++;
			}
		}
	}
	
	/**
	 * 根据预订信息计算旅馆价格
	 * 
	 * @param hotel  旅馆信息实例
	 * @param customerType  客户类型
	 * @return 旅馆价格
	 */
	private int countRate(HotelMsg hotel, String customerType) {
		int weekdayRate = 0;
		int weekendRate = 0;
		int result = 0;
		if (customerType.equals(Constants.REGULAR)) {
			weekdayRate = hotel.weekdayRateForRegular;
			weekendRate = hotel.weekendRateForRegular;
		} else if (customerType.equals(Constants.REWARDS)) {
			weekdayRate = hotel.weekdayRateForRewards;
			weekendRate = hotel.weekendRateForRewards;
		}
		result = weekdayRate * weekdayCount + weekendRate * weekendCount;
		// 验证方法，测试时启用
		//System.out.println(hotel.hotelName + "预订价= " + weekdayRate + " * " + weekdayCount
		//		+ " + " + weekendRate + " * " + weekendCount + " = " + result);
		return result;
	}
}
