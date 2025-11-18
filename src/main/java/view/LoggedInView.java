package view;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    private LogoutController logoutController;

    private final JLabel username;

    private final JButton multipleChoiceBtn;
    private final JButton crosswordBtn;
    private final JButton connectionsBtn;

    private final JButton logOut;
    private final JButton changePassword;

    public LoggedInView(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {

        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Username
        JLabel usernameInfo = new JLabel("Currently logged in as: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Menu section (3 vertical buttons)
        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.Y_AXIS));
        menuButtons.setAlignmentX(Component.CENTER_ALIGNMENT);

        multipleChoiceBtn = new JButton("Multiple Choice");
        multipleChoiceBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        crosswordBtn = new JButton("Crossword");
        crosswordBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectionsBtn = new JButton("Connections");
        connectionsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButtons.add(multipleChoiceBtn);
        menuButtons.add(crosswordBtn);
        menuButtons.add(connectionsBtn);

        // Bottom buttons: Logout + Change Password
        JPanel bottomButtons = new JPanel();

        logOut = new JButton("Log Out");
        changePassword = new JButton("Change Password");

        bottomButtons.add(logOut);
        bottomButtons.add(changePassword);

        // Actions
        logOut.addActionListener(this);

        changePassword.addActionListener(e -> {
            viewManagerModel.setState("change password");
            viewManagerModel.firePropertyChange();
        });

        // Add components to layout
        this.add(usernameInfo);
        this.add(username);

        this.add(menuButtons);
        this.add(bottomButtons);
    }

    /**
     * React to a button click.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (logoutController != null) {
            logoutController.execute();
        }
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
