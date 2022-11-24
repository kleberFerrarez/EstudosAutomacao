package estudosAppium.page;

import estudosAppium.teste.DSL;

public class MenuPage {
    private DSL dsl = new DSL();


    public void acessarFormulario(){
        dsl.clicarPorTexto("Formulário");

    }
}
