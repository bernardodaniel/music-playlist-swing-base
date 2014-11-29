package br.com.dbs.java.mps.model.dao;

import java.util.List;
import javax.persistence.PersistenceException;

public interface GenericDao<T> {
    
    void adiciona(T entidade);
    
    void atualiza(T entidade);
    
    void remove(Long id) throws PersistenceException;
    
    List<T> lista();
    
    T pesquisaPorId(Long id);
    
}
