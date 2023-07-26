package models.builders;


import models.request.RequestCreateUser;

import java.util.Map;

public class RequestCreateUserBuilder {

    public static RequestCreateUser withFeatures(Map<String, String> mapFeaturesUser) {
        return RequestCreateUser.builder().id(Integer.valueOf(mapFeaturesUser.get("Id"))).username(mapFeaturesUser.get("User name"))
                .firstName(mapFeaturesUser.get("First name")).lastName(mapFeaturesUser.get("Last name")).email(mapFeaturesUser.get("email"))
                .password(mapFeaturesUser.get("password")).phone(mapFeaturesUser.get("phone")).userStatus(Integer.valueOf(mapFeaturesUser.get("status"))).build();

    }
}
