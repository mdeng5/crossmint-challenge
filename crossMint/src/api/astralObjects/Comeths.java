package api.astralObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comeths extends Polyanets {
    @JsonProperty("direction")
    private String direction;

    public Comeths(int row, int column, String direction) {
        super(row, column);
        this.direction = direction;
    }
}
