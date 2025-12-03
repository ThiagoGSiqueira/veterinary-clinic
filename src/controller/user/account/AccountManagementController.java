package controller.user.account;

import enums.menu.user.AccountOptions;
import model.User;
import view.user.AccountMenuView;
import view.user.DisplayAccountInfo;

public class AccountManagementController {
    public void start(User loggedUser) {
        boolean running = true;
        while (running) {
            AccountMenuView accountMenuView = new AccountMenuView();
            AccountOptions accountOptions = accountMenuView.displayAccountManagementMenu();

            switch (accountOptions) {
                case VIEW_ACCOUNT_INFO:
                    DisplayAccountInfo displayAccountInfo = new DisplayAccountInfo();
                    displayAccountInfo.displayAccountInfo(loggedUser);
                    break;
                case CHANGE_PASSWORD:
                    System.out.println("Chamar view de mudar senha");
                    System.out.println("Mudar senha");
                    break;
                case DELETE_ACCOUNT:
                    System.out.println("Deletar conta");
                    break;
                case BACK:
                    System.out.println("Voltar pro menu anterior");
                    running = false;
            }
        }
    }
}
