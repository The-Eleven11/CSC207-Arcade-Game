package data_access;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import entities.Question;

public class QuestionDataAccessObject {

    private final Gson gson = new Gson();
    private final Type questionListType = new TypeToken<List<Question>>() {}.getType();

    public List<Question> loadQuestions(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        return gson.fromJson(new InputStreamReader(is), questionListType);
    }
}
