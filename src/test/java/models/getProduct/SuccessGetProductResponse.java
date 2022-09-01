
package models.getProduct;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.ProductEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessGetProductResponse {
    @Getter
    @JsonProperty("value")
    private ProductEntity product;
}
