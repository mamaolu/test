package tw;
/**
 * Ԥ����Ϣ��
 * 
 * @author Hongtao
 * 
 */
public class ReserMsg {
	
	/* �ͻ����� */
	public String customerType;
	
	/* Ԥ���������� */
	public String[] ReserDates;

	/**
	 * Ԥ����Ϣ�๹�캯��
	 * @param customerType  �ͻ�����
	 * @param message  Ԥ����������
	 */
	public ReserMsg(String customerType, String[] ReserDates) {
		this.customerType = customerType;
		this.ReserDates = ReserDates;
	}
}
