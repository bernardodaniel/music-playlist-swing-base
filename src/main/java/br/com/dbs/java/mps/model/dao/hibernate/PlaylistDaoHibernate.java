/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.model.dao.hibernate;

import br.com.dbs.java.mps.model.Playlist;
import br.com.dbs.java.mps.model.dao.PlaylistDao;
import br.com.dbs.java.mps.model.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class PlaylistDaoHibernate extends GenericDaoHibernate<Playlist> implements PlaylistDao {

    @Override
    public void remove(Long id) {
        EntityManager em = JPAUtil.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Playlist playlist = em.find(Playlist.class, id);
            playlist.getMusicas().clear();
            em.remove(playlist);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
}
