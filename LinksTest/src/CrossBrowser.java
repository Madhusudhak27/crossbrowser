import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class CrossBrowser {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\New folder\\chromedriver.exe");          

		ChromeOptions opt = new ChromeOptions();
	    opt.setBinary("C:/Program Files/Google/Chrome Beta/Application/chrome.exe");
	    WebDriver driver = new ChromeDriver(opt);
        
		String fileName = "C:\\SeleniumBrowserDriver\\Successful URL.xlsx";

		 FileInputStream file=new FileInputStream(fileName);
		 
		    try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
				XSSFSheet sheet=workbook.getSheetAt(0);
				    
				int s=sheet.getLastRowNum();
				for(int i=2; i<s; i++){
					
					XSSFCell cell = sheet.getRow(i).getCell(0);
				    System.out.println(cell);
				    
				    String url=cell.toString();
				    driver.get(url);
				    Thread.sleep(10000);
				
				}
				file.close();  
			}
		    
	}

}