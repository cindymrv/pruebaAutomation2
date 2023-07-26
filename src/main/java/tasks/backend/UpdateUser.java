package tasks.backend;

import models.builders.RequestCreateUserBuilder;
import models.response.ResponseCreateUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateUser implements Task {

    private final Map<String, String> map;
    public static UpdateUser withFeatures(Map<String, String> map) {
        return instrumented(UpdateUser.class, map);
    }

    public UpdateUser(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/user/cindytest").with(requestSpecification ->
                requestSpecification
                        .body(RequestCreateUserBuilder.withFeatures(map)).contentType("application/json")));
        actor.should(
                seeThatResponse(response -> response.log().all()));
        SerenityRest.lastResponse().as(ResponseCreateUser.class);

    }
}
