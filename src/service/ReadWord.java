package service;
import java.io.InputStream;
//import java.io.FileInputStream;
//import java.io.BufferedInputStream;

//import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadWord {

	public String read(InputStream is) throws Exception {

//		System.out.println(FileMagic.valueOf(is));

		String text = "";

//		if (FileMagic.valueOf(is) == FileMagic.OLE2) {
//			WordExtractor ex = new WordExtractor(is);
//			text = ex.getText();
////			
//		} else if (FileMagic.valueOf(is) == FileMagic.OOXML) {
			XWPFDocument doc = new XWPFDocument(is);
			XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
			text = extractor.getText();
			extractor.close();
//		}

		return text;

	}

	public static void main(String[] args) throws Exception {

//		InputStream is = new BufferedInputStream(new FileInputStream("D:\\td\\d.docx")); // really a binary OLE2 Word
																							// file
//		System.out.println(read(is));
//		is.close();

//		is = new BufferedInputStream(new FileInputStream("D:\\td\\demo.doc")); // a OOXML Word file named *.doc
//		System.out.println(read(is));
//		is.close();
//
//		is = new BufferedInputStream(new FileInputStream("D:\\td\\d.docx")); // really a OOXML Word file
//		System.out.println(read(is));
//		is.close();

	}
}