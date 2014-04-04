package tw;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ������������õ��ù�
 * @author Hongtao
 *
 */
public class HotelCalculator {
	
	/* ���������� */
	private int weekdayCount;

	/* ��ĩ���� */
	private int weekendCount;
	
	public void getResult(List<ReserMsg> reserList,Map<String, HotelMsg> hotelMap){
		if (reserList.size() > 0) {
			for (ReserMsg item : reserList) {
				int temp = 0;
				boolean init = true;
				String result = "";
				countWeeks(item.ReserDates);
				// ��֤����������ʱ����
				//System.out.println("����������Ϊ��" + weekdayCount +",��ĩ����Ϊ��" + weekendCount);
				if (weekdayCount == 0 && weekendCount == 0) {
					System.out.println("δ�ҵ���Ч��Ԥ������");
					break;
				}
				// ����Ԥ����Ϣ������ÿһ���ùݵļ۸񣬲�ѡ������˵ģ�����۸���ȣ���ѡ���Ǽ���ߵ�
				// hotelMap�ѽ��ùݰ����Ǽ���С��������
				for (Map.Entry<String, HotelMsg> hm : hotelMap.entrySet()) {
					// ������ùݼ۸�
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
			System.out.println("��������Ч��Ԥ����Ϣ�����磺Regular: 20Mar2009(fri), 21Mar2009(sat)");
		}
	}
	
	/**
	 * ����һ��Ԥ����Ϣ�Ĺ�������������ĩ����
	 * 
	 * @param reserDate Ԥ����������
	 */
	private void countWeeks(String[] reserDate) {
		weekdayCount = 0;
		weekendCount = 0;
		Date now = DateUtil.formatDate(new Date());
		for (String r : reserDate) {
			String subStr = r.substring(0, Constants.DATE_LENGTH);
			Date choiceDate = DateUtil.verifyDate(subStr);
			if (null == choiceDate) {
				System.out.println("Ԥ�����ڲ����ڣ��������ڣ�" + subStr);
				continue;
			}
			// �����ʽ����Ԥ������С�ڽ��죬���ж����Ϸ���-1��ʾС�ڽ���
			if (choiceDate.compareTo(now) == -1) {
				System.out.println("Ԥ�����ڲ���С�ڵ�ǰ���ڣ��������ڣ�" + subStr);
				continue;
			}
			// ��ȡԤ��ʱ�������ֵ
			int week = DateUtil.getWeekNum(choiceDate);
			// �������ڱ�ǣ��ֱ���㹤������������ĩ����,0���������գ�6������������1~5��ʾ����һ��������
			if (week == 0 || week == 6) {
				weekendCount++;
			} else {
				weekdayCount++;
			}
		}
	}
	
	/**
	 * ����Ԥ����Ϣ�����ùݼ۸�
	 * 
	 * @param hotel  �ù���Ϣʵ��
	 * @param customerType  �ͻ�����
	 * @return �ùݼ۸�
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
		// ��֤����������ʱ����
		//System.out.println(hotel.hotelName + "Ԥ����= " + weekdayRate + " * " + weekdayCount
		//		+ " + " + weekendRate + " * " + weekendCount + " = " + result);
		return result;
	}
}
