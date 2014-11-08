package br.com.dbs.java.mps.model.dao;

import java.util.List;

public interface GenericDao<T> {
    
    void adiciona(T entidade);
    
    void atualiza(T entidade);
    
    void remove(Long id);
    
    List<T> lista();
    
    T pesquisaPorId(Long id);
    
}
