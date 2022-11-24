package estudosAppium.page;

import estudosAppium.teste.DSL;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class FormularioPage {

    private DSL dsl = new DSL();

    public void escreverNome(String nome){
        dsl.escrever(MobileBy.AccessibilityId("Nome"), nome);
    }

    public String obterNome() {
        return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo(){
        return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

}
