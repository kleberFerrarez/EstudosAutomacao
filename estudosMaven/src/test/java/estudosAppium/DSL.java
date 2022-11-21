package estudosAppium;

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
        getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();

        }

        public void selecionarCombo(By by, String valor){
            getDriver().findElement(by).click();
            clicarPorTexto(valor);
        }

        public void clicar(By by){
            getDriver().findElement(by).click();
        }
}
