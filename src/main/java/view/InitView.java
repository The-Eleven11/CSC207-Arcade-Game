package view;

import interface_adapter.InitController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InitView extends JPanel{

    private final String prompt = "choose an level to start";
    private final InitViewModel initViewModel;

    private final JButton submit;
    private final JRadioButton[] options;
    private final String[] buttonTxt;
    private InitController initController;

    public InitView(InitViewModel initViewModel) {

        this.initViewModel = initViewModel;
        this.initViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // 创建选项按钮
        final JPanel choices = new JPanel();
        options = new JRadioButton[4];
        buttonTxt = new String[] {"A", "B", "C", "D"};
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            options[i].setText(buttonTxt[i]);
            group.add(options[i]);
            choices.add(options[i]);
        }

        final JPanel buttons = new JPanel();
        submit = new JButton("submit answer");
        buttons.add(submit);

        submit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        for (JRadioButton rb : options) {
                            if (rb.isSelected()) {
                                String text = rb.getText();
                                // 将 text 发送到 usecase/interactor（通过 controller 或 viewModel）
                                System.out.println("Selected: " + text);
                                initController.execute(text);
                                break;
                            }
                        }
                    }
                }
        );



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(choices);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    // public void actionPerformed(ActionEvent evt) {
    //    System.out.println("Click " + evt.getActionCommand());
    //}

    // public String getViewName() {
    //    return viewName;
    //}

    public void setInitController(InitController initController) {
        this.InitController = initController;
    }
}
