package com.vincent.io.analyse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Optional;

public class AnalysePerformance {

	private static final String env = "test";

	public static void main(String[] args) {
		String saveDirectory = "C:\\Users\\vincent\\Documents\\analyse_log\\" + env + "\\";
		String file1 = "08-15.analyse";
		String file2 = "08-13.analyse";
		List<ReduceBean> reduceList1 = getReduceBeanList(saveDirectory + file1);
		List<ReduceBean> reduceList2 = getReduceBeanList(saveDirectory + file2);
		showUpCompareInfo(reduceList1, reduceList2);
		System.out.println("   -------   -------   -------   -------   -------");
		showDownCompareInfo(reduceList1, reduceList2);
	}

	private static void showUpCompareInfo(List<ReduceBean> reduceList1, List<ReduceBean> reduceList2) {
		reduceList1.stream().forEach(reduce1 -> {
			StringBuilder builder = new StringBuilder();
			Optional<ReduceBean> sameNameBeanOptional = reduceList2.stream()
					.filter(reduce2 -> reduce1.getMethod().equals(reduce2.getMethod())).findAny();
			ReduceBean sameNameBean = sameNameBeanOptional.isPresent() ? sameNameBeanOptional.get() : null;
			if (sameNameBean == null)
				return;

			boolean maxUp = sameNameBean.getMax().getCostTime() > reduce1.getMax().getCostTime();
			if (maxUp) {
				builder.append(String.format("%-70s", sameNameBean.getMethod())).append(" max up: ")
						.append(reduce1.getMax().getCostTime()).append(" to ")
						.append(sameNameBean.getMax().getCostTime());
			}
			if (sameNameBean.getAverage() > reduce1.getAverage()) {
				if (maxUp)
					builder.append("\n");
				builder.append(String.format("%-70s", sameNameBean.getMethod())).append(" average up: ")
						.append(new Double(reduce1.getAverage()).intValue()).append(" to ")
						.append(new Double(sameNameBean.getAverage()).intValue()).append("; count: ")
						.append(reduce1.getCount()).append(" ->").append(sameNameBean.getCount());
			}
			if (builder.length() > 0)
				System.out.println(builder.toString());
		});

	}

	private static void showDownCompareInfo(List<ReduceBean> reduceList1, List<ReduceBean> reduceList2) {
		reduceList1.stream().forEach(reduce1 -> {
			StringBuilder builder = new StringBuilder();
			Optional<ReduceBean> sameNameBeanOptional = reduceList2.stream()
					.filter(reduce2 -> reduce1.getMethod().equals(reduce2.getMethod())).findAny();
			ReduceBean sameNameBean = sameNameBeanOptional.isPresent() ? sameNameBeanOptional.get() : null;
			if (sameNameBean == null)
				return;

			boolean maxUp = sameNameBean.getMax().getCostTime() > reduce1.getMax().getCostTime();
			if (!maxUp) {
				builder.append(String.format("%-70s", sameNameBean.getMethod())).append(" max down: ")
						.append(reduce1.getMax().getCostTime()).append(" to ")
						.append(sameNameBean.getMax().getCostTime());
			}
			if (sameNameBean.getAverage() <= reduce1.getAverage()) {
				if (!maxUp)
					builder.append("\n");
				builder.append(String.format("%-70s", sameNameBean.getMethod())).append(" average down: ")
						.append(new Double(reduce1.getAverage()).intValue()).append(" to ")
						.append(new Double(sameNameBean.getAverage()).intValue()).append("; count: ")
						.append(reduce1.getCount()).append(" ->").append(sameNameBean.getCount());
			}
			if (builder.length() > 0)
				System.out.println(builder.toString());
		});

	}

	@SuppressWarnings("unchecked")
	private static List<ReduceBean> getReduceBeanList(String fileName) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
			return (List<ReduceBean>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
