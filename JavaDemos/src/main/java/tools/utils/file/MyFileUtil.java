package tools.utils.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class MyFileUtil {

	/**
	 * 把制定文件中标记的许多类，移动到一个新的指定文件夹中
	 * 
	 * @param destPathPrefix
	 *            "G:\\eclipse_git\\marketingcenter_development\\marketingcenter\\";
	 * @param pathFile
	 *            数据格式为
	 *            marketingcenter-api/src/main/java/com/suneee/marketingcenter/marketingcenter/api/rest/CouponRestService.java
	 *            marketingcenter-api/src/main/java/com/suneee/marketingcenter/marketingcenter/api/rest/MarketingCenterRestService.java
	 *            marketingcenter-api/src/test/java/com/suneee/marketingcenter/marketingcenter/api/rest/TestRestService.java
	 * @param destDir
	 *            "C:\\\\Users\\\\vincent\\\\Desktop\\\\needChekFiles";
	 */
	public static void copyToOneDirectory(String destPathPrefix, String pathFile, String destDir) {
		try {
			String filesInput = FileUtils.readFileToString(new File(pathFile), "utf-8");
			String[] files = filesInput.split("\n");
			Arrays.stream(files).map(String::trim).forEach(tmpFilePath -> {
				try {
					FileUtils.copyFileToDirectory(new File(destPathPrefix + tmpFilePath), new File(destDir));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyToDiffDirectory(String srcDirectory, String pathFileName, String destPathPrefix) {
		try {
			String filesInput = FileUtils.readFileToString(new File(pathFileName), "utf-8");
			String[] files = filesInput.split("\n");

			Arrays.stream(files).map(String::trim).forEach(tmpFilePath -> {
				try {
					int tmpIndex = tmpFilePath.lastIndexOf("/");
					String fileName = tmpFilePath.substring(tmpIndex + 1);
					String srcPath = srcDirectory + fileName;
					String targetPath = destPathPrefix + tmpFilePath;

					FileUtils.copyFile(new File(srcPath), new File(targetPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
