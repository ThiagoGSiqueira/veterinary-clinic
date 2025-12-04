package controller.user.account;

import dto.user.NewPasswordDataDTO;
import enums.menu.user.AccountOptions;
import model.User;
import service.user.AccountService;
import view.user.AccountMenuView;
import view.user.ChangePasswordView;
import view.user.DisplayAccountInfo;

import java.sql.SQLException;

public class AccountManagementController {
    public void start(User loggedUser) throws SQLException {
        boolean running = true;
        while (running) {
            AccountMenuView accountMenuView = new AccountMenuView();
            AccountService accountService = new AccountService();
            AccountOptions accountOptions = accountMenuView.displayAccountManagementMenu();

            switch (accountOptions) {
                case VIEW_ACCOUNT_INFO:
                    DisplayAccountInfo displayAccountInfo = new DisplayAccountInfo();
                    displayAccountInfo.displayAccountInfo(loggedUser);
                    break;
                case CHANGE_PASSWORD:
                    ChangePasswordView changePasswordView = new ChangePasswordView();
                    String currentPassword = changePasswordView.getCurrentPassword();
                    if (accountService.checkCurrentPassword(loggedUser, currentPassword)) {
                        NewPasswordDataDTO newPasswordDataDTO = changePasswordView.getNewPassword();
                        if (accountService.changePassword(loggedUser, newPasswordDataDTO)) {
                            changePasswordView.displaySuccessMessage();
                        } else {
                            changePasswordView.displayErrorMessage();
                        }
                    } else {
                        changePasswordView.displayCurrentPasswordError();
                    }

                    break;
                case DELETE_ACCOUNT:
                    //Pensar se vou implementar com soft delete ou não.
                    System.out.println("Deletar conta");
                    break;
                case BACK:
                    System.out.println("Voltar pro menu anterior");
                    running = false;
            }
        }
    }
}
