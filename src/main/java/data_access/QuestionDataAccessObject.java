package data_access;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

import entities.Question;

public class QuestionDataAccessObject {

    public loadFile()
    String filePath = "path/to/your/file.json";
    StringBuilder jsonContent = new StringBuilder();
    try {
        JSONArray jsonArray = new JSONArray(jsonContent.toString());
        System.out.println("Converted JSONArray: " + jsonArray.toString(2)); // Pretty print
    } catch (Exception e) {
        // If the JSON file contains a single object (e.g., "{}") and you want to wrap it in an array
        try {
            JSONObject jsonObject = new JSONObject(jsonContent.toString());
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            System.out.println("Wrapped JSONObject in JSONArray: " + jsonArray.toString(2));
        } catch (Exception ex) {
            System.err.println("Error parsing JSON: " + ex.getMessage());
        }
    }
}
}
