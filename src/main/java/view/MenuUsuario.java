package view;

import entity.Usuario;

public class MenuUsuario implements Menu {
    Usuario usuario;

    public MenuUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void show(Usuario usuario) {

    }
}
