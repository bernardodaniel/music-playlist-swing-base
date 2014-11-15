
package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Contato;
import br.com.dbs.java.mps.model.Usuario;
import br.com.dbs.java.mps.model.dao.UsuarioDao;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class UsuarioDaoHibernateTest {
    
     private UsuarioDao dao = new UsuarioDaoHibernate();
    
    @Test
    public void deveAdicionarNoBanco() {
        Usuario usuario = usuario();
        
        try {
            dao.adiciona(usuario);
            
            Assert.assertNotNull(usuario.getId());
            Assert.assertNotNull(usuario.getContato().getId());
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Deveria ter salvo o usuario");
        }
    }
 
    @Test(expected = Exception.class)
    public void naoDeveAdicionarQuandoNomeForNulo() {
        Usuario usuario = usuario();
        usuario.setNome(null);
        dao.adiciona(usuario);
    }
    
    @Test
    public void deveAlterarNoBanco() {
        Usuario usuario = usuario();
        
        dao.adiciona(usuario);
        
        Assert.assertNotNull(usuario.getId());
        
        usuario.setNome("Raul");
        
        dao.atualiza(usuario);
        
        Assert.assertEquals("Raul", usuario.getNome());
    }
    
    @Test
    public void deveRemoverDoBanco() {
        Usuario usuario = usuario();
        
        dao.adiciona(usuario);
        
        Assert.assertNotNull(usuario.getId());
        
        dao.remove(usuario.getId());
        
        Usuario doBanco = dao.pesquisaPorId(usuario.getId());
        Assert.assertNull(doBanco);
    }
    
    @Test
    public void deveListarTodosDoBanco() {
        List<Usuario> todos = dao.lista();
        Assert.assertFalse(todos.isEmpty());
    }
    
    @Test
    public void deveRetornarUmRegistroComIdExistente() {
        Long id = 1L;
        Usuario usuario = dao.pesquisaPorId(id);
        Assert.assertNotNull(usuario);
        Assert.assertEquals(id, usuario.getId());
    }
    
    @Test
    public void deveAlterarContato() {
        Usuario usuario = usuario();
        
        try {
            dao.adiciona(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Deveria ter salvo o usuario: " + e.getMessage());
        }
        
        usuario.getContato().setCelular("111");
        
        try {
            dao.atualiza(usuario);
        } catch (Exception e) {
            Assert.fail("Deveria ter alterado contato");
        }
        
        usuario = dao.pesquisaPorId(usuario.getId());
        Assert.assertEquals("111", usuario.getContato().getCelular());
    }
    
    @Test
    public void deveInserirSemContato() {
        Usuario usuario = usuario();
        usuario.setContato(null);
        
        try {
            dao.adiciona(usuario);
        } catch (Exception e) {
            Assert.fail("Deveria ter salvo o usuario");
        }
    }
    
    private Usuario usuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Zé");
        usuario.setLogin("login");
        usuario.setSenha("123");
        
        Contato contato = new Contato();
        contato.setCelular("1234");
        contato.setEmail("email");
        
        usuario.setContato(contato);
        return usuario;
    }
    
}
