package dao;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import model.Pet;
import model.Usuario;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PetDAO {
    //Adicionar pet
    //Remover pet
    //Listar TODOS os pets
    //Listar pet por dono
    //Atualizar pet

    public void criarPet(Pet pet, int idUsuario) {
        String sql = "INSERT INTO pet (nome, porte, especie, data_nascimento, id_usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getPorte());
            ps.setString(3, pet.getEspecie());
            ps.setDate(4, java.sql.Date.valueOf(pet.getData_nascimento()));
            ps.setInt(5, idUsuario);
            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println("Pet criado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerPet(int idPet) {
        String sql = "DELETE FROM pet WHERE id_pet = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPet);
            int linhasAfetadas = ps.executeUpdate();

            if  (linhasAfetadas > 0) {
                System.out.println("Pet removido");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPetsPorDono(int idUsuario) {
        String sql = "SELECT * FROM pet WHERE id_usuario = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id_pet"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("id_usuario"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPets() {
        String sql = "SELECT * FROM pet";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
               System.out.println(rs.getString("nome"));
           }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarPet(int idPet, Pet pet) {
        String sql = "UPDATE pet SET nome=? WHERE id_pet = ?";

        try(Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pet.getNome());
            ps.setInt(2, idPet);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
