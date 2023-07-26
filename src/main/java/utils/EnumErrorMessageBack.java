package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumErrorMessageBack {
    ERROR_MESSAGE_STATUS_CODE("Status code is not as expected");

    private final String errorMessage;
}
