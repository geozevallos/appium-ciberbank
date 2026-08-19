package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PerfilScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private PerfilScreen() {
    }

    public static final Target CERRAR_SESION =
            Target.the("boton cerrar sesion").located(By.id(PAQUETE + "btn_cerrar_sesion"));
}