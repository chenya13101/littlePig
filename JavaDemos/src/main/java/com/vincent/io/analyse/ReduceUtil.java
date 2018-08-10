package com.vincent.io.analyse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

public class ReduceUtil {

	private static List<Record> recordList = new ArrayList<>();

	private static List<ReduceBean> reduceBeanList = new ArrayList<>();

	public static void add(Record record) {
		recordList.add(record);
	}

	static void reduce() {
		Set<String> methodSet = recordList.stream().map(Record::getMethod).collect(toSet());
		Map<String, Record> maxRecordMap = recordList.stream().collect(groupingBy(Record::getMethod,
				collectingAndThen(maxBy(Comparator.comparing(Record::getCostTime)), Optional::get)));
		Map<String, Record> minRecordMap = recordList.stream().collect(groupingBy(Record::getMethod,
				collectingAndThen(minBy(Comparator.comparing(Record::getCostTime)), Optional::get)));

		Map<String, IntSummaryStatistics> staticsMap = recordList.stream().collect(
				groupingBy(Record::getMethod, mapping(Record::getCostTime, summarizingInt(Integer::intValue))));
		// TODO 深入了解groupBy, mapping, collectingAndThen
		// collectingAndThen(summarizingInt(Record::getCostTime), toList())

		for (String method : methodSet) {
			IntSummaryStatistics tmpStatics = staticsMap.get(method);
			ReduceBean newBean = new ReduceBean(method, tmpStatics.getCount(), tmpStatics.getAverage(),
					maxRecordMap.get(method), minRecordMap.get(method));
			reduceBeanList.add(newBean);
		}
	}

	static void showResult() {
		reduceBeanList.stream().sorted(Comparator.comparingDouble(ReduceBean::getAverage)).forEach(System.out::println);
	}

}
