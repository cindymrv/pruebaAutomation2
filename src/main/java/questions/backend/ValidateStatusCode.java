package questions.backend;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatusCode implements Question<Boolean> {

    private final int statusCode;

    public ValidateStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ValidateStatusCode fromResponseService(Integer statusCode) {
        return new ValidateStatusCode(statusCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getStatusCode() == statusCode;
    }
}
