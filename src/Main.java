import interface_adapters.crossword.*;
import interface_adapters.crossword.data_access.LocalCrosswordPuzzleDataAccess;
import use_case.crossword.*;
import use_case.crossword.start.*;
import view.crossword.CrosswordView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // ---- BUILD CLEAN ARCHITECTURE LAYERS ----

        // ViewModel
        CrosswordViewModel viewModel = new CrosswordViewModel();

        // Presenter
        CrosswordPresenter presenter = new CrosswordPresenter(viewModel);

        // Data access (local hardcoded)
        CrosswordPuzzleDataAccessInterface dataAccess =
                new LocalCrosswordPuzzleDataAccess();

        // Use case interactor
        StartCrosswordInputBoundary startInteractor =
                new StartCrosswordInteractor(dataAccess, presenter);

        // Controller
        CrosswordController controller = new CrosswordController(startInteractor);

        // ---- BUILD SWING UI ----

        JFrame frame = new JFrame("CSC207 Crossword");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // View (calls controller.startCrossword internally)
        CrosswordView view = new CrosswordView(controller, viewModel);

        frame.add(view);
        frame.pack();
        frame.setVisible(true);
    }
}

