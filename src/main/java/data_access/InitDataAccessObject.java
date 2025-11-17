package data_access;

import entities.Question;
import use_case.Init.InitDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import data_access.QuestionDataAccessObject;

public class InitDataAccessObject implements InitDataAccessInterface {
    private String fileName = "resources/data/questions.json";

    @Override
    public List<Question> getQuestions(String type) {
        List<Question> allQuestions = new QuestionDataAccessObject().loadQuestions("questions.json");
        List<Question> selectedQuestions = new ArrayList<>();
        for (Question question : allQuestions) {
            if (question.getType().equals(type.toUpperCase())) {
                selectedQuestions.add(question);

            }
        }
        return selectedQuestions;
    }
}
