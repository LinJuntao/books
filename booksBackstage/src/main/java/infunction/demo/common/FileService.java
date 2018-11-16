package infunction.demo.common;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileService {

	public void copy(File s, File t) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fileInputStream = new FileInputStream(s);
			fileOutputStream = new FileOutputStream(t);
			in = fileInputStream.getChannel();
			out = fileOutputStream.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				fileOutputStream.close();
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
