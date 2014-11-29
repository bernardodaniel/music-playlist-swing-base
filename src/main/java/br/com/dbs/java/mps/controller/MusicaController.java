/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.PersistenceException;

/**
 *
 * @author daniel
 */
public class MusicaController {
    private final MusicaDialog view;
    private MusicaDao musicaDao = new MusicaDaoHibernate();
    private CantorDao cantorDao = new CantorDaoHibernate();
    private Musica musica;
    private MusicaTableModel musicaTableModel;
    
    public MusicaController(MusicaDialog view) {
        this.view = view;
    }

    public void preencheComboBoxCantor() {
        List<Cantor> cantores = cantorDao.lista();
        for (Cantor cantor : cantores) {
            view.adicionaCantorNoCombo(cantor);
        }
    }

    public void salvar() {
         if (musica == null) {
            musica = new Musica();
        }
        
        musica.setNome(view.getNome());
        musica.setDuracao(view.getDuracao());
        musica.setCantor(view.getCantorSelecionado());
        
        if (musica.getId() == null) {
            musicaDao.adiciona(musica);
        } else {
            musicaDao.atualiza(musica);
        }
        
        preencheTabela();
        view.mostraMensagem("Salvo com sucesso!");
    }

    public void preencheTabela() {
        preencheTabela(musicaDao.lista());
    }

    private void preencheTabela(final List<Musica> lista) {
        musicaTableModel = new MusicaTableModel(lista);
        view.atualizaTabela(musicaTableModel);
    }

    public void carregaMusicaDaTabela(int linhaSelecionada) {
        musica = musicaTableModel.getMusica(linhaSelecionada);
        preencheCampos();
    }

    private void preencheCampos() {
        if (musica == null) {
            view.limpaCampos();
        } else {
            view.setMusica(musica.getNome());
            view.setCantor(musica.getCantor());
            view.setDuracao(musica.getDuracaoDate());
        }
    }

    public void pesquisa() {
        List<Musica> musicas = musicaDao.pesquisaPorNome(view.getNomeFiltro());
        preencheTabela(musicas);
    }

    public void novo() {
        musica = null;
        view.limpaCampos();
    }

    public void excluir(int linha) {
        musica = musicaTableModel.getMusica(linha);
        try {
            musicaDao.remove(musica.getId());
        } catch (RuntimeException e) {
            view.mostraMensagem("Erro ao remover registro: " + e.getMessage());
            return;
        }
        
        novo();
        preencheTabela();
        view.mostraMensagem("Excluiu com sucesso");
    }
    
}
