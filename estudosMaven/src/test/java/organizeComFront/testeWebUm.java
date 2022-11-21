package organizeComFront;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testeWebUm {
    String url = "http://localhost:8080";
    WebDriver driver;
    WebDriverWait wait;

    public testeWebUm() {
    }

    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver107.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10L);
    }

    @Test
    public void Consult() throws InterruptedException {
        //Navegar URL
        driver.get(url);

        //Clicar no BTN [Nova Compra]
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"navbarNavAltMarkup\"]/div/a[1]")).click();

        //Preencher o campo [Nome do Estabelecimento]
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.id("nomeEstabelecimentoCompra")).sendKeys("Lojinha do Mestre");

        //Preencher o campo [Data Compra]
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.id("dataCompra")).sendKeys("10112022");

        //Preencher o campo [Valor]
        wait.until(ExpectedConditions.elementToBeClickable(By.id("valorCompra")));
        driver.findElement(By.id("valorCompra")).sendKeys("1000");

        //Preencher o campo [Tipo Estabelecimento]
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.id("tipoEstabelecimentoCompra")).sendKeys("Privado");

        //Clicar no BTN [Cadastrar]
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/form/div/button")).click();

        //Validar o Resultado
        String resultado = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals("Lojinha do Mestre", resultado);
    }

    @After
    public void finalizar() {
        driver.quit();
    }
}