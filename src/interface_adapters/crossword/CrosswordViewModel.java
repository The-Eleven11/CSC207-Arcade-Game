package interface_adapters.crossword;

import java.beans.PropertyChangeListener; //  From clean CA lab
import java.beans.PropertyChangeSupport;


public class CrosswordViewModel {

    private String puzzleId;
    private String imagePath;
    private int numSolutions;
    private String statusMessage;

    public CrosswordViewModel() {
        this.puzzleId = "";
        this.imagePath = "";
        this.numSolutions = 0;
        this.statusMessage = "";
    }


    public String getPuzzleId() {
        return puzzleId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getNumSolutions() {
        return numSolutions;
    }

    public String getStatusMessage() {
        return statusMessage;
    }


    public void setPuzzleId(String puzzleId) {
        this.puzzleId = puzzleId;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setNumSolutions(int numSolutions) {
        this.numSolutions = numSolutions;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
