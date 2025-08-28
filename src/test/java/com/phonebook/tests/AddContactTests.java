package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{

    //pre-condition login
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "olya775@gmail.com");
        type(By.name("password"), "12345Qwe!");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest(){
        //click on link ADD
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Alex");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), "Bron");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "12345678912");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "Alex775@gmail.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Rishon");
        //enter description
        type(By.cssSelector("input:nth-child(6)"), "QA");
        //click SAVE button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //verify contact is added
        Assert.assertTrue(isContactAdded("Alex"));

    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement element: contacts){
            if(element.getText().contains(text))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postCondition(){
        //driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //driver.findElement(By.xpath("//button[.='Remove']")).click();
        click(By.xpath("//button[.='Remove']"));
    }


}