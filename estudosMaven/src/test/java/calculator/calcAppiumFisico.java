package calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class calcAppiumFisico {
    private AndroidDriver<MobileElement> driver;

    public calcAppiumFisico() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "ZF52329NC7");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void somarDoisNumeros() {
        MobileElement el1 = (MobileElement)driver.findElementByAccessibilityId("2");
        el1.click();
        MobileElement el2 = (MobileElement)driver.findElementByAccessibilityId("mais");
        el2.click();
        MobileElement el3 = (MobileElement)driver.findElementByAccessibilityId("3");
        el3.click();
        MobileElement el4 = (MobileElement)driver.findElementById("com.google.android.calculator:id/result_preview");
        el4.click();
        Assert.assertEquals("5", el4.getText());
        System.out.println("A soma é igual á 5");
    }

    @After
    public void fechar() {

        driver.quit();
    }
}