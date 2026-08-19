package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirTransferencias implements Task {

    public static AbrirTransferencias desdeElDashboard() {
        return new AbrirTransferencias();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TransferenciaScreen.BOTON_TRANSFERENCIAS),
                WaitUntil.the(TransferenciaScreen.SPINNER_BENEFICIARIO, isVisible())
                        .forNoMoreThan(30).seconds()
        );
    }
}