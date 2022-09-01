package endpoints;

import lombok.Getter;

public enum CategoryEndpoints {
    ADD_CATEGORY("/category"),
    CATEGORY("/category/%s");

    @Getter
    private final String endpoint;

    CategoryEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
