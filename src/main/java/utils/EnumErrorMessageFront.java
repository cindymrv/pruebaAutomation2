package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumErrorMessageFront {
    SHOPPING_CART_ERROR("Both products cannot be found in the cart"),
    ORDER_ERROR_MESSAGE("The order was not placed");

    private final String errorMessage;
}
