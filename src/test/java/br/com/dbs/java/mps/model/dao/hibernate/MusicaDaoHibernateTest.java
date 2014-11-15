
package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class MusicaDaoHibernateTest {
    
     private MusicaDao musicaDao = new MusicaDaoHibernate();
     private CantorDao cantorDao = new CantorDaoHibernate();
    
    @Test
    public void deveAdicionarNoBanco() {
        Musica musica = musica();
        
        try {
            musicaDao.adiciona(musica);
            
            Assert.assertNotNull(musica.getId());
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Deveria ter salvo a musica");
        }
    }
 
    @Test(expected = Exception.class)
    public void naoDeveAdicionarQuandoNomeForNulo() {
        Musica musica = musica();
        musica.setNome(null);
        musicaDao.adiciona(musica);
    }
    
    @Test
    public void deveAlterarNoBanco() {
        Musica musica = musica();
        
        musicaDao.adiciona(musica);
        
        Assert.assertNotNull(musica.getId());
        
        musica.setNome("Prenda");
        
        musicaDao.atualiza(musica);
        
        Assert.assertEquals("Prenda", musica.getNome());
    }
    
    @Test
    public void deveRemoverDoBanco() {
        Musica musica = musica();
        
        musicaDao.adiciona(musica);
        
        Assert.assertNotNull(musica.getId());
        
        musicaDao.remove(musica.getId());
        
        Musica doBanco = musicaDao.pesquisaPorId(musica.getId());
        Assert.assertNull(doBanco);
    }
    
    @Test
    public void deveListarTodosDoBanco() {
        List<Musica> todos = musicaDao.lista();
        Assert.assertFalse(todos.isEmpty());
    }
    
    @Test
    public void deveRetornarUmRegistroComIdExistente() {
        Long id = 1L;
        Musica musica = musicaDao.pesquisaPorId(id);
        Assert.assertNotNull(musica);
        Assert.assertEquals(id, musica.getId());
    }
    
    private Musica musica() {
        Musica musica = new Musica();
        musica.setNome("Morango do Nordeste");
        musica.setDuracao(60);
        
        Cantor cantor = cantorDao.pesquisaPorId(1L);
        
        musica.setCantor(cantor);
        
        return musica;
    }
    
}
