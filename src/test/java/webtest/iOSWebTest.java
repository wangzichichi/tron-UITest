package webtest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;

public class iOSWebTest {

    IOSDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing Website on iOS Safari with Java";
    String accessKey = "eyJ4cC51IjozMDAsInhwLnAiOjI5MywieHAubSI6Ik1UVXhNakk1TURjeE5URTVNUSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4Mjg0NDE0NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.YjmUogdZQJwXHfybjoctPi-C1JCKeCLDjl5R-1kpako";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey",accessKey);
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        driver = new IOSDriver(new URL("https://beta.seetest.io:443/wd/hub"),dc);
    }

    @Test
    public void testYourSiteiOS() throws InterruptedException {

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
        if( driver.getCapabilities().getCapability("device.category").equals("TABLET")){

            driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("iPhone");
            driver.findElement(By.xpath("//*[@text='Go']")).click();
        }
        else{
            driver.findElement(By.xpath("//*[@name='k']")).sendKeys("iPhone");
            driver.findElement(By.xpath("//*[@value='Go']")).click();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
        {
            driver.quit();
            System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));

        }
    }

}