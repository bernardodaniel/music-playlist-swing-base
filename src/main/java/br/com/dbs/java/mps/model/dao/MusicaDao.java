/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.model.dao;

import br.com.dbs.java.mps.model.Musica;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface MusicaDao extends GenericDao<Musica> {

    public List<Musica> pesquisaPorNome(String nomeFiltro);
    
}
