package com.vincent.io.analyse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AnalyseMain {
	private static String startFlag = "common.aspect.LogAspect";

	private static String timeStopFlag = "接口耗时：";

	private static String methodNameStartFlag = "marketingcenter.api.provider.";

	private static String errorFlag = "common.aspect.LogAspect.doAround";

	private static final String env = "test";

	public static void main(String[] args) {
		String[] fileNameArray = { // "provider.log.2018-09-03_1.log", // "provider.log.2018-08-09.log",
				"provider.log.2018-09-03.log" };
		String directory = "C:\\Users\\vincent\\Downloads\\vr-marketingcenter-marketingcenter-provider\\" + env + "\\";
		for (String fileName : fileNameArray) {
			parseFile(directory + fileName);
		}

		ReduceUtil.reduce();
		ReduceUtil.showResult();
		serialize(fileNameArray);
	}

	private static void serialize(String[] fileNameArray) {
		String saveDirectory = "C:\\Users\\vincent\\Documents\\analyse_log\\" + env + "\\";
		String prefix = "provider.log.2018-";
		String saveFileName = Arrays.stream(fileNameArray).map(name -> {
			return name.substring(prefix.length(), prefix.length() + 5);
		}).collect(Collectors.joining("_"));
		ReduceUtil.saveToFile(saveDirectory + saveFileName + ".analyse");
	}

	private static void parseFile(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			StringBuilder tmpBuilder = new StringBuilder();
			while ((tempString = reader.readLine()) != null) { // 一次读入一行，直到读入null为文件结束
				if (tempString.contains(startFlag) && !tempString.contains(errorFlag)) {
					tmpBuilder.append(tempString);
				}
				if (tempString.contains(timeStopFlag)) {
					tmpBuilder.append(tempString);
					if (!tempString.contains("ERROR")) {
						parseContent(tmpBuilder.toString());
					}
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
		String logTime = content.substring(0, 24);
		String methodName = getBettweenContent(content, methodNameStartFlag, "接口入参");
		String costTime = getBettweenContent(content, timeStopFlag, "ms");
		ReduceUtil.add(new Record(logTime, Integer.parseInt(costTime), methodName));
	}

	private static String getBettweenContent(String content, String startFlag, String endFlag) {
		if (content.contains(endFlag)) {
			return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(endFlag));
		}
		return content.substring(content.indexOf(startFlag) + startFlag.length(), content.indexOf(")"));
	}
}
