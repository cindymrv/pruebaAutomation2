package stepdefinitions;

import exceptions.TestError;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import questions.backend.ValidateStatusCode;
import tasks.backend.ConsultUser;
import tasks.backend.CreateUser;
import tasks.backend.UpdateUser;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.EnumErrorMessageBack.ERROR_MESSAGE_STATUS_CODE;

public class Petstore {

    @Given("{string} performs the consumption of the base url {string}")
    public void configureStartAutomation(String user, String baseUrl) {
        setTheStage(new OnlineCast());
        theActorCalled(user).whoCan(CallAnApi.at(baseUrl));
    }

    @When("a user is created with the following characteristics")
    public void createdAUser(Map<String, String> mapFeaturesUser) {
        theActorInTheSpotlight()
                .attemptsTo(CreateUser.withFeatures(mapFeaturesUser));
    }

    @Then("the service should answer me with a status code {int}")
    public void validateStatusCode(Integer statusCode) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidateStatusCode.fromResponseService(statusCode),
                Matchers.equalTo(Boolean.TRUE)).orComplainWith(TestError.class, ERROR_MESSAGE_STATUS_CODE.getErrorMessage()));
    }
    @Then("when querying the username {string} of the previously created user")
    public void validateUserCreated(String userName) {
        theActorInTheSpotlight()
                .attemptsTo(ConsultUser.byUserName(userName));
    }

    @When("you update the user's name and email with the following characteristics")
    public void updateUser(Map<String, String> map) {
        theActorInTheSpotlight()
                .attemptsTo(UpdateUser.withFeatures(map));
    }

}
