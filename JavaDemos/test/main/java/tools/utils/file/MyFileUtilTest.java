package main.java.tools.utils.file;

import org.junit.Test;

import tools.utils.file.MyFileUtil;

public class MyFileUtilTest {

	@Test
	public void copy() {
		String directory = "C:\\\\Users\\\\vincent\\\\Desktop\\\\needChekFiles";
		String pathFile = "C:\\Users\\vincent\\Desktop\\累计修改的store文件列表.txt";
		String destPathPrefix = "G:\\eclipse_git\\marketingcenter_development\\marketingcenter\\";
		MyFileUtil.copy(destPathPrefix, pathFile, directory);
	}
}
