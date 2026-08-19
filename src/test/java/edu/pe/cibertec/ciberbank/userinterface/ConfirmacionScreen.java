package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionScreen {

    private ConfirmacionScreen() {
    }

    public static final Target CONFIRMAR =
            Target.the("boton confirmar transferencia")
                    .located(By.id("edu.pe.cibertec.ciberbank:id/btn_confirmar"));

    public static final Target ACEPTAR =
            Target.the("boton aceptar del dialogo de confirmacion")
                    .located(By.id("android:id/button1"));

    public static final Target CANCELAR =
            Target.the("boton cancelar del dialogo de confirmacion")
                    .located(By.id("android:id/button2"));
}