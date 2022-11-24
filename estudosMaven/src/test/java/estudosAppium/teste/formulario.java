package estudosAppium.teste;


import estudosAppium.drive.driverFactory;
import estudosAppium.page.FormularioPage;
import estudosAppium.page.MenuPage;
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
    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    public formulario() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        driver = driverFactory.getDriver();

        //Selecionar formulário
        menu.acessarFormulario();

        //dsl.clicar(By.xpath("//*[@text='Formulário']"));
        //dsl.clicarPorTexto("Formulário");
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
    }

    @Test
    public void preencherNome() throws MalformedURLException{
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        // Capturar o campo [Nome] e preencher um [Nome]
        page.escreverNome("Wagner");

        //dsl.escrever(MobileBy.AccessibilityId("Nome"), "Wagner");
        //MobileElement campoNome = (MobileElement)driver.findElement(MobileBy.AccessibilityId("Nome"));
        //campoNome.sendKeys("Wagner");
        //String nome = campoNome.getText();

        //Validar o preenchimento do [Nome]
        assertEquals("Wagner", page.obterNome());
        //assertEquals("Wagner", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

    }

    @Test
    public void selecionarCombo() throws MalformedURLException{
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        //Clicar no combo
        page.selecionarCombo("Nintendo Switch");
        //dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        // Verificar opção selecionada

        //dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        assertEquals("Nitendo Switch", page.obterValorCombo());

        //driver.findElement(MobileBy.AccessibilityId("console")).click();
        //driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        //String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException{
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        // Verificar status dos elementos
        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //Clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //Verificar estados alterados
        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

    }
    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        //Preencher Campos
        dsl.escrever(By.className("android.widget.EditText"), "Wagner");
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(By.className("android.widget.Switch"));
        dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

        //Salvar
        dsl.clicarPorTexto("SALVAR");


        //Verificacoes
        Assert.assertEquals("Nome: Wagner", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Formulário']")));
        Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")));
        Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).isEmpty());
        Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).isEmpty());

    }

    @After
    public void fechar() {
        driver.quit();
    }
}
