package api;

public class MintConfiguration {

    private static String BASE_URL = "https://challenge.crossmint.io/api/";
    private static String CANDIDATE_ID = "dab76930-0087-40b4-ad43-0fa460f5e80d";

    private static String POLYANETS = "polyanets";
    private static String SOLOONS = "soloons";
    private static String COMETHS = "comeths";
    private static String GOAL_MAP = "map/%s/goal"; //map/{candidateId}/goal

    public static String getBaseUrl() {
        return BASE_URL;
    }
    public static String getCandidateId() {
        return CANDIDATE_ID;
    }
    public static String getPolyanets() {
        return POLYANETS;
    }
    public static String getSoloons() {
        return SOLOONS;
    }
    public static String getComeths() {
        return COMETHS;
    }

    public static String getGoalMap() {
        return GOAL_MAP;
    }
}
