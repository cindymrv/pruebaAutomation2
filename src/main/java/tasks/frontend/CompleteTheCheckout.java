package tasks.frontend;

import interactions.front.FillOutForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.Checkout.*;

public class CompleteTheCheckout implements Task {
    public static CompleteTheCheckout asAGuest() {
        return instrumented(CompleteTheCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BUTTON_CHECKOUT.resolveFor(actor).click();
        BUTTON_GUEST.resolveFor(actor).click();
        BUTTON_CONTINUE.resolveFor(actor).click();
        actor.attemptsTo(FillOutForm.withInformation());
    }
}
