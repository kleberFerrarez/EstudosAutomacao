package estudosAppium.drive;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", "C:/Users/koliveira/Desktop/aprendizado/gerenciador-contas/estudosMaven/src/main/resources/CTAppium_1_2.apk");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        //driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }
    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
