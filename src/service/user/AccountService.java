package service.user;

import dao.UserDAO;
import dto.user.NewPasswordDataDTO;
import model.User;

import java.sql.SQLException;

public class AccountService {
    public boolean checkCurrentPassword(User loggedUser, String currentPassword) {
        return loggedUser.getPassword().equals(currentPassword);
    }

    public boolean changePassword(User loggedUser, NewPasswordDataDTO newPasswordDataDTO) throws SQLException {
        if (newPasswordDataDTO.getNewPassword().equals(newPasswordDataDTO.getConfirmPassword())) {
            UserDAO userDAO = new UserDAO();
            if (userDAO.updatePasswordById(loggedUser.getIdUser(), newPasswordDataDTO.getNewPassword()) >= 1) {
                loggedUser.setPassword(newPasswordDataDTO.getNewPassword());
                return true;
            }
            ;
            return false;
        }
        return false;
    }


    public boolean deleteAccount(User loggedUser) throws SQLException {
        UserDAO userDAO = new UserDAO();
        if (userDAO.deleteById(loggedUser.getIdUser()) >= 1) {
            loggedUser.setIsActive(0);
            return true;
        }
        return false;
    }
}
