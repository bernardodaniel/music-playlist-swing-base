package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Playlist;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PlaylistTableModel extends AbstractTableModel {

    private List<Playlist> playlists = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Duração"};
    
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
        Playlist playlist = playlists.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return playlist.getId();
            case 1:
                return playlist.getNome();
            case 2:
                return playlist.getDuracaoTotal();
        }
        return null;
    }
    
    public Playlist getPlaylist(int linha) {
        return playlists.get(linha);
    }
    
}
