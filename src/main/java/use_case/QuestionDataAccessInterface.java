package use_case;

import entities.Question;

import java.util.List;

/**
 * Interface defining the contract for data access to quiz questions.
 */
public interface QuestionDataAccessInterface {
    /**
     * Loads data from the data source.
     */
    int loadData();

    /**
     * Gets a random selection of questions.
     *
     * @param count Number of questions to retrieve
     * @return List of random Question objects
     */
    List<Question> getQuestions(int count);
}
