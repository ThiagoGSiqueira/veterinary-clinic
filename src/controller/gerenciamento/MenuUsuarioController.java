package controller.menu_usuarios;

import enums.MenuOpcaoUsuario;
import model.Usuario;
import view.entidades.CriarAnimalView;
import view.menu.MenuUsuarioView;

public class MenuUsuarioController {
    public void inicia(Usuario usuario) {
            MenuUsuarioView menuUsuarioView = new MenuUsuarioView();
            MenuOpcaoUsuario menuOpcaoUsuario = menuUsuarioView.exibeMenuUsuario();

            switch (menuOpcaoUsuario) {
                case ADICIONAR_ANIMAL:
                    CriarAnimalView criarAnimalView = new CriarAnimalView();
                    criarAnimalView.
            }
    }
}
