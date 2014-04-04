package tw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ����Ԥ����ϢList
 * @author Hongtao
 *
 */
public class ReserListGenerator {

	/**
	 * ���ļ��е�Ԥ����Ϣ��ȡ��list��
	 * 
	 * @param file �ļ�
	 */
	public static List<ReserMsg> generate(String fileName) {
		String line;
		List<ReserMsg> reserList = new ArrayList<ReserMsg>();
		File file = new File(fileName);
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "GBK");
			BufferedReader bufferedReader = new BufferedReader(read);
			while ((line = bufferedReader.readLine()) != null) {
				ReserMsg reserMsg = getReserMsg(line);
				if(null != reserMsg){
					reserList.add(reserMsg);
				}
			}
			bufferedReader.close();
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�������������ʽ��");
		}
		return reserList;
	}
	
	/**
	 * ��Ԥ����Ϣ��װ��ʵ��
	 * @param line Ԥ����Ϣ��
	 * @return ReserMsg
	 */
	private static ReserMsg getReserMsg(String line){
		line = line.replace(" ", "");
		if ("".equals(line)) {
			return null;
		}
		int index = line.indexOf(":");
		if (index == -1) {
			System.out.println("�����ʽ����ȱ��\":\"�ָ���");
			return null;
		}
		String customerType = line.substring(0, index).toLowerCase();
		String reserDate = line.substring(index + 1);
		if ("".equals(customerType)) {
			System.out.println("�ͻ�����δ��д");
			return null;
		}
		if ("".equals(reserDate)) {
			System.out.println("Ԥ������δ��д");
			return null;
		}
		if (!customerType.equals(Constants.REGULAR) 
				&& !customerType.equals(Constants.REWARDS)) {
			System.out.println("�ͻ����ʹ��󣬴������ͣ�" + customerType + "����ȷ���ͣ�Regular��Rewards");
			return null;
		}
		String[] array = getDistinct(reserDate.split(","));
		if (null == array) {
			System.out.println("δ�ҵ���ЧԤ������");
			return null;
		}
		return new ReserMsg(customerType, array);
	}
	
	/**
	 * ȥ���������ظ�ֵ
	 * 
	 * @param array  String����
	 * @return String[]
	 */
	public static String[] getDistinct(String[] array) {
		List<String> list = new ArrayList<String>();
		for (String s : array) {
			if (s.length() < Constants.DATE_LENGTH){
				System.out.println("������Ϣ�����㣬�������ڣ�" + s);
				continue;
			}
			if (!list.contains(s)) {
				list.add(s);
			} else {
				System.out.println("Ԥ�����ڴ����ظ����ظ�����Ϊ��" + s);
			}
		}
		if(list.size()==0){
			return null;
		}
		return list.toArray(new String[1]);
	}
}
