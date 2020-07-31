package swing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class manageExcel {
	
	String path = "C:\\Users\\excel.xlsx";
	
	
	public void createExcelfile(ArrayList<Object[]> datalist) {
		
		//https://www.it-swarm.dev/ko/java/excel-%ED%8C%8C%EC%9D%BC%EC%9D%84-%EC%9D%BD%EA%B3%A0-%EC%93%B0%EB%8A%94-%EB%B2%95/967150332/
		
	    //Blank workbook
	    XSSFWorkbook workbook = new XSSFWorkbook(); //엑셀 파일 객체

	    //Create a blank sheet
	    XSSFSheet sheet = workbook.createSheet("public library");

	    //This data needs to be written (Object[])
	    Map<String, Object[]> data = new TreeMap<String, Object[]>(); //첫번째 줄
	    data.put("1", new Object[]{"code","bookname","author","editorial","publish_day","condition","kind","Remain","Category"}); 
	    
	    for(int i = 0; i< datalist.size(); i++) {
	    	data.put(Integer.toString(i+2), datalist.get(i));
	    }

    //Iterate over data and write to sheet
	    Set<String> keyset = data.keySet();

	    int rownum = 0;
	    for (String key : keyset) 
	    {
	        //create a row of excelsheet
	        Row row = sheet.createRow(rownum++);

	        //get object array of prerticuler key
	        Object[] objArr = data.get(key);

	        int cellnum = 0;

	        for (Object obj : objArr) 
	        {
	            Cell cell = row.createCell(cellnum++);
	            if (obj instanceof String) 
	            {
	                cell.setCellValue((String) obj);
	            }
	            else if (obj instanceof Integer) 
	            {
	                cell.setCellValue((Integer) obj);
	            }
	        }
	    }
	    try 
	    {
	        //Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File(path));
	        workbook.write(out);
	        out.close();
	        System.out.println("Success");
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    
	}
	
	public ArrayList<String[]> readExcelfile() {
		
		//��ó �Դϴ� ->> https://www.it-swarm.dev/ko/java/excel-%ED%8C%8C%EC%9D%BC%EC%9D%84-%EC%9D%BD%EA%B3%A0-%EC%93%B0%EB%8A%94-%EB%B2%95/967150332/
	
        ArrayList<String[]> dataStringlist = new ArrayList<>(); //빈곽 변수 생성
																//엑셀파일을 읽는다
	    try {
	        FileInputStream file = new FileInputStream(new File(path));

	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);


	        
	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        int startrow = 0;
			while (rowIterator.hasNext()) {
				if (startrow != 0) {
					startrow++;
					Row row = rowIterator.next();
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();

					String[] stringArray = new String[9];       //나의 변수 값 9개
					
			        int calrow = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// Check the cell type and format accordingly
						stringArray[calrow] = cell.getStringCellValue();      //방의 크기
						calrow = calrow+1;
						//System.out.print(cell.getStringCellValue() + " ");

					}
					
					dataStringlist.add(stringArray);
					
					
				}else {
					rowIterator.next();       //row 행 (아파치에 월래 쓰여 있음)
					startrow++;
				}
				
			}
	        file.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		

	    return dataStringlist;
	    
	}

}
