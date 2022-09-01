package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Actions;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessActionWithProductResponse {
    @Getter
    @JsonProperty()
    private Actions action;
    @Getter
    @JsonProperty("value")
    private ProductEntity product;
}
