package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.Playlist;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.PlaylistDao;
import br.com.dbs.java.mps.model.dao.hibernate.MusicaDaoHibernate;
import br.com.dbs.java.mps.model.dao.hibernate.PlaylistDaoHibernate;
import br.com.dbs.java.mps.view.PlaylistDialog;
import br.com.dbs.java.mps.view.PlaylistFormDialog;
import br.com.dbs.java.mps.view.table.MusicasPlaylistListModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;


public class PlaylistController {

    private PlaylistFormDialog viewCadastro;
    private PlaylistDialog viewListagem;
    private Playlist playlist = new Playlist();
    private PlaylistDao playlistDao = new PlaylistDaoHibernate();
    private MusicaDao musicaDao = new MusicaDaoHibernate();
    private MusicasPlaylistListModel listModelMusicasPlaylist = new MusicasPlaylistListModel();
    private MusicasPlaylistListModel listModelMusicasDisponiveis = new MusicasPlaylistListModel();

    public PlaylistController(PlaylistDialog viewListagem) {
        this.viewListagem = viewListagem;
    }

    public void registraViewCadastro(PlaylistFormDialog viewCadastro) {
        this.viewCadastro = viewCadastro;
    }
    
    public void salvar() {
        playlist.setNome(viewCadastro.getNome());        
        
        playlistDao.adiciona(playlist);
        
        viewCadastro.mostraMensagem("Sucesso");
        viewCadastro.fecha();
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
    
}
