package com.vincent.io.analyse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ReduceUtil {

	private static Map<String, List<Integer>> methodTimeMap = new ConcurrentHashMap<>();

	private static Map<String, ReduceBean> methodBeanMap = new TreeMap<>();

	static void add(String method, int time) {
		List<Integer> list = methodTimeMap.get(method);
		if (list != null) {
			list.add(time);
			methodTimeMap.put(method, list);
		} else {
			list = new ArrayList<>();
			list.add(time);
			methodTimeMap.put(method, list);
		}
	}

	static void reduce() {
		methodTimeMap.forEach((key, valueList) -> {
			IntSummaryStatistics statics = valueList.stream().collect(Collectors.summarizingInt(Integer::intValue));
			ReduceBean newBean = new ReduceBean(key, valueList.size(), statics.getAverage(), statics.getMax(),
					statics.getMin());
			methodBeanMap.put(key, newBean);
		});
	}

	static void showResult() {
		methodBeanMap.values().stream().sorted(Comparator.comparingDouble(ReduceBean::getAverage))
				.forEach(System.out::println);
	}

}
