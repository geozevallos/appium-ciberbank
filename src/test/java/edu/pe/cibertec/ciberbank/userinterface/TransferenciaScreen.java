package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferenciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private TransferenciaScreen() {
    }

    public static final Target BOTON_TRANSFERENCIAS =
            Target.the("acceso a transferencias").located(By.id(PAQUETE + "btn_transferir"));

    public static final Target SPINNER_BENEFICIARIO =
            Target.the("desplegable de beneficiarios").located(By.id(PAQUETE + "spn_beneficiario"));

    public static final Target CAMPO_MONTO =
            Target.the("monto de transferencia").located(By.id(PAQUETE + "inp_monto"));

    public static final Target BOTON_CONTINUAR =
            Target.the("boton continuar").located(By.id(PAQUETE + "btn_continuar"));

    public static final Target NUMERO_OPERACION =
            Target.the("numero de operacion").located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target MENSAJE_ERROR =
            Target.the("mensaje de error de transferencia")
                    .located(By.id(PAQUETE + "err_transferencia"));

    public static Target opcionDelBeneficiario(String beneficiario) {
        return Target.the("beneficiario: " + beneficiario)
                 .located(By.xpath("//*[contains(@text,'" + beneficiario + "')]"));
    }
}