package tronlink;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import common.utils.TronLink;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Markets {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        TronLink.screenOn();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities = TronLink.getTronLinkDesiredCapabilities(desiredCapabilities);
        URL remoteUrl = new URL(TronLink.tronLinkUrl);
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver = TronLink.importWallet(driver,TronLink.testPrivateKey);
    }

    @Test(enabled = true, threadPoolSize = 1, invocationCount = 1)
    public void test01marketsScreen() {
        TronLink.testOperation(driver,TronLink.marketsIconId,"click","Enter markets screen");
        TronLink.testOperation(driver,TronLink.priceChangeId,"click","Price sort change");
        List<MobileElement> elements =  driver.findElements(MobileBy.id(TronLink.marketsExchangeListId));

        System.out.println(elements.get(0));



    }


    @AfterClass
    public void tearDown() {
       driver.quit();
    }
}
