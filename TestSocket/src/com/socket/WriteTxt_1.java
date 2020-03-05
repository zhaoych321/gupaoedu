package com.socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Administrator
 * 
 */
public class WriteTxt_1 {

	public static void main(String[] args) {
		
		/*System.out.println(TimeUtils.getTodayStr(1473080454192L));
		System.out.println(TimeUtils.getTodayStr(1473081290476L));
		System.out.println(TimeUtils.getTodayStr(1473081378952L));
		System.out.println(TimeUtils.getTodayStr(1473081650476L));*/
		// 读txt文件里的内容
		try {
			FileReader input = new FileReader("C://Users//fanpengfei//Desktop//gongde.txt");
			BufferedReader br = new BufferedReader(input);
			String text = null;
			int num = 0;
			while ((text = br.readLine()) != null) {
					String str = new String(text.getBytes("GBK"),"UTF-8");
					String newtext = text.replaceAll(" ", "");
					String[] strArr = newtext.split("\\|");
					
					int timeStr = Integer.valueOf(strArr[3]);
////				
////					String newStr = str.replaceAll(timeStr, TimeUtils.getTodayStr(Long.valueOf(timeStr)));
//					String xx = strArr[8].replace("shengyuchange=", "");
//					num += Integer.valueOf(xx);
					if(timeStr > 0){
						num += timeStr;
					}
			}
			System.out.println(num);
			br.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}