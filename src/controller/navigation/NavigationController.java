package controller.navigation;

import controller.admin.AdminMenuController;
import controller.user.UserMenuController;
import controller.veterinarian.VeterinarianMenuController;
import enums.domain.Role;
import enums.menu.user.FlowStatus;
import model.User;

import java.sql.SQLException;

public class NavigationController {
    public void routeToMenuByRole(User loggedUser) throws SQLException {
        if (Role.CLIENT.equals(loggedUser.getRole())) {
            UserMenuController userMenuController = new UserMenuController();
            FlowStatus teste = userMenuController.start(loggedUser);
            if (teste.equals(FlowStatus.EXIT_SESSION)) {
                return;
            }
        } else if  (Role.ADMIN.equals(loggedUser.getRole())) {
            AdminMenuController adminMenuController = new AdminMenuController();
            adminMenuController.start(loggedUser);
        } else if (Role.VETERINARIAN.equals(loggedUser.getRole())) {
            VeterinarianMenuController veterinarianMenuController = new VeterinarianMenuController();
            veterinarianMenuController.start(loggedUser);
        }
    }
}
