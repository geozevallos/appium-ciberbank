package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import java.util.Locale;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarTransferencia implements Task {

    private final double importe;
    private final String destinatario;

    private RealizarTransferencia(double importe, String destinatario) {
        this.importe = importe;
        this.destinatario = destinatario;
    }

    public static RealizarTransferencia por(double importe, String destinatario) {
        return new RealizarTransferencia(importe, destinatario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String importeFormateado = String.format(Locale.US, "%.2f", importe);

        actor.attemptsTo(
            Click.on(TransferenciaScreen.BOTON_TRANSFERENCIAS),
            WaitUntil.the(TransferenciaScreen.SPINNER_BENEFICIARIO, isVisible())
                .forNoMoreThan(30).seconds(),
                Click.on(TransferenciaScreen.SPINNER_BENEFICIARIO),
                WaitUntil.the(TransferenciaScreen.opcionDelBeneficiario(destinatario), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.opcionDelBeneficiario(destinatario)),
                Clear.field(TransferenciaScreen.CAMPO_MONTO),
                Enter.theValue(importeFormateado).into(TransferenciaScreen.CAMPO_MONTO),
                OcultarTeclado.siEstaAbierto(),
                WaitUntil.the(TransferenciaScreen.BOTON_CONTINUAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.BOTON_CONTINUAR)
        );
    }
}