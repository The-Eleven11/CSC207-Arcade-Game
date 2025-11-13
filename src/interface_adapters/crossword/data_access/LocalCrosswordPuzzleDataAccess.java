package interface_adapters.crossword.data_access;

import entity.crossword.CrosswordPuzzle;
import use_case.crossword.CrosswordPuzzleDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class LocalCrosswordPuzzleDataAccess implements CrosswordPuzzleDataAccessInterface {

    @Override
    public CrosswordPuzzle loadPuzzle() {
        String id = "mvp-cw-1";
        String imagePath = "images/crosswords/cw1.png";

        List<String> solutions = new ArrayList<>();
        solutions.add("ABSTRACTION");
        solutions.add("COHESION");
        solutions.add("ENCAPSULATION");

        return new CrosswordPuzzle(id, imagePath, solutions);
    }
}