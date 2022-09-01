
package models.getProducts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.ProductEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessGetProductsResponse {
    @Getter
    @JsonProperty("values")
    private List<ProductEntity> products;
}
