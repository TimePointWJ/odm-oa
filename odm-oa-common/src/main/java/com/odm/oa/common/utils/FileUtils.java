package com.odm.oa.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static boolean saveToLocal(String filePath, byte[] content) throws IOException {
		File saveDir = new File(filePath);
		if (!saveDir.getParentFile().exists()) {
			saveDir.mkdir();
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(content);
		if (fos != null) {
			fos.close();
		}

		return true;
	}
}
