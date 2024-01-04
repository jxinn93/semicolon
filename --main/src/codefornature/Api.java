/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList ;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

public class Api {
    private final String NEWS_API_URL = "https://newsapi.org/v2/everything";
    private final String API_KEY = "4f88a5505a9b496c9937a27aad3138df";
    private final String API_URL = NEWS_API_URL + "?q=nature&apiKey=" + API_KEY;

    public ApiResponse fetchNews() throws IOException {
        HttpURLConnection connection = null;
        String response = null;
        try {
            URL url = new URL(API_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            int responseCode = connection.getResponseCode();
            
            
            if(responseCode == HttpURLConnection.HTTP_OK){
            InputStreamReader reader1 = new InputStreamReader(connection.getInputStream());
            BufferedReader reader2 = new BufferedReader(reader1);
            
           StringBuilder responseBuilder = new StringBuilder();
           String line;
           while ((line = reader2.readLine()) != null) {
                    responseBuilder.append(line);
                }
                response = responseBuilder.toString();
           
            } else {
               InputStreamReader errorReader = new InputStreamReader(connection.getErrorStream());
                BufferedReader errorBufferedReader = new BufferedReader(errorReader);

                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = errorBufferedReader.readLine()) != null) {
                    errorResponse.append(line); 
            }
                response = errorResponse.toString();
        }
            return new ApiResponse (responseCode , response);
    } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }      

    public List<NewsFilter.NewsArticle> getNewsNature() throws IOException {
    List<NewsFilter.NewsArticle> newsList = new ArrayList<>();
    ApiResponse apiResponse  = fetchNews();
    
    
        
    try{
    String jsonResponse = apiResponse.getResponse();
    if (jsonResponse != null && !jsonResponse.isEmpty()) {
    JSONArray articlesArray = new JSONObject(apiResponse.getResponse()).getJSONArray("articles");

    for (int i = 0; i < Math.min(articlesArray.length(), 5); i++) {
        JSONObject article = articlesArray.getJSONObject(i);
        String title = article.getString("title");
        String url = article.getString("url");
        String publishedAt = article.getString("publishedAt");

        if (title.toLowerCase().contains("Nature".toLowerCase())) {
           newsList.add(new NewsFilter.NewsArticle(title, url, parseDate(publishedAt)));
                
        }
    }
    return newsList;
 } else {
        System.err.println("JSON response is null or empty.");
    }
} catch (JSONException e) {
    e.printStackTrace();
}
    return Collections.emptyList();
    }
    


private Date parseDate(String dateString) {
    try {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(dateString);
    } catch (ParseException e) {
        System.err.println("Error parsing date: " + dateString);
        e.printStackTrace();
        return null;
    }
}
}

    class ApiResponse {
    private int responseCode;
    private String response;

    public ApiResponse(int responseCode, String response) {
        this.responseCode = responseCode;
        this.response = response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponse() {
        return response;
    }
}
