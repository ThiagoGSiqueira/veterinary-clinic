package controller.menu_usuarios;

import model.Usuario;
import view.menu.MenuVeterinarioView;

public class MenuVeterinarioController {
    public void inicia(Usuario usuario) {
        MenuVeterinarioView menuVeterinarioView = new MenuVeterinarioView();
        menuVeterinarioView.exibeMenuVeterinario();
    }
}
