
package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.hibernate.CantorDaoHibernate;
import br.com.dbs.java.mps.model.dao.hibernate.MusicaDaoHibernate;
import br.com.dbs.java.mps.view.MusicaDialog;
import br.com.dbs.java.mps.view.table.MusicaTableModel;
import java.util.List;

public class MusicaController {

    private MusicaDialog view;
    private CantorDao cantorDao =
            new CantorDaoHibernate();
    private Musica musica;
    private MusicaDao musicaDao =
            new MusicaDaoHibernate();
    private MusicaTableModel tableModel;
    
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
        musica.setDuracao(view.getDuracao());
        
        if (musica.getId() == null) {
            musicaDao.adiciona(musica);
        } else {
            musicaDao.atualiza(musica);
        }
        
        preencheMusicas();
        view.mostraMensagem("Música salva com sucesso!");
    }

    public void preencheMusicas() {
        List<Musica> musicas = musicaDao.lista();
        tableModel = new MusicaTableModel(musicas);
        view.atualizaTabelaDeMusicas(tableModel);
    }

    public void carregaMusica(int selectedRow) {
        musica = tableModel.getMusica(selectedRow);
        view.setNomeDaMusica(musica.getNome());
        view.setCantor(musica.getCantor());
        view.setDuracao(musica.getDuracaoDate());
    }

    public void excluir(int selectedRow) {
        musica = tableModel.getMusica(selectedRow);
        musicaDao.remove(musica.getId());
        preencheMusicas();
    }

    public void pesquisar() {
        String nomeFiltro = view.getNomeFiltro();
        List<Musica> musicas = 
                musicaDao.pesquisaPorNome(nomeFiltro);
        
        tableModel = new MusicaTableModel(musicas);
        view.atualizaTabelaDeMusicas(tableModel);
    }
    
}
