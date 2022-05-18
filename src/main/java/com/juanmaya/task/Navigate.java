package com.juanmaya.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
//import net.serenitybdd.screenplay.actions.j
//import net.serenitybdd.screenplay.ui.;

import static com.juanmaya.util.Dictionary.BaseUrl;

public class Navigate {
    public static Performable openBasePage()
    {
        return Task.where( "{0} abre el navegador e ingresa a la pagina de Sura",
                Open.url(BaseUrl)
        );
    }

    public static Performable toTheLoginPage()
    {
        return Task.where( "{0} navega hacia la pagina de login",
                Click.on(Button.withNameOrId("iniciar-sesion-cont")),
                Click.on(PageElement.containingText("Afiliados").inside(PageElement.withCSSClass("iniciar-sesion-option"))),
                Switch.toTheOtherWindow()
        );
    }
}
