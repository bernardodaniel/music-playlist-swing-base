package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CantorDaoHibernate 
    extends GenericDaoHibernate<Cantor>
    implements CantorDao {

    @Override
    public List<Cantor> pesquisaPorNome(String nome) {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select c from Cantor c where c.nome like :nome");
        q.setParameter("nome", nome + "%");
        return q.getResultList();
    }
    
}
