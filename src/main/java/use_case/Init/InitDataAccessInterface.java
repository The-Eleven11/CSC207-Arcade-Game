package use_case.Init;

import entities.Question;

import java.util.List;

public interface InitDataAccessInterface {
    List<Question> getQuestions(String type);
}
