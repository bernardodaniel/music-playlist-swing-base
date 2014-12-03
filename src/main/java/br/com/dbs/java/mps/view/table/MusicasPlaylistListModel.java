/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Musica;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author daniel
 */
public class MusicasPlaylistListModel extends DefaultListModel<Musica> {

    public MusicasPlaylistListModel() {
        
    }
    public void addList(List<Musica> musicas) {
        for (Musica musica : musicas) {
            addElement(musica);
        }
    }

    public void removeAll(List<Musica> musicas) {
        for (Musica musica : musicas) {
            removeElement(musica);
        }
    }
    
}
