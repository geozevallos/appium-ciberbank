package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Locators del dashboard. */
public class DashboardScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private DashboardScreen() {
    }

    public static final Target SALUDO =
            Target.the("saludo de bienvenida").located(By.id(PAQUETE + "lbl_bienvenida"));

    public static final Target SALDO_PRINCIPAL =
            Target.the("saldo de la cuenta principal").located(By.id(PAQUETE + "lbl_saldo_principal"));

    public static final Target CUENTA_PRINCIPAL =
            Target.the("cuenta principal").located(By.id(PAQUETE + "lbl_cuenta_principal"));

    public static final Target BOTON_MENU =
            Target.the("botón del menú lateral").located(By.id(PAQUETE + "btn_menu"));

    public static final Target BOTON_MOVIMIENTOS =
            Target.the("boton de movimientos").located(By.id(PAQUETE + "btn_movimientos"));

    public static final Target OPCION_PERFIL =
            Target.the("opcion de perfil").located(By.id(PAQUETE + "btn_nav_perfil"));
}
