/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author daniel
 */
public class MusicasPlaylistListModel extends DefaultListModel<Musica> {

    private List<Musica> musicas = new ArrayList<>();
 
    public void addList(List<Musica> musicas) {
        for (Musica musica : musicas) {
            addElement(musica);
        }
    }
    
}
