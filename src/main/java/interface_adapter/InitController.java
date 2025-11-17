package interface_adapter;

import use_case.Init.InitInputBoundary;

public class InitController {
    private InitInputBoundary initUseCaseInteractor;

    public InitController(InitInputBoundary initUseCaseInteractor) {
        this.initUseCaseInteractor = initUseCaseInteractor;
    }

    public void initializeWindow() {
        initUseCaseInteractor.initializeWindow();
    }
}
