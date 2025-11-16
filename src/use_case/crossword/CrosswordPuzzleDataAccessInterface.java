package use_case.crossword;

import entity.crossword.CrosswordPuzzle;

public interface CrosswordPuzzleDataAccessInterface {
    CrosswordPuzzle loadPuzzle();
}