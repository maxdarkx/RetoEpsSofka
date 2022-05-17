package com.juanmaya.stepdefinition;

import com.juanmaya.task.Navigate;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

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

    }
    @Entonces("{actor} observa el dashboard de afiliados de Sura")
    public void observaElDashboardDeAfiliadosDeSura(Actor actor) {

    }
}
