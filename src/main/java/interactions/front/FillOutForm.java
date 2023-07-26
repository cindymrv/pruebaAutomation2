package interactions.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.Checkout.*;

public class FillOutForm implements Interaction {

    public static FillOutForm withInformation() {
        return instrumented(FillOutForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
     actor.attemptsTo(Enter.theValue("Prueba").into(NAME));
     actor.attemptsTo(Enter.theValue("Apellido").into(LAST_NAME));
     actor.attemptsTo(Enter.theValue("pruebacheckout1@yopmail.com").into(EMAIL));
     actor.attemptsTo(Enter.theValue("301001111").into(PHONE));
     actor.attemptsTo(Enter.theValue("calle 45").into(ADDRESS));
     actor.attemptsTo(Enter.theValue("Medellin").into(CITY));
     actor.attemptsTo(Enter.theValue("050029").into(POST_CODE));
     actor.attemptsTo(SelectFromOptions.byValue("47").from(SELECT_COUNTRY));
     actor.attemptsTo(SelectFromOptions.byValue("721").from(SELECT_STATE));
     actor.attemptsTo(Click.on(BUTTON_CONTINUE_GUEST));
     actor.attemptsTo(Enter.theValue("Prueba").into(TEXT_COMMENRS));
     actor.attemptsTo(Click.on(BUTTON_SHIPPING));
     actor.attemptsTo(Click.on(CHECK_AGREE));
     actor.attemptsTo(Click.on(BUTTON_PAYMENT));
     actor.attemptsTo(Click.on(BUTTON_CONFIRM_ORDER));
    }
}
