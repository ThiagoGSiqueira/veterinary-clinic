import dao.PetDAO;
import dao.UsuarioDAO;
import dao.VeterinarioDAO;
import model.Pet;
import model.Usuario;
import model.Veterinario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PetDAO petDAO = new PetDAO();
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        try {
            Veterinario veterinario = new Veterinario("Ingryt Gomes", "YYYYSP", "1188888888");
            int teste = veterinarioDAO.criarVeterinario(veterinario);
            if (teste >= 1) {
                System.out.println("Veterinario criado com sucesso!");
            }

            List<Veterinario> veterinarios = veterinarioDAO.listarVeterinarios();

            for (Veterinario vet : veterinarios) {
                System.out.println(vet.getNome());
                System.out.println(vet.getCrmv());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

    }
}