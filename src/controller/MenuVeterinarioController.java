package controller;

import model.Usuario;
import view.MenuVeterinarioView;

public class MenuVeterinarioController {
    public void inicia(Usuario usuario) {
        MenuVeterinarioView menuVeterinarioView = new MenuVeterinarioView();
        menuVeterinarioView.exibeMenuVeterinario();
    }
}
