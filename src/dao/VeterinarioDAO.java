package dao;

import model.Veterinario;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {
    //Criar Veterinario
    //Listar Veterinarios & Veterinario por id
    //Atualizar Veterinario
    //Remover Veterinario

    public int criarVeterinario (Veterinario veterinario) throws SQLException {
        String sql = "INSERT INTO veterinario(nome, crmv, telefone) VALUES (?, ?,?)";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, veterinario.getNome());
            ps.setString(2, veterinario.getCrmv());
            ps.setString(3, veterinario.getTelefone());

            return ps.executeUpdate();
        }
    }

    public List<Veterinario> listarVeterinarios() throws SQLException {
        String sql =  "SELECT * FROM veterinario";
        List<Veterinario> veterinarios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Veterinario veterinario = new Veterinario(
                        rs.getString("nome"),
                        rs.getString("crmv"),
                        rs.getString("telefone"),
                        rs.getInt("id_vet")
                );

                veterinarios.add(veterinario);
            }
        }
        return veterinarios;
    }
}
