package tw;
/**
 * 预订信息类
 * 
 * @author Hongtao
 * 
 */
public class ReserMsg {
	
	/* 客户类型 */
	public String customerType;
	
	/* 预订日期数组 */
	public String[] ReserDates;

	/**
	 * 预定信息类构造函数
	 * @param customerType  客户类型
	 * @param message  预订日期数组
	 */
	public ReserMsg(String customerType, String[] ReserDates) {
		this.customerType = customerType;
		this.ReserDates = ReserDates;
	}
}
