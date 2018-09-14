package main.java.tools.utils.file;

import org.junit.Test;

import tools.utils.file.MyFileUtil;

public class MyFileUtilTest {

	@Test
	public void copyToOneDirectory() {
		String directory = "C:\\Users\\vincent\\Desktop\\needChekFiles";
		String pathFile = "C:\\Users\\vincent\\Desktop\\累计修改的store文件列表.txt";
		String destPathPrefix = "G:\\eclipse_git\\marketingcenter_development\\marketingcenter\\";
		MyFileUtil.copyToOneDirectory(destPathPrefix, pathFile, directory);
	}

	@Test
	public void copyToDiffDirectory() {
		String directory = "C:\\Users\\vincent\\Desktop\\needChekFiles\\";
		String pathFile = "C:\\Users\\vincent\\Desktop\\累计修改的store文件列表.txt";
		String destPathPrefix = "G:\\eclipse_git\\marketingcenter_development\\marketingcenter\\";
		MyFileUtil.copyToDiffDirectory(directory, pathFile, destPathPrefix);
	}
}
