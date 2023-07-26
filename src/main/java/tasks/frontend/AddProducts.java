package tasks.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.Products.*;

public class AddProducts implements Task {

    public static AddProducts toTheCard() {
        return instrumented(AddProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> products = PRODUCTS.resolveFor(actor).findElements(By.xpath("//button[contains(@onclick, 'cart.add')]"));
        WebElement product1 = products.get(0);
        WebElement product2 = products.get(3);
        product1.click();
        product2.click();
        LIST_OF_COLORS.resolveFor(actor).click();
        actor.attemptsTo(Enter.theValue("1").into(QUANTITY));
        BUTTON_CART_CAMARA.resolveFor(actor).click();
    }
}
