package api.astralObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Soloons extends Polyanets {
    @JsonProperty("color")
    private String color;

    public Soloons(int row, int column, String color) {
        super(row, column);
        this.color = color;
    }
}