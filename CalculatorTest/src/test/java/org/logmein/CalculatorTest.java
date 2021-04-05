package org.logmein;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    static WebDriver driver;
    static String input;

    WebElement Number_1;
    WebElement Number_2;
    WebElement Number_3;
    WebElement Number_4;
    WebElement Number_5;
    WebElement Number_6;
    WebElement Number_7;
    WebElement Number_8;
    WebElement Number_9;
    WebElement Number_0;
    WebElement DEL_button;
    WebElement PlUS_button;
    WebElement MINUS_button;
    WebElement MULT_button;
    WebElement DIV_button;
    WebElement EQ_button;
    WebElement OutputField;

    public void Initialize_Elements() {

        Number_1 = driver.findElement(By.xpath("//button[@value='1']"));
        Number_2 = driver.findElement(By.xpath("//button[@value='2']"));
        Number_3 = driver.findElement(By.xpath("//button[@value='3']"));
        Number_4 = driver.findElement(By.xpath("//button[@value='4']"));
        Number_5 = driver.findElement(By.xpath("//button[@value='5']"));
        Number_6 = driver.findElement(By.xpath("//button[@value='6']"));
        Number_7 = driver.findElement(By.xpath("//button[@value='7']"));
        Number_8 = driver.findElement(By.xpath("//button[@value='8']"));
        Number_9 = driver.findElement(By.xpath("//button[@value='9']"));
        Number_0 = driver.findElement(By.xpath("//button[@value='0']"));
        DEL_button = driver.findElement(By.xpath("//button[@value='DEL']"));
        PlUS_button = driver.findElement(By.xpath("//button[@value='+']"));
        MINUS_button = driver.findElement(By.xpath("//button[@value='-']"));
        MULT_button = driver.findElement(By.xpath("//button[@value='×']"));
        DIV_button = driver.findElement(By.xpath("//button[@value='/']"));
        EQ_button = driver.findElement(By.xpath("//button[@value='=']"));
        OutputField = driver.findElement(By.xpath("//*[@id='output']"));
    }

    public void Initialize_Driver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://jsbin.com/hudape/1/");
    }

    public void Terminate_Driver() {

        driver.quit();
    }

    public void verify_calculations_Test() {

        char[] tokens = input.toCharArray();
        Initialize_Elements();

        for(int i=0; i<tokens.length;i++) {

            switch (String.valueOf(tokens[i])) {

                case "0":
                    Number_0.click();
                    break;
                case "1":
                    Number_1.click();
                    break;
                case "2":
                    Number_2.click();
                    break;
                case "3":
                    Number_3.click();
                    break;
                case "4":
                    Number_4.click();
                    break;
                case "5":
                    Number_5.click();
                    break;
                case "6":
                    Number_6.click();
                    break;
                case "7":
                    Number_7.click();
                    break;
                case "8":
                    Number_8.click();
                    break;
                case "9":
                    Number_9.click();
                    break;
                case "+":
                    PlUS_button.click();
                    break;
                case "-":
                    MINUS_button.click();
                    break;
                case "*":
                    MULT_button.click();
                    break;
                case "/":
                    DIV_button.click();
                    break;
                case "=":
                    EQ_button.click();
                    break;
                case "D":
                    DEL_button.click();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    public static void main(String args[]) {

        CalculatorTest calculatorTest = new CalculatorTest();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the arithmetic expression for calculation: ");
        input = scan.next();
        calculatorTest.Initialize_Driver();
        calculatorTest.verify_calculations_Test();
        System.out.println("Input: "+input);
        System.out.println("Output: "+calculatorTest.OutputField.getText());
        calculatorTest.Terminate_Driver();
    }
}
