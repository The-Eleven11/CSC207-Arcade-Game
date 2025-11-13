package interface_adapters.crossword;

import use_case.crossword.start.StartCrosswordInputBoundary;

public class CrosswordController {

    private final StartCrosswordInputBoundary startUseCase;

    public CrosswordController(StartCrosswordInputBoundary startUseCase) {
        this.startUseCase = startUseCase;
    }

    public void startCrossword() {
        startUseCase.startCrossword();
    }
}