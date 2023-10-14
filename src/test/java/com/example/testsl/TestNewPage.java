package com.example.testsl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;


public class TestNewPage {
    ChromeDriver chromeDriver;
    String input = "abc122.34@";
    String expected = "122.34";

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
        //set up data
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();


    }

    @Test
    public void run2() {
        System.out.println("run2");
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        sleep(1000);
        WebElement button1 = chromeDriver.findElement(By.className("btn-success"));
        button1.click();
        WebElement text1 = chromeDriver.findElement(By.id("lbStatusButton"));
        String lbtext = text1.getText();
        Assert.assertEquals(lbtext, "Click on Button 1");
        WebElement input1 = chromeDriver.findElement(By.id("txtInput1"));
        String inputValue = input1.getAttribute("value");
        Assert.assertEquals(inputValue, "Default value of input");
        String newValue = "new text";
        input1.clear();
        input1.sendKeys(newValue);
        String valuenew = input1.getAttribute("value");
        Assert.assertEquals(valuenew, "new text");

        // List<WebElement> buttons = chromeDriver.findElements(By.className(("btn-success")));
        // for (int i = 0; i < buttons.size(); i++) {
        //      buttons.get(i).click();
        //    sleep(1000);

        // }

        WebElement element = chromeDriver.findElement(By.id("txtInput2"));

        removeAttribute(element, "disabled");
        element.clear();
        element.sendKeys("thay the");
        setAttribute(element, "disabled");
        WebElement input3 = chromeDriver.findElement(By.id("txtInput3"));
        sendtext(input3, input);
        String actual = getValue(input3);
        Assert.assertEquals(actual, expected);
        sleep(1000);
        WebElement selectElement = chromeDriver.findElement(By.id("exampleSelect1"));
        Select select = new Select(selectElement);
        WebElement selectOption = select.getFirstSelectedOption();
        String option = getValue(selectOption);
        String textOption = gettext(selectOption);
        System.out.println(option);
        System.out.println(textOption);
        WebElement check1 = chromeDriver.findElement(By.id("defaultCheck1"));
        boolean isCheck = check1.isSelected();
        WebElement check2 = chromeDriver.findElement(By.id("defaultCheck2"));
        boolean isCheck2 = check2.isSelected();
        WebElement check3 = chromeDriver.findElement(By.id("defaultCheck3"));
        boolean isCheck3 = check3.isSelected();
        WebElement check4 = chromeDriver.findElement(By.id("defaultCheck4"));
        boolean isCheck4 = check4.isSelected();
        WebElement check5 = chromeDriver.findElement(By.id("defaultCheck5"));
        boolean isCheck5 = check5.isSelected();
        System.out.println(isCheck);
        System.out.println(isCheck2);
        System.out.println(isCheck3);
        System.out.println(isCheck4);
        System.out.println(isCheck5);
        check1.click();
        check1.click();
        check1.click();


        setCheckboxState(check1, true);
        //RADIO
WebElement radio=getCheckElement("exampleRadios");

System.out.println(getValue(radio));

        // Khởi tạo 1 đối tượng action từ lớp actions
        Actions action = new Actions(chromeDriver);

        //move to element
            //action.moveToElement(button1);
        //left click
             // action.click(button1).build().perform();
        // right click
            //action.contextClick(button1).build().perform();
        // double click
          //  action.doubleClick(button1).build().perform();
        //drag drop => kéo thả
            //action.dragAndDrop(button1, button1).build().perform();
        //body testscript
    }

    public WebElement getCheckElement(String groupName) {
        List<WebElement> checkRadios = chromeDriver.findElements(By.name(groupName));
        for (int i = 0; i < checkRadios.size(); i++) {
            WebElement isCheckRadio = checkRadios.get(i);
            if (isCheckRadio.isSelected()) {
                return isCheckRadio;
            }
        }
        return null;
    }

    public void setCheckboxState(WebElement element, boolean isChecked) {
        boolean isActualCheck = element.isSelected();
        if (isChecked != isActualCheck) {
            element.click();
        }

    }

    public void removeAttribute(WebElement element, String attr) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].removeAttribute('" + attr + "')", element);
    }

    public void setAttribute(WebElement element, String attr) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].setAttribute('" + attr + "','')", element);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
        //chromeDriver.quit();
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public String gettext(WebElement element) {
        return element.getText();
    }

    public void sendtext(WebElement element, String input) {
        element.clear();
        sleep(1000);
        element.sendKeys(input);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
