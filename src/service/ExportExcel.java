package service;

import org.apache.poi.xssf.usermodel.*;

import model.content;
import model.menu;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ExportExcel {
	private static final String[] titles = { "MENU", "NAME", "SUMMARY", "AUTHOR","DATE" };

	public void ExportFile(String from, String to) {
		Workbook wb;

		// if (args.length > 0 && args[0].equals("-xls"))
		wb = new HSSFWorkbook();
		// else
		// wb = new XSSFWorkbook();

		Map<String, CellStyle> styles = createStyles(wb);

		Sheet sheet = wb.createSheet("Timesheet");
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		// title row
		Row titleRow = sheet.createRow(3);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(5);
		titleCell.setCellValue("Danh sách các bài đăng");
		titleCell.setCellStyle(styles.get("title"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));

		// //header row
		Row headerRow = sheet.createRow(5);
		headerRow.setHeightInPoints(41);
		Cell headerCell;
		for (int i = 0; i < titles.length; i++) {
			headerCell = headerRow.createCell(i + 3);
			headerCell.setCellValue(titles[i]);
			headerCell.setCellStyle(styles.get("header"));
		}
		ListMenu lxp = new ListMenu();
		List<menu> lmnxp = lxp.listContentExportForDate(from,to);
		int rownum = 6;
		for (int i = 0; i < lmnxp.size(); i++) { // 10=list.size()
			Row row = sheet.createRow(rownum++);
			for (int j = 3; j < titles.length + 3; j++) {
				Cell cell = row.createCell(j);

				cell.setCellStyle(styles.get("cell"));

			}
		}
		//
		// //row with totals below
		// Row sumRow = sheet.createRow(rownum++);
		// sumRow.setHeightInPoints(35);
		// Cell cell;
		// cell = sumRow.createCell(6);
		// cell.setCellStyle(styles.get("cell"));
		// cell.setCellValue("4");
		// cell = sumRow.createCell(5);
		// cell.setCellValue("Total Hrs:");
		// cell.setCellStyle(styles.get("cell"));

		//
		// for (int j = 2; j < 12; j++) {
		// cell = sumRow.createCell(j);
		// String ref = (char)('A' + j) + "3:" + (char)('A' + j) + "12";
		// cell.setCellFormula("SUM(" + ref + ")");
		// if(j >= 9) cell.setCellStyle(styles.get("formula_2"));
		// else cell.setCellStyle(styles.get("formula"));
		// }
		// rownum++;
		// sumRow = sheet.createRow(rownum++);
		// sumRow.setHeightInPoints(25);
		// cell = sumRow.createCell(0);
		// cell.setCellValue("Total Regular Hours");
		// cell.setCellStyle(styles.get("formula"));
		// cell = sumRow.createCell(1);
		// cell.setCellFormula("L13");
		// cell.setCellStyle(styles.get("formula_2"));
		// sumRow = sheet.createRow(rownum++);
		// sumRow.setHeightInPoints(25);
		// cell = sumRow.createCell(0);
		// cell.setCellValue("Total Overtime Hours");
		// cell.setCellStyle(styles.get("formula"));
		// cell = sumRow.createCell(1);
		// cell.setCellFormula("K13");
		// cell.setCellStyle(styles.get("formula_2"));
		//
		// //set sample data
		
		
		String data[][] = new String[lmnxp.size()][5];
		int m = 0;
		int n = 0;
		for (menu mn : lmnxp) {
			n = 0;
			data[m][n] = mn.getMenu();
			for (content ct : mn.getContents()) {

				data[m][n + 1] = ct.getTen();
				data[m][n + 2] = ct.getSummary();
				data[m][n + 3] = ct.getAuthor();
				data[m][n + 4] = ct.getDate().toString();
				n++;
			}
			m++;
		}
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.getRow(i + 6);
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == null)
					continue;
				// if (data[i][j] instanceof String) {
				row.getCell(j + 3).setCellValue((String) data[i][j]);
				// } else {
				// row.getCell(j + 3).setCellValue((Double) data[i][j]);
				// }
			}
		}
		sheet.setColumnWidth(3, 15 * 256);
		sheet.setColumnWidth(4, 50 * 256);
		sheet.setColumnWidth(5, 60 * 256);
		sheet.setColumnWidth(6, 10 * 256);
		sheet.setColumnWidth(7, 12 * 256);
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MMdd-HH-mm-ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		
		// Write the output to a file
		String file = "C:\\Users\\Admin\\Downloads\\DanhSachBaiDang-"+strDate+".xls";
		if (wb instanceof XSSFWorkbook)
			file += "x";
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			wb.write(out);
//			out.close();
			Process p = 
					  Runtime.getRuntime()
					   .exec("rundll32 url.dll,FileProtocolHandler " + file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Create a library of cell styles
	 */
	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		Font monthFont = wb.createFont();
		monthFont.setFontHeightInPoints((short) 11);
		monthFont.setColor(IndexedColors.WHITE.getIndex());
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("header", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setWrapText(true);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		styles.put("cell", style);

		return styles;
	}
}