package counseling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/***
 * 
 * @author Gopal
 *
 */
public class CollegeCounseling {

    FormulaEvaluator studentFormulaEvaluator;
    FormulaEvaluator branchFormulaEvaluator;
    
    Map<String, Integer> collegeProgram = new HashMap<String, Integer>();
    HSSFSheet studentProgram ;
    HSSFSheet barnchProgram ;
    Map<String, Queue> allottedBranch = new  HashMap<String, Queue>();
    
    CollegeCounseling() throws IOException{
        FileInputStream studentSheet = new FileInputStream(new File("C:\\Users\\Gopal\\workspace\\DSA2\\src\\Student.xls"));
        FileInputStream branchSheet = new FileInputStream(new File("C:\\Users\\Gopal\\workspace\\DSA2\\src\\College.xls"));
        
        HSSFWorkbook wb = new HSSFWorkbook(studentSheet);
        HSSFSheet sheet = wb.getSheetAt(0);
        this.studentProgram = sheet;
        studentFormulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        System.out.println("********************************************Student Sheet************************************************");
        for (Row row : sheet)
        {
            for (Cell cell : row) 
            {
                switch (studentFormulaEvaluator.evaluateInCell(cell).getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: System.out.print(String.format("%-15s",cell.getNumericCellValue()));
                    break;
                case Cell.CELL_TYPE_STRING: System.out.print(String.format("%-15s",cell.getStringCellValue()));
                    break;
                }
            }
            System.out.println();
        }
        wb.close();
        
        HSSFWorkbook wb1 = new HSSFWorkbook(branchSheet);
        HSSFSheet sheet1 = wb1.getSheetAt(0);
        this.barnchProgram = sheet1;
        branchFormulaEvaluator = wb1.getCreationHelper().createFormulaEvaluator();
        String collegeProgramName = "";
        
        
        System.out.println("********************************************College Sheet************************************************");
        for (Row row : sheet1) 
        {
            for (Cell cell : row)
            {
                switch (studentFormulaEvaluator.evaluateInCell(cell).getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.print(String.format("%-15s",
                            cell.getStringCellValue()));
                    collegeProgramName = cell.toString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.println((int)cell.getNumericCellValue());
                    collegeProgram.put(collegeProgramName,(int) Double.parseDouble(cell.toString()));
                    break;
                
                }
            }
        }
        wb1.close();
        
    }

    public void allotBranch() {
        String name = "";
        boolean nameFlag;
        String cellValue;

        for (HashMap.Entry<String, Integer> entry : collegeProgram.entrySet()) {
            allottedBranch.put(entry.getKey(), new Queue(
                    entry.getValue()));
        }
        for (Row row : studentProgram) {
            nameFlag = true;
            for (Cell cell : row)
            {
                if (studentFormulaEvaluator.evaluateInCell(cell).getCellType() == Cell.CELL_TYPE_STRING) {
                    cellValue = cell.getStringCellValue();
                    if (nameFlag) {
                        name = cellValue;
                        nameFlag = false;
                    } else {
                        if (allottedBranch.containsKey(cellValue)) {
                            if (allottedBranch.get(cellValue).isFull()) {
                                continue;
                            } else {
                                allottedBranch.get(cellValue).enqueue(name);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
   
    void displayAllottedResult(){
    	System.out.println("********************************************College Allotted List******************************************");
        for (HashMap.Entry<String, Queue> entry : allottedBranch.entrySet()) {
            System.out.print(entry.getKey()+" : ");
            entry.getValue().display();
        }
    }
    
    void saveData() throws FileNotFoundException, IOException{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("SelectedStudents");
        Cell cell;
        Row row ;
        int rowCount = 0, colCount = 0;

        row = sheet.createRow(rowCount);
        cell = row.createCell(colCount);
        cell.setCellValue((String) "Name");
        cell = row.createCell(colCount+1);
        cell.setCellValue((String) "Program");
        rowCount++;
        
        for (HashMap.Entry<String, Queue> entry : allottedBranch.entrySet()) {
            for(String name: entry.getValue().getQueue()){
                row = sheet.createRow(rowCount);
                cell = row.createCell(colCount);
                cell.setCellValue((String) name);
                cell = row.createCell(colCount+1);
                cell.setCellValue(entry.getKey());
                rowCount++;
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("SelectedStudents.xls")) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
}
