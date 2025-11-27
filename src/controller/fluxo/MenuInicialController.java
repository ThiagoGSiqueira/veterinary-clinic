package controller.menu_inicial;

import controller.fluxo.NavegacaoController;
import dto.CriarContaUsuarioDTO;
import dto.CriarVeterinarioDTO;
import enums.Cargo;
import enums.MenuOpcao;
import model.Usuario;
import service.acesso.AutenticaService;
import service.acesso.CriarContaService;
import view.acesso.AutenticaView;
import view.acesso.CriarContaView;
import view.acesso.MenuInicialView;

import java.sql.SQLException;

public class MenuInicialController {

    public void inicia() throws SQLException {
        Usuario usuarioLogado = null;
        MenuInicialView menu = new MenuInicialView();
        NavegacaoController navegacaoController = new NavegacaoController();

        MenuOpcao opcao = menu.exibeMenu();

        switch (opcao) {
            case MenuOpcao.AUTENTICAR:
                AutenticaService autenticaService = new AutenticaService();
                AutenticaView autenticaView = new AutenticaView();
                usuarioLogado = autenticaService.autenticar(autenticaView.autenticaMenu());
                autenticaView.usuarioLogado(usuarioLogado);

                navegacaoController.encaminharParaMenuPorCargo(usuarioLogado);

                break;
            case MenuOpcao.CRIAR_CONTA:
                CriarContaView criarContaView = new CriarContaView();
                CriarContaUsuarioDTO usuarioDTO = criarContaView.criarContaUsuario();
                CriarVeterinarioDTO vetDTO = null;
                if (Cargo.VETERINARIO.equals(usuarioDTO.getCargo())) {
                    vetDTO = criarContaView.criarContaVeterinario();
                }

                CriarContaService criarContaService = new CriarContaService();
                usuarioLogado = criarContaService.criarConta(usuarioDTO, vetDTO);
                criarContaView.contaCriada(usuarioLogado);
                navegacaoController.encaminharParaMenuPorCargo(usuarioLogado);
                break;
            case MenuOpcao.SAIR:
                return;
        }
    }
}
