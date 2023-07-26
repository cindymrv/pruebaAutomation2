package tasks.backend;

import models.builders.RequestCreateUserBuilder;
import models.response.ResponseCreateUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateUser implements Task {

    private final Map<String, String> mapFeaturesUser;

    public CreateUser(Map<String, String> mapFeaturesUser) {
        this.mapFeaturesUser = mapFeaturesUser;
    }

    public static CreateUser withFeatures(Map<String, String> mapFeaturesUser) {
        return instrumented(CreateUser.class, mapFeaturesUser);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/user").with(requestSpecification ->
                requestSpecification
                        .body(RequestCreateUserBuilder.withFeatures(mapFeaturesUser)).contentType("application/json")));

        actor.should(seeThatResponse(response -> response.log().all()));
        SerenityRest.lastResponse().as(ResponseCreateUser.class);
    }
}
