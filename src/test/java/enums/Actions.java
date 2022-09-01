package enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Actions {
    ADD, REMOVE, EDIT;

    @JsonValue()
    public String getValue() {
        return this.name();
    }
}
