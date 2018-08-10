package com.vincent.io.analyse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AnalyseMain {
	private static String startFlag = "common.aspect.LogAspect";

	private static String timeStopFlag = "接口耗时：";

	private static String methodNameStartFlag = "marketingcenter.api.provider.";

	public static void main(String[] args) {
		String[] fileNameArray = { "provider.log.2018-08-08.log", "provider.log.2018-08-09.log",
				"provider.log.2018-08-10.log" };
		String directory = "C:\\Users\\vincent\\Downloads\\vr-marketingcenter-marketingcenter-provider\\";
		for (String fileName : fileNameArray) {
			parseFile(directory + fileName);
		}

		ReduceUtil.reduce();
		ReduceUtil.showResult();
	}

	private static void parseFile(String fileName) {

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			StringBuilder tmpBuilder = new StringBuilder();
			while ((tempString = reader.readLine()) != null) { // 一次读入一行，直到读入null为文件结束
				if (tempString.contains(startFlag)) {
					tmpBuilder.append(tempString);
				}
				if (tempString.contains(timeStopFlag)) {
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
		String apiName = getBettweenContent(content, methodNameStartFlag, "接口入参");
		String time = getBettweenContent(content, timeStopFlag, "ms");
		ReduceUtil.add(apiName, Integer.parseInt(time));
	}

	private static String getBettweenContent(String content, String startFlag, String endFlag) {
		if (content.contains(endFlag)) {
			return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(endFlag));
		}
		return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(")"));
	}
}
