package com.vincent.io.analyse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
		// 通过 map(s -> {System.out.println("min");return s;});
		// 证明了这些循环没有一次完成而是分成了两次遍历集合,效率有待提高

		Map<String, IntSummaryStatistics> staticsMap = recordList.stream().collect(
				groupingBy(Record::getMethod, mapping(Record::getCostTime, summarizingInt(Integer::intValue))));
		// 深入了解groupBy, mapping, collectingAndThen
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

	public static void saveToFile(String saveDirectory) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(saveDirectory)));
			oos.writeObject(reduceBeanList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
