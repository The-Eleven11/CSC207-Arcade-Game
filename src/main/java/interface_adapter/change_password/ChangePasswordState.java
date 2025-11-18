package interface_adapter.change_password;

public class ChangePasswordState {

    private String username = "";
    private String oldPassword = "";
    private String newPassword = "";
    private String confirmPassword = "";
    private String errorMessage = "";
    private String successMessage = "";

    public ChangePasswordState() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getSuccessMessage() { return successMessage; }
    public void setSuccessMessage(String successMessage) { this.successMessage = successMessage; }
}
