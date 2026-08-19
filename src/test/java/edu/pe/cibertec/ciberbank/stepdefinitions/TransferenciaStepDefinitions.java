package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.AceptarDialogoDeTransferencia;
import edu.pe.cibertec.ciberbank.tasks.EsperarLaPantallaDeLogin;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.RealizarTransferencia;
import edu.pe.cibertec.ciberbank.userinterface.ConstanciaScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;

public class TransferenciaStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before("@transferencia")
    public void preparaEscenarioDeTransferencia() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After("@transferencia")
    public void cierraEscenarioDeTransferencia() {
        OnStage.drawTheCurtain();
    }

    @Dado("que {word} inició sesión con el usuario {string}")
    public void inicioSesion(String actor, String usuario) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Cuando("transfiere {string} al beneficiario {string}")
    public void transfiere(String importeTexto, String destinatario) {
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferencia.por(Double.parseDouble(importeTexto), destinatario)
        );
    }

    @Cuando("intenta transferir {string} al beneficiario {string}")
    public void intentaTransferir(String importeTexto, String destinatario) {
        transfiere(importeTexto, destinatario);
    }

    @Y("acepta el diálogo de confirmación")
    public void aceptaDialogoDeConfirmacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarDialogoDeTransferencia.confirmacion()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void veNumeroDeOperacionGenerado() {
        theActorInTheSpotlight().should(
                seeThat("el número de operación", TextoDe.el(ConstanciaScreen.OPERACION_GENERADA),
                        not(emptyOrNullString()))
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void saldoQuedaEn(String saldo) {
        theActorInTheSpotlight().should(
                seeThat("el saldo actualizado", TextoDe.el(ConstanciaScreen.SALDO_RESULTANTE), is(saldo))
        );
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void veMensajeDeError(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de error de transferencia", TextoDe.el(TransferenciaScreen.MENSAJE_ERROR), is(mensaje))
        );
    }
}