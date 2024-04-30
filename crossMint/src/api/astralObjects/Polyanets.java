package api.astralObjects;

import api.MintConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Polyanets {
    @JsonProperty("candidateId")
    private String candidateId;
    @JsonProperty("row")
    private int row;
    @JsonProperty("column")
    private int column;

    public Polyanets(int row, int column) {
        this.candidateId = MintConfiguration.getCandidateId();
        this.row = row;
        this.column = column;
    }
}
