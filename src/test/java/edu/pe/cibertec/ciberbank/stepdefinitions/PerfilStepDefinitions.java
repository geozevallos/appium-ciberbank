package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.CerrarSesion;
import edu.pe.cibertec.ciberbank.tasks.VolverAtras;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PerfilStepDefinitions {

    @Cuando("abre su perfil y pulsa cerrar sesión")
    public void abrePerfilYCierraSesion() {
        theActorInTheSpotlight().attemptsTo(CerrarSesion.desdeElPerfil());
    }

    @Entonces("debería estar de vuelta en la pantalla de login")
    public void validaRegresoAlLogin() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible()).forNoMoreThan(15).seconds(),
                Ensure.that(LoginScreen.CAMPO_USUARIO).isDisplayed(),
                Ensure.that(LoginScreen.CAMPO_CLAVE).isDisplayed()
        );
    }

    @Y("presiona el botón atrás del sistema")
    public void presionaBotonAtras() {
        theActorInTheSpotlight().attemptsTo(VolverAtras.delSistema());
    }

    @Entonces("debería seguir en la pantalla de login")
    public void validaPermaneceEnLogin() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible()).forNoMoreThan(15).seconds(),
            Ensure.that(LoginScreen.CAMPO_USUARIO).isDisplayed(),
            Ensure.that(LoginScreen.CAMPO_CLAVE).isDisplayed()
        );
    }
}
