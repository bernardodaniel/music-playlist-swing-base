
package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.Playlist;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.dao.PlaylistDao;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class PlaylistDaoHibernateTest {
    
     private MusicaDao musicaDao = new MusicaDaoHibernate();
     private PlaylistDao playlistDao = new PlaylistDaoHibernate();
    
    @Test
    public void deveAdicionarNoBanco() {
        Playlist playlist = playlist();
        
        try {
            playlistDao.adiciona(playlist);
            
            Assert.assertNotNull(playlist.getId());
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Deveria ter salvo a musica");
        }
    }
 
    @Test(expected = Exception.class)
    public void naoDeveAdicionarQuandoNomeForNulo() {
        Playlist playlist = playlist();
        playlist.setNome(null);
        playlistDao.adiciona(playlist);
    }
    
    @Test
    public void deveAlterarNoBanco() {
       Playlist playlist = playlist();
        
        playlistDao.adiciona(playlist);
        
        Assert.assertNotNull(playlist.getId());
        
        playlist.setNome("Sertanejo Brega");
        
        playlistDao.atualiza(playlist);
        
        Assert.assertEquals("Sertanejo Brega", playlist.getNome());
    }
    
    @Test
    public void deveRemoverDoBanco() {
        Playlist playlist = playlist();
        
        playlistDao.adiciona(playlist);
        
        Assert.assertNotNull(playlist.getId());
        
        playlistDao.remove(playlist.getId());
        
        Playlist doBanco = playlistDao.pesquisaPorId(playlist.getId());
        Assert.assertNull(doBanco);
    }
    
    @Test
    public void deveListarTodosDoBanco() {
        List<Playlist> todos = playlistDao.lista();
        Assert.assertFalse(todos.isEmpty());
    }
    
    @Test
    public void deveRetornarUmRegistroComIdExistente() {
        Long id = 1L;
        Playlist musica = playlistDao.pesquisaPorId(id);
        Assert.assertNotNull(musica);
        Assert.assertEquals(id, musica.getId());
    }
    
    private Playlist playlist() {
        Playlist playlist = new Playlist();
        playlist.setNome("Forró Brega");
        
        Musica musica1 = musicaDao.pesquisaPorId(1L);
        Musica musica2 = musicaDao.pesquisaPorId(2L);
        
        playlist.adicionaMusica(musica1);
        playlist.adicionaMusica(musica2);
                
        return playlist;
    }
    
}
