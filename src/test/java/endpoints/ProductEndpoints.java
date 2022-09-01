package endpoints;

import lombok.Getter;

public enum ProductEndpoints {
    PRODUCTS("/products"),
    PRODUCT("/product/%s");

    @Getter
    private final String endpoint;

    ProductEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
