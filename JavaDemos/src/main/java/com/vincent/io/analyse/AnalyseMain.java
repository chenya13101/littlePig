package com.vincent.io.analyse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalyseMain {
	private static String startFlag = "common.aspect.LogAspect";

	private static String stopFlag = "接口耗时";

	public static void main(String[] args) {
		String fileName = "C:\\Users\\vincent\\Downloads\\vr-marketingcenter-marketingcenter-provider\\provider.log";
		parseFile(fileName);
		ReduceUtil.reduce();
		ReduceUtil.showResult();

	}

	private static void parseFile(String fileName) {

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			// System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			StringBuilder tmpBuilder = new StringBuilder();
			while ((tempString = reader.readLine()) != null) { // 一次读入一行，直到读入null为文件结束
				// System.out.println(tempString);
				if (tempString.contains(startFlag)) {
					tmpBuilder.append(tempString);
				}
				if (tempString.contains(stopFlag)) {
					tmpBuilder.append(tempString);
					parseContent(tmpBuilder.toString());
					tmpBuilder = new StringBuilder();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

	}

	private static void parseContent(String content) {
		String apiName = getBettweenContent(content, "marketingcenter.api.provider.", "接口入参");
		String time = getBettweenContent(content, "接口耗时：", "ms");
		ReduceUtil.add(apiName, Integer.parseInt(time));
	}

	private static String getBettweenContent(String content, String startFlag, String endFlag) {
		if (content.contains(endFlag)) {
			return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(endFlag));
		}
		return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(")"));
	}
}
