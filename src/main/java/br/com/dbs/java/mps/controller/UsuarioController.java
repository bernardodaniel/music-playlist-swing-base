package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Usuario;
import br.com.dbs.java.mps.model.dao.UsuarioDao;
import br.com.dbs.java.mps.model.dao.hibernate.UsuarioDaoHibernate;
import br.com.dbs.java.mps.view.UsuarioDialog;
import br.com.dbs.java.mps.view.table.UsuarioTableModel;


public class UsuarioController {
    
    private final UsuarioDialog view;
    private UsuarioDao dao = new UsuarioDaoHibernate();
    private Usuario usuario = new Usuario();
    private UsuarioTableModel usuarioTableModel;
    
    public UsuarioController(UsuarioDialog view) {
        this.view = view;
    }
    
    public void salvar() {
        usuario = getUsuario();
        if (usuario.getId() == null) {
            dao.adiciona(usuario);
        } else {
            dao.atualiza(usuario);
        }
        
        preencheTabela();
        view.mostraMensagem("Sucesso!");
    }

    private Usuario getUsuario() {
        usuario.setNome(view.getNome());
        usuario.setLogin(view.getLogin());
        usuario.setSenha(view.getSenha());
        return usuario;
    }

    public void preencheTabela() {
        usuarioTableModel = new UsuarioTableModel(dao.lista());
        view.atualizaTabela(usuarioTableModel);
    }

    public void carregaUsuario(int selectedRow) {
        usuario = usuarioTableModel.getUsuario(selectedRow);
        view.setNome(usuario.getNome());
        view.setlogin(usuario.getLogin());
    }

    public void exclui(int selectedRow) {
        usuario = usuarioTableModel.getUsuario(selectedRow);
        dao.remove(usuario.getId());
        preencheTabela();
    }
    
}
