import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        final String APIKey = "k_8rtu00s8";
        try
        {
            //URL IMDbAPIRating =new URL ("https://imdb-api.com/en/API/UserRatings/"+APIKey+"/tt1375666");
            URL IMDbAPITop250 =new URL  ("https://imdb-api.com/en/API/UserRatings/"+APIKey+"/tt1375666");
            connection = (HttpURLConnection)IMDbAPITop250.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder response = new StringBuilder();
            String line=null;
            while((line=reader.readLine())!=null)
            {
                response.append(line);
                response.append("\r");
            }
            reader.close();
            String result = response.toString();
            System.out.print(result);

            JSONObject object = new JSONObject(result);

            String id = object.getString("IMDbId");
            String title = object.getString("title");
            String userRatings = object.getString("IMDb");


            System.out.println("Movie title "+title);
            System.out.println("Movie Ratings "+userRatings);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}