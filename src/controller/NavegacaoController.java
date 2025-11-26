package controller;

import model.Usuario;

import java.sql.SQLException;

public class NavegacaoController {
    public void encaminharParaMenuPorCargo(Usuario usuarioLogado) throws SQLException {
        if ("cliente".equalsIgnoreCase(usuarioLogado.getCargo())) {
            MenuUsuarioController menuUsuarioController = new MenuUsuarioController();
            menuUsuarioController.inicia(usuarioLogado);
        } else if ("admin".equalsIgnoreCase(usuarioLogado.getCargo())) {
            MenuAdminController menuAdminController = new MenuAdminController();
            menuAdminController.inicia(usuarioLogado);
        } else if ("veterinario".equalsIgnoreCase(usuarioLogado.getCargo())) {
            MenuVeterinarioController menuVeterinarioController = new MenuVeterinarioController();
            menuVeterinarioController.inicia(usuarioLogado);
        }
    }
}
