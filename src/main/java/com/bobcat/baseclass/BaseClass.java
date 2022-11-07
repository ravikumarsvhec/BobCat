package com.bobcat.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public static void browserlaunch() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\91952\\eclipse-workspace\\Selenium\\src\\Jar and Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public static void url(String url) {
		driver.get(url);
	}

	public static void sendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static WebElement findelementbyid(String id) {
		return driver.findElement(By.id(id));

	}

	public static WebElement findelementbyxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void selectbyindex(WebElement element, int indexvalue) {
		Select s = new Select(element);
		s.selectByIndex(indexvalue);
	}

	public static void selectbyvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectbyvisible(WebElement element, String visibletext) {
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}

	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void screenshot() throws IOException {
		Date d = new Date();
		SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		TakesScreenshot ss = ((TakesScreenshot) driver);
		File origin = ss.getScreenshotAs(OutputType.FILE);
		String screen = "screenshot";
		File destination = new File("D:\\" + screen + dtf.format(d) + ".jpeg");
		FileUtils.copyFile(origin, destination);

	}

	public static String exceldataread(int rowno, int cellno) {
		String value = null;
		try {
			File f = new File(
					"C:\\Users\\91952\\eclipse-workspace\\Aiiteprogram2\\src\\test\\resources\\TestData\\Aiite Program2.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(rowno);
			Cell cell = row.getCell(cellno);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					value = sdf.format(dateCellValue);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
				}

			}
		} catch (Exception e) {
		}
		return value;

	}

	public static String readpropfile(String input) {
		String value = null;
		try {
			FileReader read = new FileReader(new File(
					"C:\\Users\\91952\\eclipse-workspace\\Flipkartproject\\src\\test\\resources\\input.properties"));
			Properties prop = new Properties();
			prop.load(read);
			value = prop.getProperty(input);
			// System.out.println(prop.getProperty("username"));
			// System.out.println(prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public static void movetoelement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void listofelements(List<WebElement>elements) {
		for (WebElement webElements : elements) {
			//String text = webElements.getText();
			System.out.println(webElements.getText());
		}

	}

}
