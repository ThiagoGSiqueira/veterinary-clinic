package controller.navegacao;

import controller.menu_usuarios.MenuAdminController;
import controller.menu_usuarios.MenuUsuarioController;
import controller.menu_usuarios.MenuVeterinarioController;
import enums.Cargo;
import model.Usuario;

import java.sql.SQLException;

public class NavegacaoController {
    public void encaminharParaMenuPorCargo(Usuario usuarioLogado) throws SQLException {
        if (Cargo.CLIENTE.equals(usuarioLogado.getCargo())) {
            MenuUsuarioController menuUsuarioController = new MenuUsuarioController();
            menuUsuarioController.inicia(usuarioLogado);
        } else if  (Cargo.ADMIN.equals(usuarioLogado.getCargo())) {
            MenuAdminController menuAdminController = new MenuAdminController();
            menuAdminController.inicia(usuarioLogado);
        } else if (Cargo.VETERINARIO.equals(usuarioLogado.getCargo())) {
            MenuVeterinarioController menuVeterinarioController = new MenuVeterinarioController();
            menuVeterinarioController.inicia(usuarioLogado);
        }
    }
}
