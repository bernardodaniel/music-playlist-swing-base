
package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.hibernate.CantorDaoHibernate;
import br.com.dbs.java.mps.model.dao.hibernate.MusicaDaoHibernate;
import br.com.dbs.java.mps.view.MusicaDialog;
import java.util.List;

public class MusicaController {

    private MusicaDialog view;
    private CantorDao cantorDao =
            new CantorDaoHibernate();
    private Musica musica;
    private MusicaDao musicaDao =
            new MusicaDaoHibernate();
    
    public MusicaController(MusicaDialog musicaDialog) {
        this.view = musicaDialog;
    }

    public void preencheCantores() {
        List<Cantor> cantores = cantorDao.lista();
        for (Cantor cantor : cantores) {
            view.adicionaCantorNoComboBox(cantor);
        }
    }

    public void salvar() {
        if (musica == null) {
            musica = new Musica();
        }
        
        musica.setNome(view.getNome());
        musica.setCantor(view.getCantorSelecionado());
        
        if (musica.getId() == null) {
            musicaDao.adiciona(musica);
        } else {
            musicaDao.atualiza(musica);
        }
        
        view.mostraMensagem("Música salva com sucesso!");
    }
    
}
