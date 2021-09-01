/**
 * @Title: FileUtil.java
 * @Package com.ineng.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author yh
 * @date 2016年6月9日 下午6:24:23
 * @version V1.0
 */
package com.ineng.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

	public static void writeFile(String fileName, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fw) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
