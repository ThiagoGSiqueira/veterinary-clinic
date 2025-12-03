package view.user;

import enums.menu.user.AccountOptions;

import java.util.Scanner;

public class AccountMenuView {

    Scanner sc = new Scanner(System.in);

    public AccountOptions displayAccountManagementMenu() {
        System.out.println("--- GERENCIAR CONTA ---");
        System.out.println("1 - Ver informações da conta.");
        System.out.println("2 - Alterar senha.");
        System.out.println("3 - Deletar conta.");
        System.out.println("0 - Voltar.");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                return AccountOptions.VIEW_ACCOUNT_INFO;
            case 2:
                return AccountOptions.CHANGE_PASSWORD;
            case 3:
                return AccountOptions.DELETE_ACCOUNT;
            case 0:
                return AccountOptions.BACK;
            default:
                return null;
        }
    }
}
