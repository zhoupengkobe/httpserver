package com.kobe.Until;

import java.io.Closeable;

/**
 * 关闭流的方法
 * @author ko
 *
 */
public class CloseUtil {

	public static void closeAll(Closeable... io){
		for (Closeable temp : io) {
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
				
			}
		}
	}

}
