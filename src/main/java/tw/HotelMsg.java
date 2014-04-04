package tw;

/**
 * 旅馆信息类
 * 
 * @author Hongtao
 * 
 */
public class HotelMsg {

	/* 旅馆名称 */
	public String hotelName;
	
	/* 旅馆星级 */
	public int rating;
	
	/* 普通客户工作日价格 */
	public int weekdayRateForRegular;
	
	/* 奖励客户工作日价格 */
	public int weekdayRateForRewards;
	
	/* 普通客户周末价格 */
	public int weekendRateForRegular;
	
	/* 奖励客户周末价格 */
	public int weekendRateForRewards;

	/**
	 * 旅馆信息类构造函数
	 * @param hotelName  旅馆名称
	 * @param rating  旅馆星级
	 * @param weekdayRateForRegular  普通客户工作日价格
	 * @param weekdayRateForRewards  奖励客户工作日价格
	 * @param weekendRateForRegular  普通客户周末价格
	 * @param weekendRateForRewards  奖励客户周末价格
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
