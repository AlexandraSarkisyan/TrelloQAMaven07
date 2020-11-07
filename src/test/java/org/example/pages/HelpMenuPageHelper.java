package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HelpMenuPageHelper extends PageBase{

    public HelpMenuPageHelper(WebDriver driver) {
        super(driver);
    }
    public String getTextLine1(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='vsc7lMp7MQFsrC']")));
        return driver.findElement(By.xpath("//a[contains(text(),'Getting Started Guide')]")).getText();

    }
    public String getTextLine2(){
        return driver.findElement(By.xpath("//a[contains(text(),'Getting started with Trello video Demo')]")).getText();

    }
    public String getTextLine3(){
        return driver.findElement(By.xpath("//a[contains(text(),'Troubleshooting browser issues with Trello')]")).getText();

    }
    public String getTextLine4(){
         return driver.findElement(By.xpath("//a[contains(text(),'What are teams?')]")).getText();

    }
    public String getTextLine5(){
         return driver.findElement(By.xpath("//a[contains(text(),'How to use Trello like a pro')]")).getText();

    }

    /*public ArrayList<String> helpListIsCorrect(){
        String res="";
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='vsc7lMp7MQFsrC']")));
        Select list = new Select(driver.findElement(By.id("search-results")));
        ArrayList<String> listHelp =new<> ArrayList;
        for(int i =1; i<6;i++){
           res = list.selectByIndex(i);
            listHelp.add(i);
        }
          return listHelp;
    }*/


}
