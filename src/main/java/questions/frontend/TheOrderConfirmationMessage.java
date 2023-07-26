package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterface.Checkout.CONFIRMATION_MESSAGE;

public class TheOrderConfirmationMessage implements Question<Boolean> {


    public static Question<Boolean> inThePage() {
        return new TheOrderConfirmationMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CONFIRMATION_MESSAGE.resolveFor(actor).getText().equals("Your order has been placed!");
    }
}
