package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Products {
    public static final Target PRODUCTS = Target.the("List of products").located(By.xpath("//*[@id='content']/div[2]"));
    public static final Target BUTTON_CART = Target.the("Cart button").located(By.cssSelector(".btn-inverse"));
    public static final Target LIST_OF_COLORS = Target.the("list of colors").located(By.xpath("//*[@id='input-option226']/option[2]"));
    public static final Target QUANTITY = Target.the("Quantity").located(By.id("input-quantity"));
    public static final Target BUTTON_CART_CAMARA= Target.the("Buy camara").located(By.id("button-cart"));
    public static final Target BUTTON_VIEW_CART= Target.the("Button view cart").located(By.xpath("//strong[contains(.,'View Cart')]"));
    public static final Target TABLE= Target.the("Table with products").located(By.xpath("//*[@id='content']/form/div/table"));

}
