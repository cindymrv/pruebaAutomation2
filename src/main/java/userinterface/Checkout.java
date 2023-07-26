package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Checkout {
    public static final Target BUTTON_CHECKOUT= Target.the("Button for checkout").located(By.xpath("//a[.='Checkout']"));
    public static final Target BUTTON_GUEST= Target.the("Radio Button to select guest").located(By.xpath("//*[contains(@value,'guest')]"));
    public static final Target BUTTON_CONTINUE= Target.the("Button continue").located(By.id("button-account"));
    public static final Target NAME= Target.the("Name").located(By.id("input-payment-firstname"));
    public static final Target LAST_NAME= Target.the("Last Name").located(By.id("input-payment-lastname"));
    public static final Target EMAIL= Target.the("Email").located(By.id("input-payment-email"));
    public static final Target PHONE= Target.the("Phone").located(By.id("input-payment-telephone"));
    public static final Target ADDRESS= Target.the("Address 1").located(By.id("input-payment-address-1"));
    public static final Target CITY= Target.the("City").located(By.id("input-payment-city"));
    public static final Target POST_CODE= Target.the("Post Code").located(By.id("input-payment-postcode"));
    public static final Target SELECT_COUNTRY= Target.the("Country").located(By.id("input-payment-country"));
    public static final Target SELECT_STATE= Target.the("State").located(By.id("input-payment-zone"));
    public static final Target BUTTON_CONTINUE_GUEST= Target.the("Button continue").located(By.id("button-guest"));

    public static final Target TEXT_COMMENRS= Target.the("comment").located(By.name("comment"));
    public static final Target CHECK_AGREE= Target.the("agree").located(By.name("agree"));
    public static final Target BUTTON_CONFIRM_ORDER= Target.the("Button confirm order").located(By.id("button-confirm"));
    public static final Target BUTTON_PAYMENT= Target.the("Button payment").located(By.id("button-payment-method"));
    public static final Target BUTTON_SHIPPING= Target.the("Button shipping").located(By.id("button-shipping-method"));
    public static final Target CONFIRMATION_MESSAGE= Target.the("Confirmation").located(By.xpath("//h1[.='Your order has been placed!']"));

}
