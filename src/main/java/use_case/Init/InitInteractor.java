package use_case.Init;

import entities.Question;
import entities.QuizSession;
import use_case.QuestionDataAccessInterface;

public class InitInteractor implements  InitInputBoundary {
    private QuestionDataAccessInterface questionDataAccess;
    private InitOutputBoundary initOutputBoundary;
    private InitOutputData initOutputData;
    private Question question;
    private QuizSession quizSession;

    public InitInteractor(QuestionDataAccessInterface questionDataAccess, InitOutputBoundary initPresenter, InitOutputData initOutputData, Question question, QuizSession quizSession) {
        this.questionDataAccess = questionDataAccess;
        this.initOutputBoundary = initPresenter;
        this.initOutputData = initOutputData;
        this.question = question;
        this.quizSession = quizSession;
    }

    // presenter会去更改view model，
    // 然后view model会通知view更新

    @Override
    public void initializeWindow() {

    }
}
