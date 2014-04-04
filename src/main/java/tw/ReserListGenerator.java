package tw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成预订信息List
 * @author Hongtao
 *
 */
public class ReserListGenerator {

	/**
	 * 将文件中的预订信息读取到list中
	 * 
	 * @param file 文件
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
			System.out.println("请检查您的输入格式！");
		}
		return reserList;
	}
	
	/**
	 * 将预订信息封装成实例
	 * @param line 预订信息行
	 * @return ReserMsg
	 */
	private static ReserMsg getReserMsg(String line){
		line = line.replace(" ", "");
		if ("".equals(line)) {
			return null;
		}
		int index = line.indexOf(":");
		if (index == -1) {
			System.out.println("输入格式错误！缺少\":\"分隔符");
			return null;
		}
		String customerType = line.substring(0, index).toLowerCase();
		String reserDate = line.substring(index + 1);
		if ("".equals(customerType)) {
			System.out.println("客户类型未填写");
			return null;
		}
		if ("".equals(reserDate)) {
			System.out.println("预订日期未填写");
			return null;
		}
		if (!customerType.equals(Constants.REGULAR) 
				&& !customerType.equals(Constants.REWARDS)) {
			System.out.println("客户类型错误，错误类型：" + customerType + "，正确类型：Regular或Rewards");
			return null;
		}
		String[] array = getDistinct(reserDate.split(","));
		if (null == array) {
			System.out.println("未找到有效预订日期");
			return null;
		}
		return new ReserMsg(customerType, array);
	}
	
	/**
	 * 去掉数组中重复值
	 * 
	 * @param array  String数组
	 * @return String[]
	 */
	public static String[] getDistinct(String[] array) {
		List<String> list = new ArrayList<String>();
		for (String s : array) {
			if (s.length() < Constants.DATE_LENGTH){
				System.out.println("日期信息量不足，错误日期：" + s);
				continue;
			}
			if (!list.contains(s)) {
				list.add(s);
			} else {
				System.out.println("预订日期存在重复，重复日期为：" + s);
			}
		}
		if(list.size()==0){
			return null;
		}
		return list.toArray(new String[1]);
	}
}
