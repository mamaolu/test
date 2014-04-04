package tw;

/**
 * �ù���Ϣ��
 * 
 * @author Hongtao
 * 
 */
public class HotelMsg {

	/* �ù����� */
	public String hotelName;
	
	/* �ù��Ǽ� */
	public int rating;
	
	/* ��ͨ�ͻ������ռ۸� */
	public int weekdayRateForRegular;
	
	/* �����ͻ������ռ۸� */
	public int weekdayRateForRewards;
	
	/* ��ͨ�ͻ���ĩ�۸� */
	public int weekendRateForRegular;
	
	/* �����ͻ���ĩ�۸� */
	public int weekendRateForRewards;

	/**
	 * �ù���Ϣ�๹�캯��
	 * @param hotelName  �ù�����
	 * @param rating  �ù��Ǽ�
	 * @param weekdayRateForRegular  ��ͨ�ͻ������ռ۸�
	 * @param weekdayRateForRewards  �����ͻ������ռ۸�
	 * @param weekendRateForRegular  ��ͨ�ͻ���ĩ�۸�
	 * @param weekendRateForRewards  �����ͻ���ĩ�۸�
	 */
	public HotelMsg(String hotelName, int rating, int weekdayRateForRegular,
			int weekdayRateForRewards, int weekendRateForRegular,
			int weekendRateForRewards) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdayRateForRegular = weekdayRateForRegular;
		this.weekdayRateForRewards = weekdayRateForRewards;
		this.weekendRateForRegular = weekendRateForRegular;
		this.weekendRateForRewards = weekendRateForRewards;
	}
}
