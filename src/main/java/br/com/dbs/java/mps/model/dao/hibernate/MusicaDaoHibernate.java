
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
        Query query = em.createQuery(
                "select m from Musica m where upper(m.nome) like :nome");
        query.setParameter("nome", nomeFiltro.toUpperCase() + "%");
        List musicas = query.getResultList();
        return musicas;
    }
    
}
