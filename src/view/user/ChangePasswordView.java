package view.user;

import dto.user.NewPasswordDataDTO;

import java.util.Scanner;

public class ChangePasswordView {
    Scanner sc = new Scanner(System.in);
    public String getCurrentPassword() {
        System.out.println("--- MUDAR SENHA ----");
        System.out.print("Digite sua senha atual: ");
        return sc.nextLine();
    }

    public NewPasswordDataDTO getNewPassword() {
        System.out.println("--- NOVA SENHA ----");
        System.out.print("Digite sua nova senha: ");
        String newPassword = sc.nextLine();
        System.out.print("Digite a senha novamente: ");
        String confirmPassword = sc.nextLine();

        return new NewPasswordDataDTO(newPassword, confirmPassword);
    }

    public void displaySuccessMessage() {
        System.out.println("Sua senha foi alterada com sucesso!");
    }

    public void displayErrorMessage() {
        System.out.println("Suas senhas não coincidem!");
    }

    public void displayCurrentPasswordError() {
        System.out.println("Senha incorreta!");
    }

}
