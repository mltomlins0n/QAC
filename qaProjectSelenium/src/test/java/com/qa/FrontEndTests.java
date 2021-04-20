package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrontEndTests {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void projectHomeNavTest() throws InterruptedException {
        driver.get("http://35.228.126.86/index.html");
        Thread.sleep(500);

        WebElement driverButton = driver.findElement(By.id("drivers"));
        driverButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        WebElement constructorButton = driver.findElement(By.id("constructors"));
        Thread.sleep(500);
        constructorButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(1000);
    }

    @Test
    public void projectDriverPageNavTest() throws InterruptedException {
        driver.get("http://35.228.126.86/drivers.html");
        Thread.sleep(500);

        WebElement homeButton = driver.findElement(By.id("home"));
        homeButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        WebElement constructorsButton = driver.findElement(By.id("constructors"));
        constructorsButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(1000);
    }

    @Test
    public void projectConstructorPageNavTest() throws InterruptedException {
        driver.get("http://35.228.126.86/constructors.html");
        Thread.sleep(500);

        WebElement homeButton = driver.findElement(By.id("home"));
        homeButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        WebElement driversButton = driver.findElement(By.id("drivers"));
        driversButton.click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(1000);
    }

    @Test
    public void addDriverTest() throws InterruptedException {
        driver.get("http://35.228.126.86/drivers.html");
        Thread.sleep(1000);

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[1]"));
        addButton.click();
        Thread.sleep(500);

        WebElement driverNameField = driver.findElement(By.name("addDriverName"));
        driverNameField.sendKeys("Selenium Driver");
        Thread.sleep(500);
        WebElement teamNameField = driver.findElement(By.name("addTeamName"));
        teamNameField.sendKeys("Selenium Racing");
        Thread.sleep(500);
        WebElement pointsField = driver.findElement(By.name("addPoints"));
        pointsField.sendKeys(Keys.NUMPAD4, Keys.NUMPAD2);

        WebElement addDriverButton = driver.findElement
                (By.xpath("//*[@id=\"addDriverModal\"]/div/div/div[2]/form/div[4]/button"));
        addDriverButton.submit();
        Thread.sleep(1000);
    }

    @Test
    public void updateDriverTest() throws InterruptedException {
        driver.get("http://35.228.126.86/drivers.html");

        WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[2]"));
        updateButton.click();
        Thread.sleep(500);

        WebElement driverIDField = driver.findElement(By.name("updateDriverID"));
        // Change this number to the ID of the driver added in addDriverTest()
        driverIDField.sendKeys(Keys.NUMPAD5, Keys.NUMPAD9);
        Thread.sleep(500);
        WebElement driverNameField = driver.findElement(By.name("updateName"));
        Thread.sleep(500);
        driverNameField.sendKeys("Updated Selenium Driver");
        Thread.sleep(500);
        WebElement teamNameField = driver.findElement(By.name("updateTeam"));
        teamNameField.sendKeys("Updated Selenium Racing");
        Thread.sleep(500);
        WebElement pointsField = driver.findElement(By.name("updatePoints"));
        pointsField.sendKeys(Keys.NUMPAD4, Keys.NUMPAD8);
        Thread.sleep(500);

        WebElement updateDriverButton = driver.findElement
                (By.xpath("//*[@id=\"updateDriverModal\"]/div/div/div[2]/form/div[5]/button"));
        updateDriverButton.submit();
        Thread.sleep(1000);
    }

    @Test
    public void deleteDriverTest() throws InterruptedException {
        driver.get("http://35.228.126.86/drivers.html");
        Thread.sleep(1000);

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[3]"));
        deleteButton.click();
        Thread.sleep(500);

        WebElement idField = driver.findElement(By.name("idToDelete"));
        Thread.sleep(1000);
        // Change this number to the ID of the driver updated in updateDriverTest()
        idField.sendKeys(Keys.NUMPAD6, Keys.NUMPAD1);
        Thread.sleep(500);

        WebElement deleteDriverButton = driver.findElement
                (By.xpath("//*[@id=\"deleteDriverModal\"]/div/div/div[2]/form/div[2]/button"));
        deleteDriverButton.click();
        Thread.sleep(1000);
    }

    @Test
    public void addTeamTest() throws InterruptedException {
        driver.get("http://35.228.126.86/constructors.html");
        Thread.sleep(1000);

        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[1]"));
        addButton.click();
        Thread.sleep(500);

        WebElement teamNameField = driver.findElement(By.name("addTeamName"));
        teamNameField.sendKeys("Selenium Racing");
        Thread.sleep(500);
        WebElement pointsField = driver.findElement(By.name("addTeamPoints"));
        pointsField.sendKeys(Keys.NUMPAD4, Keys.NUMPAD2);

        WebElement addTeamButton = driver.findElement
                (By.xpath("//*[@id=\"addTeamModal\"]/div/div/div[2]/form/div[3]/button"));
        addTeamButton.submit();
        Thread.sleep(1000);
    }

    @Test
    public void updateTeamTest() throws InterruptedException {
        driver.get("http://35.228.126.86/constructors.html");
        Thread.sleep(500);

        WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[2]"));
        updateButton.click();

        Thread.sleep(500);
        WebElement teamIDField = driver.findElement(By.name("updateTeamID"));
        // Change this number to the ID of the team added in addTeamTest()
        teamIDField.sendKeys(Keys.NUMPAD1, Keys.NUMPAD8);
        Thread.sleep(500);
        WebElement teamNameField = driver.findElement(By.name("updateTeamName"));
        teamNameField.sendKeys("Updated Selenium Racing");
        Thread.sleep(500);
        WebElement pointsField = driver.findElement(By.name("updateTeamPoints"));
        pointsField.sendKeys(Keys.NUMPAD4, Keys.NUMPAD6);
        Thread.sleep(500);

        WebElement updateTeamButton = driver.findElement
                (By.xpath("//*[@id=\"updateTeamModal\"]/div/div/div[2]/form/div[4]/button"));
        updateTeamButton.submit();
        Thread.sleep(1000);
    }

    @Test
    public void deleteTeamTest () throws InterruptedException {
        driver.get("http://35.228.126.86/constructors.html");
        Thread.sleep(1000);

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tableButtons\"]/button[3]"));
        deleteButton.click();
        Thread.sleep(500);

        WebElement idField = driver.findElement(By.name("deleteTeamID"));
        Thread.sleep(500);
        // Change this number to the ID of the team updated in updateTeamTest()
        idField.sendKeys(Keys.NUMPAD1, Keys.NUMPAD8);
        Thread.sleep(500);

        WebElement deleteTeamButton = driver.findElement
                (By.xpath("//*[@id=\"deleteTeamModal\"]/div/div/div[2]/form/div[2]/button"));
        deleteTeamButton.submit();
        Thread.sleep(1000);
    }
}