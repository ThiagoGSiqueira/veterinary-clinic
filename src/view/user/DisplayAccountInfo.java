package view.user;


import model.User;

public class DisplayAccountInfo {
    public void displayAccountInfo(User loggedUser) {
        System.out.println("--- INFORMAÇÕES DA CONTA ---");
        System.out.println("ID de usuário: " + loggedUser.getIdUser());
        System.out.println("Nome: " + loggedUser.getName());
        System.out.println("Email: " + loggedUser.getEmail());
        System.out.println("Cargo: " + loggedUser.getRole());
    }
}
