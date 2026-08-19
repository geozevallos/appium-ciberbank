package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import edu.pe.cibertec.ciberbank.userinterface.PerfilScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesion implements Task {

    public static CerrarSesion desdeElPerfil() {
        return new CerrarSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_MENU),
                WaitUntil.the(DashboardScreen.OPCION_PERFIL, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardScreen.OPCION_PERFIL),
                WaitUntil.the(PerfilScreen.CERRAR_SESION, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PerfilScreen.CERRAR_SESION),
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}