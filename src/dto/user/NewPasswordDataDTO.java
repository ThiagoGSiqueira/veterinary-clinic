package dto.user;

public class NewPasswordDataDTO {
    private String newPassword;
    private String confirmPassword;

    public NewPasswordDataDTO(String newPassword, String confirmPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
