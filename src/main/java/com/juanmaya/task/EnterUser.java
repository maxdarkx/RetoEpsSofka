package com.juanmaya.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Dropdown;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterUser {

    public static Performable selectCedulaIdType()
    {

        Target selector = Target.the("ctl00$ContentMain$suraType").located(By.id("ctl00_ContentMain_suraType")).inside(PageElement.withCSSClass("select"));
        return Task.where( "{0} selecciona el tipo de documento Cedula",
                WaitUntil.the(selector, isVisible()).forNoMoreThan(Duration.ofSeconds(30)),
                Click.on(PageElement.withNameOrId("ctl00_ContentMain_suraType").inside(PageElement.withCSSClass("select"))),
                SelectFromOptions.byVisibleText("CEDULA").from(Dropdown.withNameOrId("ctl00_ContentMain_suraType"))
        );
    }


    public static Performable enterId(String id)
    {
        return Task.where("{0} ingresa su identificacion en la pagina",
                Enter.theValue(id).into(InputField.withNameOrId("suraName"))
        );
    }
    public static Performable enterPasswordSelector()
    {
        return Task.where(
                Click.on(InputField.withNameOrId("suraPassword"))
        );
    }

    public static Performable enterPasswordItem(String passwordItem)
    {
        int baseName = 48;
        String name = String.valueOf(Integer.valueOf(passwordItem) + baseName);
        String className = "ui-keyboard-"+name;
        SearchableTarget element = Button.withNameOrId(name).inside(PageElement.withNameOrId("default"));
        Target buttonUI = Target.the("Boton "+name).located(By.name(name)).inside(PageElement.withNameOrId("default"));

        return Task.where("{0} presiona el boton "+passwordItem+" con name = "+name,
               Click.on(element)
               //Click.on(Button.withCSSClass(className))
        );
    }
}
