package tasks.backend;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultUser implements Task {

    private final String userName;

    public ConsultUser(String userName) {
        this.userName = userName;
    }
    public static ConsultUser byUserName(String userName) {
        return instrumented(ConsultUser.class, userName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.rest().log().all().get(CallAnApi.as(actor).resolve(userName));
        actor.should(seeThatResponse(response -> response.log().all()));
    }
}
