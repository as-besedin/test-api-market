package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductEntity {
    @Getter
    @JsonProperty()
    private String id;
    @Getter
    @JsonProperty()
    private String productName;
    @JsonProperty()
    private List<CategoryEntity> categories;
    @Getter
    @JsonProperty()
    private double amount;
    @Getter
    @JsonProperty()
    private double discount;
    @Getter
    @JsonProperty()
    private double percentDiscount;
    @Getter
    @JsonProperty()
    private boolean isVisible;
    @JsonProperty()
    private String created;
    @JsonProperty()
    private String modified;
    @Getter
    @JsonProperty()
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id.equals(that.id) &&
                productName.equals(that.productName);
    }

    public ProductEntity(String name, Double amount, Double discount, Double percentDiscount, boolean isVisible) {
        this.name = name;
        this.amount = amount;
        this.discount = discount;
        this.percentDiscount = percentDiscount;
        this.isVisible = isVisible;
    }

    public ProductEntity() {}
}
