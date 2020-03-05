package com.socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Administrator
 * 
 */
public class WriteTxt {

	public static void main(String[] args) {
		
		/*System.out.println(TimeUtils.getTodayStr(1473080454192L));
		System.out.println(TimeUtils.getTodayStr(1473081290476L));
		System.out.println(TimeUtils.getTodayStr(1473081378952L));
		System.out.println(TimeUtils.getTodayStr(1473081650476L));*/
		// 读txt文件里的内容
		try {
			FileReader input = new FileReader("C://Users//fanpengfei//Desktop//gs_4000_20160905_21");
			BufferedReader br = new BufferedReader(input);
			String text = null;
			while ((text = br.readLine()) != null) {
				if(text.startsWith("2012") ) {
					String str = new String(text.getBytes("GBK"),"UTF-8");
//					
//					String[] strArr = text.split("`");
//					String timeStr = strArr[9];
//				
//					String newStr = str.replaceAll(timeStr, TimeUtils.getTodayStr(Long.valueOf(timeStr)));
					
					System.out.println(str);
				}
			}
			br.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}