package controller.user;

import controller.user.account.AccountManagementController;
import controller.user.consultation.ConsultationManagementController;
import controller.user.pet.PetManagementController;
import enums.menu.user.FlowStatus;
import enums.menu.user.MainMenuUser;
import model.User;
import view.user.UserMenuView;

import java.sql.SQLException;

public class UserMenuController {
    public FlowStatus start(User loggedUser) throws SQLException {
        boolean running = true;
        while(running) {
            UserMenuView userMenuView = new UserMenuView();
            MainMenuUser mainMenuUser = userMenuView.getUserMenuChoice(loggedUser);

            switch (mainMenuUser) {
                case MainMenuUser.MANAGE_ACCOUNT:
                    AccountManagementController accountManagementController = new AccountManagementController();
                    FlowStatus teste = accountManagementController.start(loggedUser);

                    if (teste.equals(FlowStatus.EXIT_SESSION)) {
                        System.out.println("Imrpime isso");
                        return FlowStatus.EXIT_SESSION;
                    }
                    break;
                case MainMenuUser.MANAGE_PET:
                    PetManagementController petManagementController = new PetManagementController();
                    petManagementController.start(loggedUser);
                    break;
                case MainMenuUser.MANAGE_CONSULTATION:
                    ConsultationManagementController consultationManagementController = new ConsultationManagementController();
                    consultationManagementController.start(loggedUser);
                    break;
                case MainMenuUser.EXIT:
                    running = false;
                    break;
            }
        }

        return FlowStatus.CONTINUE;
    }

}
