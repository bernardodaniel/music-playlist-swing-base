package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.Playlist;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.PlaylistDao;
import br.com.dbs.java.mps.model.dao.hibernate.MusicaDaoHibernate;
import br.com.dbs.java.mps.model.dao.hibernate.PlaylistDaoHibernate;
import br.com.dbs.java.mps.thread.PlayThread;
import br.com.dbs.java.mps.view.PlaylistDialog;
import br.com.dbs.java.mps.view.PlaylistFormDialog;
import br.com.dbs.java.mps.view.table.MusicaTableModel;
import br.com.dbs.java.mps.view.table.MusicasPlaylistListModel;
import br.com.dbs.java.mps.view.table.PlaylistTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlaylistController {

    private PlaylistFormDialog viewCadastro;
    private PlaylistDialog viewListagem;
    private Playlist playlist = new Playlist();
    private PlaylistDao playlistDao = new PlaylistDaoHibernate();
    private MusicaDao musicaDao = new MusicaDaoHibernate();
    private MusicasPlaylistListModel listModelMusicasPlaylist = new MusicasPlaylistListModel();
    private MusicasPlaylistListModel listModelMusicasDisponiveis = new MusicasPlaylistListModel();
    private PlaylistTableModel playlistTableModel;
    private Map<String, PlayThread> threads = new HashMap<>();

    public PlaylistController(PlaylistDialog viewListagem) {
        this.viewListagem = viewListagem;
    }

    public void registraViewCadastro(PlaylistFormDialog viewCadastro) {
        this.viewCadastro = viewCadastro;
    }
    
    public void salvar() {
        playlist.setNome(viewCadastro.getNome());        
        
        if (playlist.getId() == null)
            playlistDao.adiciona(playlist);
        else 
             playlistDao.atualiza(playlist);
        
        viewCadastro.mostraMensagem("Sucesso");
        viewCadastro.fecha();
        carregaPlaylists();
    }

    public void carregaListaMusicasDisponiveis() {
        List<Musica> musicas = musicaDao.lista();
        listModelMusicasDisponiveis = new MusicasPlaylistListModel();
        listModelMusicasDisponiveis.addList(musicas);
        viewCadastro.atualizaListaMusicasDisponiveis(listModelMusicasDisponiveis);
    }

    public void adicionarMusicaNaPlaylist(Object selectedValue) {
        final Musica musica = (Musica)selectedValue;
        listModelMusicasPlaylist.addElement(musica);
        listModelMusicasDisponiveis.removeElement(musica);
        
        playlist.adicionaMusica(musica);
        
        viewCadastro.atualizaListaMusicasPlaylist(listModelMusicasPlaylist);
        viewCadastro.atualizaListaMusicasDisponiveis(listModelMusicasDisponiveis);
        viewCadastro.setDuracao(playlist.getDuracaoTotal());
    }

    public void removerMusicaDaPlayList(Object selectedValue) {
        final Musica musica = (Musica)selectedValue;
        
        listModelMusicasDisponiveis.addElement(musica);
        listModelMusicasPlaylist.removeElement(musica);
        
        viewCadastro.atualizaListaMusicasPlaylist(listModelMusicasPlaylist);
        viewCadastro.atualizaListaMusicasDisponiveis(listModelMusicasDisponiveis);
        
        playlist.removeMusica(musica);
    }

    public void carregaPlaylists() {
        playlistTableModel = new PlaylistTableModel(playlistDao.lista());
        viewListagem.atualizaTabelaPlaylist(playlistTableModel);
    }

    public void carregaMusicasDaPlaylist(int selectedRow) {
        playlist = playlistTableModel.getPlaylist(selectedRow);
        MusicaTableModel musicaTableModel = new MusicaTableModel(playlist.getMusicas());
        viewListagem.atualizaTabelaMusicasDaPlaylist(musicaTableModel);
    }

    public void carregaPlaylistNoForm() {
        new PlaylistFormDialog(viewListagem, this, playlist).setVisible(true);
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void preencheFormularioEdicao() {
        if (playlist == null)
            viewCadastro.limpaCampos();
        else {
            viewCadastro.setNome(playlist.getNome());
            viewCadastro.setDuracao(playlist.getDuracaoTotal());
            listModelMusicasPlaylist = new MusicasPlaylistListModel();
            listModelMusicasPlaylist.addList(playlist.getMusicas());
            viewCadastro.atualizaListaMusicasPlaylist(listModelMusicasPlaylist);
            
            listModelMusicasDisponiveis.removeAll(playlist.getMusicas());
        }
        
    }

    public void excluir(int selectedRow) {
        playlist = playlistTableModel.getPlaylist(selectedRow);
        playlistDao.remove(playlist.getId());
        viewListagem.mostraMensagem("Sucesso");
        carregaPlaylists();
    }
    
    public void play(int selectedRow) {
        playlist = playlistTableModel.getPlaylist(selectedRow);
        final String nome = playlist.getNome();
        final PlayThread playThread = new PlayThread(nome);
        
        threads.put(nome, playThread);
        
        playThread.start();
    }
    
    public void stop(int selectedRow) {
        playlist = playlistTableModel.getPlaylist(selectedRow);
        final String nome = playlist.getNome();
        threads.get(nome).interrupt();
    }
    
}
