package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorStructureResponse {
    @JsonProperty
    private String timestamp;
    @Getter
    @JsonProperty
    private int status;
    @Getter
    @JsonProperty
    private String error;
    @JsonProperty
    private String path;
}
