package view.crossword;

import interface_adapters.crossword.CrosswordController;
import interface_adapters.crossword.CrosswordViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CrosswordView extends JPanel {

    private final CrosswordController controller;
    private final CrosswordViewModel viewModel;

    private final JLabel imageLabel;
    private final JPanel answersPanel;
    private final List<JTextField> answerFields;

    public CrosswordView(CrosswordController controller, CrosswordViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;
        this.answerFields = new ArrayList<>();

        setLayout(new BorderLayout());

        // Image at the top/center
        imageLabel = new JLabel("", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Answers panel at the bottom
        answersPanel = new JPanel();
        answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
        add(answersPanel, BorderLayout.SOUTH);

        // load puzzle before build view
        controller.startCrossword();

        // Build UI once from ViewModel
        buildUIFromViewModel();
    }

    private void buildUIFromViewModel() {
        // load local image
        String imagePath = viewModel.getImagePath();
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagePath);
            imageLabel.setIcon(icon);
        }

        // create text fields
        int count = viewModel.getNumSolutions();
        for (int i = 0; i < count; i++) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel("Answer " + (i + 1) + ": ");
            JTextField tf = new JTextField(20);

            row.add(label);
            row.add(tf);
            answersPanel.add(row);

            answerFields.add(tf);
        }
    }

    public List<String> getUserAnswers() {
        List<String> answers = new ArrayList<>();
        for (JTextField field : answerFields) {
            answers.add(field.getText());
        }
        return answers;
    }
}