import dao.PetDAO;
import dao.UsuarioDAO;
import model.Pet;
import model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        PetDAO petDAO = new  PetDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u = new Usuario("Riane", "riane@gmail.com", "riane123", "CLIENTE");
        Pet pet = new Pet("Morgana Costa", "Pequeno", "Gato", LocalDate.of(2025, 6, 15), 3);

        petDAO.atualizarPet(7, pet);
    }
}