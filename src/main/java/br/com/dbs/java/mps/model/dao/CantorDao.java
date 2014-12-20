package br.com.dbs.java.mps.model.dao;

import br.com.dbs.java.mps.model.Cantor;
import java.util.List;

public interface CantorDao 
    extends GenericDao<Cantor> {
    
    List<Cantor> pesquisaPorNome(String nome);
    
}
