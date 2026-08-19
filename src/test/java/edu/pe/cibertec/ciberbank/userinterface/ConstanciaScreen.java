package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConstanciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private ConstanciaScreen() {
    }

    public static final Target OPERACION_GENERADA =
            Target.the("numero de operacion").located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target SALDO_RESULTANTE =
            Target.the("saldo actualizado").located(By.id(PAQUETE + "lbl_saldo_actualizado"));
}
