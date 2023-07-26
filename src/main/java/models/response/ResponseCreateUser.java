package models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonPropertyOrder({
        "code",
        "type",
        "message"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateUser implements Serializable {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    private final static long serialVersionUID = 2919111761921755258L;
}
