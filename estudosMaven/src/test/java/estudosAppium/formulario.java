package estudosAppium;


import estudosAppium.drive.driverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class formulario {
    private AndroidDriver<MobileElement> driver;
    private DSL dsl = new DSL();

    public formulario() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        driver = driverFactory.getDriver();

        //Selecionar formulário
        driver.findElement(By.xpath("//*[@text='Formulário']"));
        dsl.clicar(By.xpath("//*[@text='Formulário']"));
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
    }

    @Test
    public void preencherNome() {
        //Listar conteudo da tela
        //List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.Textview"));
        //elementosEncontrados.get(1).click();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        // Capturar o campo [Nome] e preencher um [Nome]
        dsl.escrever(MobileBy.AccessibilityId("Nome"), "Wagner");

        //MobileElement campoNome = (MobileElement)driver.findElement(MobileBy.AccessibilityId("Nome"));
        //campoNome.sendKeys("Wagner");
        //String nome = campoNome.getText();

        //Validar o preenchimento do [Nome]
        assertEquals("Wagner", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

    }

    @Test
    public void selecionarCombo() {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        //Clicar no combo
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        // Verificar opção selecionada
        String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        assertEquals("Nitendo Switch", text);

        //driver.findElement(MobileBy.AccessibilityId("console")).click();
        //driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        //String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

    }

    private void click() {
    }

    @Test
    public void selecionarCheckBox() {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));
        check.click();
        switc.click();
        Assert.assertFalse(check.getAttribute("checked").equals("false"));
        Assert.assertFalse(switc.getAttribute("checked").equals("true"));

    }

    @After
    public void fechar() {
        driver.quit();
    }
}
