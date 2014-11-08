package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.dao.CantorDao;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CantorDaoHibernateTest {

    private CantorDao dao = new CantorDaoHibernate();
    
    @Test
    public void deveAdicionarCantorNoBanco() {
        Cantor cantor = new Cantor();
        cantor.setNome("Zé");
        cantor.setSobrenome("Ramalho");
        
        try {
            dao.adiciona(cantor);
        } catch (Exception e) {
            Assert.fail("Deveria ter salvo o cantor");
        }
    }
    
    @Test(expected = Exception.class)
    public void naoDeveAdicionarCantorQuandoNomeForNulo() {
        Cantor cantor = new Cantor();
        cantor.setNome(null);
        dao.adiciona(cantor);
    }
    
    @Test
    public void deveAlterarCantorNoBanco() {
        Cantor cantor = new Cantor();
        cantor.setNome("Luan");
        cantor.setSobrenome("Santana");
        
        dao.adiciona(cantor);
        
        Assert.assertNotNull(cantor.getId());
        
        cantor.setNome("Raul");
        cantor.setSobrenome("Seixas");
        
        dao.atualiza(cantor);
        
        Assert.assertEquals("Raul", cantor.getNome());
    }
    
    @Test
    public void deveRemoverCantorDoBanco() {
        Cantor cantor = new Cantor();
        cantor.setNome("Chitaozinho");
        cantor.setSobrenome("Xororó");
        
        dao.adiciona(cantor);
        
        Assert.assertNotNull(cantor.getId());
        
        Cantor cantorDoBanco = dao.pesquisaPorId(cantor.getId());
        dao.remove(cantor.getId());
        
        cantorDoBanco = dao.pesquisaPorId(cantor.getId());
        Assert.assertNull(cantorDoBanco);
    }
    
    @Test
    public void deveListarCantoresDoBanco() {
        List<Cantor> cantores = dao.lista();
        Assert.assertFalse(cantores.isEmpty());
    }
    
    @Test
    public void deveRetornarUmCantorComIdExistente() {
        Long id = 1L;
        Cantor cantor = dao.pesquisaPorId(id);
        Assert.assertNotNull(cantor);
        Assert.assertEquals(id, cantor.getId());
        Assert.assertEquals("Frank", cantor.getNome());
    }
    
}
