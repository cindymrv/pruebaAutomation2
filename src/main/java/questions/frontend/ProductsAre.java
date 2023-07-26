package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static userinterface.Products.*;

public class ProductsAre implements Question<Boolean> {

    private final Integer quantityOfProducts;

    public ProductsAre(Integer quantityOfProducts) {
        this.quantityOfProducts = quantityOfProducts;
    }

    public static ProductsAre inTheCart(Integer quantityOfProducts) {
        return new ProductsAre(quantityOfProducts);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        BUTTON_CART.resolveFor(actor).click();
        BUTTON_VIEW_CART.resolveFor(actor).click();
        List<WebElement> products = TABLE.resolveFor(actor).findElements(By.tagName("tr"));
        return quantityOfProducts.equals(products.size()-1);
    }
}
