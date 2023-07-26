package stepdefinitions;

import exceptions.TestError;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.frontend.ProductsAre;
import questions.frontend.TheOrderConfirmationMessage;
import tasks.frontend.AddProducts;
import tasks.frontend.CompleteTheCheckout;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static utils.EnumErrorMessageFront.SHOPPING_CART_ERROR;
import static utils.RecursoFront.URL_OPENCART;

public class BuyProducts {

    @Given("the {string} is located on the opencart website")
    public void openWebPage(String usuario) {
        setTheStage(new OnlineCast());
        theActorCalled(usuario).wasAbleTo(Open.url(URL_OPENCART.getRecursoFront()));
    }

    @When("the user adds products to the cart")
    public void addTwoProductsToTheCart() {
        theActorInTheSpotlight().attemptsTo(AddProducts.toTheCard());
    }

    @Then("the user can view {int} products in the cart")
    public void validateProductsInTheCart(Integer quantityOfProducts) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ProductsAre.inTheCart(quantityOfProducts)));
    }

    @When("you checkout as a guest")
    public void checkoutAsAGuest() {
        theActorInTheSpotlight().attemptsTo(CompleteTheCheckout.asAGuest());
    }

    @Then("the user must be able to view the purchase confirmation.")
    public void confirmation() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheOrderConfirmationMessage.inThePage()).
                orComplainWith(TestError.class, SHOPPING_CART_ERROR.getErrorMessage()));
    }
}
