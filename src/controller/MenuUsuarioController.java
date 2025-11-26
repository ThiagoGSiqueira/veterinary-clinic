package controller;

import model.Usuario;
import view.MenuUsuarioView;

public class MenuUsuarioController {
    public void inicia(Usuario usuario) {
            MenuUsuarioView menuUsuarioView = new MenuUsuarioView();
            menuUsuarioView.exibeMenuUsuario();
    }
}
