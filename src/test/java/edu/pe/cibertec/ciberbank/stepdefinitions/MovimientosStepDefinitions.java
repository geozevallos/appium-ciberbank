package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.AbrirMovimientos;
import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosStepDefinitions {

    @Cuando("abre la pantalla de movimientos")
    public void abrePantallaDeMovimientos() {
        theActorInTheSpotlight().attemptsTo(AbrirMovimientos.desdeElDashboard());
    }

    @Entonces("debería ver el contador {string}")
    public void verificaContadorDeMovimientos(String textoEsperado) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoDe.el(MovimientosScreen.RESUMEN)).isEqualTo(textoEsperado)
        );
    }

    @Cuando("desplaza la lista hasta el final")
    public void desplazaListaHastaElFinal() {
        theActorInTheSpotlight().attemptsTo(DesplazarLista.hastaElFinal());
    }
}
