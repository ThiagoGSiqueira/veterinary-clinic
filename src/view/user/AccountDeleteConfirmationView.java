package view.user;

import enums.menu.user.FlowStatus;

import java.util.Scanner;

public class AccountDeleteConfirmationView {
    Scanner sc = new Scanner(System.in);
    public boolean getConfirmation() {
        System.out.println("Você tem certeza? (s/n)");
        String confirmation = sc.nextLine();

        if  (confirmation.equals("s")) {
            return true;
        } else if  (confirmation.equals("n")) {
            return false;
        } else {
            System.out.println("Opção inválida");
            return false;
        }
    }
}
