package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.dao.GenericDao;
import br.com.dbs.java.mps.model.util.JPAUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDaoHibernate<T> 
    implements GenericDao<T> {

    private Class<T> classePersistente;
    
    public GenericDaoHibernate() {
        classePersistente = getTypeClass();
    }
    
    private Class<T> getTypeClass() {
        ParameterizedType type = 
                (ParameterizedType)getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        Class<T> classe = (Class<T>) types[0];
        return classe;
    }
    
    @Override
    public void adiciona(T entidade) {
        EntityManager em = JPAUtil.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public void atualiza(T entidade) {
        EntityManager em = JPAUtil.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public void remove(Long id) {
        EntityManager em = JPAUtil.createEntityManager();
        
        try {
            em.getTransaction().begin();
            T entidade = em.find(classePersistente, id);
            em.remove(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public List<T> lista() {
        EntityManager em = JPAUtil.createEntityManager();
        Query q = em.createQuery("select t from " 
                + getTypeClass().getSimpleName() + " t" );
        
        List lista = q.getResultList();
        return lista;
    }

    @Override
    public T pesquisaPorId(Long id) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            T objeto = em.find(classePersistente, id);
            return objeto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
}
