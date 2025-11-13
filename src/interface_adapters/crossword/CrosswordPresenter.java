package interface_adapters.crossword;

import use_case.crossword.start.StartCrosswordOutputBoundary;

public class CrosswordPresenter implements StartCrosswordOutputBoundary {

    private final CrosswordViewModel viewModel;

    public CrosswordPresenter(CrosswordViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @Override
    public void presentCrossword(String puzzleId, String imagePath, int numSolutions) {
        viewModel.setPuzzleId(puzzleId);
        viewModel.setImagePath(imagePath);
        viewModel.setNumSolutions(numSolutions);
        viewModel.setStatusMessage("Crossword loaded.");
    }
}