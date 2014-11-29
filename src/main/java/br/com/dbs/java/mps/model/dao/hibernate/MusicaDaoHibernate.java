
package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Musica;
import br.com.dbs.java.mps.model.dao.MusicaDao;
import br.com.dbs.java.mps.model.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
public class MusicaDaoHibernate extends GenericDaoHibernate<Musica> implements MusicaDao {

    @Override
    public List<Musica> pesquisaPorNome(String nomeFiltro) {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select m from Musica m where m.nome like :nome");
        q.setParameter("nome", nomeFiltro + "%");
        return q.getResultList();
    }
    
}
