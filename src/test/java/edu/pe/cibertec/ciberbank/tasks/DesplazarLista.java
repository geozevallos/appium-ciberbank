package edu.pe.cibertec.ciberbank.tasks;

import io.appium.java_client.android.AndroidDriver;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class DesplazarLista implements Task {

    public static DesplazarLista hastaElFinal() {
        return new DesplazarLista();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver navegador = BrowseTheWeb.as(actor).getDriver();
        if (navegador instanceof WebDriverFacade) {
            navegador = ((WebDriverFacade) navegador).getProxiedDriver();
        }

        AndroidDriver android = (AndroidDriver) navegador;
        String contadorEsperado = "Mostrando 30 de 32 movimientos";
        Rectangle areaLista = android.findElement(By.id(
            "edu.pe.cibertec.ciberbank:id/lst_movimientos")).getRect();

        int x = areaLista.getX() + areaLista.getWidth() / 2;
        int inicio = areaLista.getY() + (areaLista.getHeight() * 3 / 4);
        int fin = areaLista.getY() + (areaLista.getHeight() / 2);
        PointerInput dedo = new PointerInput(PointerInput.Kind.TOUCH, "dedo");
        Sequence desplazamiento = new Sequence(dedo, 0)
            .addAction(dedo.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), x, inicio))
            .addAction(dedo.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(dedo.createPointerMove(Duration.ofMillis(600),
                PointerInput.Origin.viewport(), x, fin))
            .addAction(dedo.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        android.perform(List.of(desplazamiento));

        actor.attemptsTo(
            WaitUntil.the(MovimientosScreen.RESUMEN, containsText(contadorEsperado))
                .forNoMoreThan(10).seconds()
        );
    }
}
