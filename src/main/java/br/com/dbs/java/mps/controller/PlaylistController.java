/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.Playlist;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.PlaylistDao;
import br.com.dbs.java.mps.model.dao.hibernate.MusicaDaoHibernate;
import br.com.dbs.java.mps.model.dao.hibernate.PlaylistDaoHibernate;
import br.com.dbs.java.mps.thread.ExecutaPlaylist;
import br.com.dbs.java.mps.view.PlaylistDialog;
import br.com.dbs.java.mps.view.PlaylistFormDialog;
import br.com.dbs.java.mps.view.table.MusicaTableModel;
import br.com.dbs.java.mps.view.table.PlaylistTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DBS
 */
public class PlaylistController {
    
    private PlaylistDialog view;
    private PlaylistDao playlistDao = new PlaylistDaoHibernate();
    private PlaylistTableModel playlistTableModel;
    private MusicaTableModel musicaTableModelView;
    private Map<String, ExecutaPlaylist> threads =
            new HashMap<String, ExecutaPlaylist>();
    private MusicaDao musicaDao = new MusicaDaoHibernate();
    private MusicaTableModel musicaTableModelDisponiveis;
    private PlaylistFormDialog form;
    private MusicaTableModel musicaTableModelPlaylist;
    private Playlist playlist = new Playlist();

    public PlaylistController(PlaylistDialog view) {
        this.view = view;
    }

    public void preencheTabelaPlaylist() {
        List<Playlist> playlists = playlistDao.lista();
        playlistTableModel = new PlaylistTableModel(playlists);
        view.atualizaTabelaPlaylist(playlistTableModel);
    }
    
    public void carregaMusicasDaPlaylistView(int linha) {
        Playlist playlist = playlistTableModel.getPlaylist(linha);
        List<Musica> musicas = playlist.getMusicas();
        musicaTableModelView = new MusicaTableModel(musicas);
        view.atualizaTabelaMusicas(musicaTableModelView);
    }
    
    public void executarPlaylist(int linha) {
        Playlist playlist = playlistTableModel.getPlaylist(linha);
        ExecutaPlaylist executaPlaylist = 
                new ExecutaPlaylist(playlist.getNome());
        
        threads.put(playlist.getNome(), executaPlaylist);
        
        executaPlaylist.start();
    }
    
    public void pararPlaylist(int linha) {
        Playlist playlist = playlistTableModel.getPlaylist(linha);
        ExecutaPlaylist executaPlaylist =
                threads.get(playlist.getNome());
        
        executaPlaylist.interrupt();
    }

    public void preencheTabelaMusicasDisponveis() {
        List<Musica> musicas = musicaDao.lista();
        musicaTableModelDisponiveis = new MusicaTableModel(musicas);
        form.atualizaTabelaMusicasDisponiveis(
                musicaTableModelDisponiveis);
        
        musicaTableModelDisponiveis.removeMusicas(
                playlist.getMusicas());
    }
    
    public void registraForm(PlaylistFormDialog form) {
        this.form = form;
        musicaTableModelPlaylist =
            new MusicaTableModel(new ArrayList<Musica>());
        form.atualizaTabelaMusicasPlaylist(
                musicaTableModelPlaylist);
    }
    
    public void adicionaMusica(int linha) {
        Musica musica = musicaTableModelDisponiveis.getMusica(linha);
        
        musicaTableModelPlaylist.adicionaMusica(musica);
        musicaTableModelDisponiveis.removeMusica(musica);
        
        playlist.adicionaMusica(musica);
        form.setDuracao(playlist.getDuracaoTotalDate());
    }
    
    public void removeMusica(int linha) {
        Musica musica = musicaTableModelPlaylist.getMusica(linha);
        musicaTableModelDisponiveis.adicionaMusica(musica);
        musicaTableModelPlaylist.removeMusica(musica);
        
        playlist.removeMusica(musica);
    }
    
    public void salvar() {
        playlist.setNome(form.getNome());
        
        if (playlist.getId() == null) {
            playlistDao.adiciona(playlist);
        } else {
            playlistDao.atualiza(playlist);
        }
        
        preencheTabelaPlaylist();
    }

    public void preencheFormPlaylist(int selectedRow) {
        playlist = playlistTableModel.getPlaylist(selectedRow);
        form.setNome(playlist.getNome());
        form.setDuracao(playlist.getDuracaoTotalDate());
        musicaTableModelPlaylist = 
                new MusicaTableModel(playlist.getMusicas());
        form.atualizaTabelaMusicasPlaylist(musicaTableModelPlaylist);
    }
    
}
