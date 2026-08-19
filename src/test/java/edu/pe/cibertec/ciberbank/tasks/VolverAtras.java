package edu.pe.cibertec.ciberbank.tasks;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public class VolverAtras implements Task {

    private static final String PAQUETE_APP = "edu.pe.cibertec.ciberbank";

    public static VolverAtras delSistema() {
        return new VolverAtras();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver navegador = BrowseTheWeb.as(actor).getDriver();
        if (navegador instanceof WebDriverFacade) {
            navegador = ((WebDriverFacade) navegador).getProxiedDriver();
        }
        navegador.navigate().back();
        if (navegador instanceof AndroidDriver) {
            ((AndroidDriver) navegador).activateApp(PAQUETE_APP);
        }
    }
}