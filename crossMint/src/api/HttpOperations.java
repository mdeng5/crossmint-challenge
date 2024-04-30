package api;

import api.astralObjects.Comeths;
import api.astralObjects.Polyanets;
import api.astralObjects.Soloons;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class HttpOperations {

    private String baseUrl;
    private String polyanets;
    private String soloons;
    private String comeths;
    private final int retryTime = 8000;

    public HttpOperations(String baseUrl, String polyanets, String soloons, String comeths) {
        this.baseUrl = baseUrl;
        this.polyanets = polyanets;
        this.soloons = soloons;
        this.comeths = comeths;
    }

    public String postPolyanets(int row, int column) {
        try {
            URL url = new URL(baseUrl + polyanets);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Polyanets(row, column)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = postPolyanets(row, column);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public String deletePolyanets(int row, int column) {
        try {
            URL url = new URL(baseUrl + polyanets);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Polyanets(row, column)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = deletePolyanets(row, column);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public String postComeths(int row, int column, String direction) {
        try {
            URL url = new URL(baseUrl + comeths);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Comeths(row, column, direction)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = postComeths(row, column, direction);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public String deleteCometh(int row, int column) {
        try {
            URL url = new URL(baseUrl + comeths);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Comeths(row, column, null)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = deleteCometh(row, column);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public String postSoloons(int row, int column, String color) {
        try {
            URL url = new URL(baseUrl + soloons);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Soloons(row, column, color)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = postSoloons(row, column, color);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public String deleteSoloons(int row, int column) {
        try {
            URL url = new URL(baseUrl + soloons);

            ObjectMapper mapper = new ObjectMapper();
            String jsonParameters = mapper.writeValueAsString(
                    new Soloons(row, column, null)
            );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParameters.getBytes();
                os.write(input, 0, input.length);
            }

            String response = connection.getResponseMessage();
            if (response.equals("Too Many Requests")) { //retry
                System.out.println(response + "... Retrying");
                try {
                    Thread.sleep(retryTime);
                    response = deleteSoloons(row, column);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    return interruptedException.getMessage();
                }
            }
            return response;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return ioException.getMessage();
        }
    }

    public List<List<String>> getGoalMap() {
        try {
            URL url = new URL(MintConfiguration.getBaseUrl() + String.format(MintConfiguration.getGoalMap(), MintConfiguration.getCandidateId()));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            ObjectMapper mapper = new ObjectMapper();
            Map<String, List<List<String>>> mappedStrings = mapper.readValue(response.toString(), Map.class);

            reader.close();

            return mappedStrings.get("goal");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new ArrayList<>();
    }
}
