package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "olya775@gmail.com");
        type(By.name("password"), "12345Qwe!");
        click(By.name("login"));

        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Alex");
        type(By.cssSelector("input:nth-child(2)"), "Bron");
        type(By.cssSelector("input:nth-child(3)"), "12345678912");
        type(By.cssSelector("input:nth-child(4)"), "Alex775@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "Rishon");
        type(By.cssSelector("input:nth-child(6)"), "QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        //click on the cart
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    private int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//click on Remove button
//verify contact is deleted(by size)
