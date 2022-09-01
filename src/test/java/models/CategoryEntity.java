
package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryEntity {
    @Getter
    @JsonProperty()
    private String id;
    @Getter
    @JsonProperty()
    private String name;
    @Getter
    @JsonProperty()
    private String brand;
    @Getter
    @JsonProperty()
    private Boolean isVisible;
    @JsonProperty()
    private String created;
    @JsonProperty()
    private String modified;

    public CategoryEntity(String name, String brand, boolean isVisible) {
        this.name = name;
        this.brand = brand;
        this.isVisible = isVisible;
    }

    public CategoryEntity() {}
}
