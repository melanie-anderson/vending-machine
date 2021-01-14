package admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LogWriter {
	
	private File file;
	private PrintWriter pw;
	
	public LogWriter(File file) {
		this.file = file;
		try {
		FileOutputStream outputStream = new FileOutputStream(this.file.getAbsoluteFile(), true);
		this.pw = new PrintWriter(outputStream);
		} catch (Exception e) {
			System.out.println("Error opening log file.");
		}
	}
	
	public void writeMessage(String message) {
		this.pw.write(message);
		this.pw.flush();
	}
	
	
	public void closeWriter() {
		this.pw.close();
	}
	

}
