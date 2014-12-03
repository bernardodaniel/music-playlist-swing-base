/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Playlist;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class PlaylistTableModel extends AbstractTableModel {
    
    private List<Playlist> playlists;
    private String[] colunas = {"Nome", "Duração"};

    
    public PlaylistTableModel(List<Playlist> playlists) {
        this.playlists = playlists;
    }
    
    @Override
    public int getRowCount() {
        return playlists.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (playlists == null || playlists.isEmpty())
            return null;
        
        final Playlist playlist = playlists.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return playlist.getNome();
                
            case 1:
                return playlist.getDuracaoTotal();
        }
        
        return null;
    }

    public Playlist getPlaylist(int selectedRow) {
        return playlists.get(selectedRow);
    }
    
}
