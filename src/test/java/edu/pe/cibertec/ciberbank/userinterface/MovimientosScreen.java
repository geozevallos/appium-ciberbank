package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MovimientosScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private MovimientosScreen() {
    }

    public static final Target LISTA =
            Target.the("lista de movimientos").located(By.id(PAQUETE + "lst_movimientos"));

    public static final Target RESUMEN =
            Target.the("resumen de movimientos").located(By.id(PAQUETE + "lbl_total_movimientos"));
}
