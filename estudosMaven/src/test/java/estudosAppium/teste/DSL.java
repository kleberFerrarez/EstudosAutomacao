package estudosAppium.teste;

import org.openqa.selenium.By;

import static estudosAppium.drive.driverFactory.getDriver;

public class DSL {

        public void escrever(By by, String texto){
            getDriver().findElement(by).sendKeys(texto);
        }
        public String obterTexto(By by){
            return getDriver().findElement(by).getText();
        }
        public void clicarPorTexto(String texto){
            clicar(By.xpath("//*[@text='"+texto+"']"));
        }
        public void selecionarCombo(By by, String valor){
            getDriver().findElement(by).click();
            clicarPorTexto(valor);
        }
        public void clicar(By by){
            getDriver().findElement(by).click();
        }
        public boolean isCheckMarcado(By by){
            return getDriver().findElement(by).getAttribute("checked").equals("true");
    }
}
