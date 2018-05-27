package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WriteWord {
	public String WriteWord(String file,String nd) throws IOException {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MMdd-HH-mm-ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);

		// Write the output to a file
	 
		XWPFDocument document = new XWPFDocument();
		// Create new Paragraph
		XWPFParagraph paragraph1 = document.createParagraph();
		XWPFRun run = paragraph1.createRun();
		run.setText(file);

		XWPFParagraph paragraph2 = document.createParagraph();
		run = paragraph2.createRun();
		nd = nd.replaceAll("<p>", " ");
		nd = nd.replaceAll("</p>", "");
		nd= nd.replaceAll("<br />", "\\n");
		run.setText(nd);
		

		// Write the Document in file system
		file = "C:\\Users\\Admin\\Downloads\\DanhSachBaiDang-" + file + strDate+".docx";
		FileOutputStream out = new FileOutputStream(new File(file));
		document.write(out);
		out.close();
		document.close();
//		Process p = 
//				  Runtime.getRuntime()
//				   .exec("rundll32 url.dll,FileProtocolHandler " + file);
		return "successully";
	}
}
