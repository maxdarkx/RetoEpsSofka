package com.juanmaya.stepdefinition;

import com.juanmaya.task.EnterUser;
import com.juanmaya.task.Navigate;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.ui.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginSuraStepDefinition {


    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Dado("que {actor} es un afiliado de la eps Sura y abre la pagina de login")
    public void queJuanEsUnAfiliadoDeLaEpsSuraYAbreLaPaginaDeLogin(Actor actor) {
        actor.wasAbleTo(
                Navigate.openBasePage(),
                Navigate.toTheLoginPage()
        );
    }

    @Cuando("{actor} inicia sesion en la pagina con su identificacion tipo {string}, numero {string} y password {string}")
    public void juanIniciaSesionEnLaPaginaConSuIdentificacionTipoNumeroYPassword(Actor actor, String tipoIdentificacion, String Identificacion, String password) {
        List<String> passwordList = new ArrayList<>();
        for (int i = 0; i < password.length() ; i++) {
            passwordList.add(String.valueOf(password.charAt(i)));
        }

        actor.attemptsTo(
                EnterUser.selectCedulaIdType(),
                EnterUser.enterId(Identificacion),
                EnterUser.enterPasswordSelector()
        );

        for(String passwordItem: passwordList)
        {
            actor.attemptsTo(
                    EnterUser.enterPasswordItem(passwordItem)
            );
        }


        actor.attemptsTo(
                Click.on(PageElement.withNameOrId("accept").inside(PageElement.withNameOrId("default"))),
                Click.on(Button.withNameOrId("sessionsura"))
        );

    }
    @Entonces("{actor} observa el dashboard de afiliados de Sura")
    public void observaElDashboardDeAfiliadosDeSura(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PageElement.withCSSClass("titulo-nombre"), isVisible()).forNoMoreThan(Duration.ofSeconds(30)),
                Ensure.that(ElementLocated.by(PageElement.withCSSClass("titulo-nombre"))).text().endsWith("Hola, JUAN")
        );
        actor.attemptsTo(
                WaitUntil.the(PageElement.withNameOrId("dropdownPerfilUsuario"), isClickable()).forNoMoreThan(Duration.ofSeconds(30)),
                Switch.toActiveElement(),
                JavaScriptClick.on(PageElement.withNameOrId("dropdownPerfilUsuario")),
                Click.on(PageElement.withCSSClass("fa fa-sign-out").inside(PageElement.withCSSClass("dropdown-item")))
        );
    }
}
