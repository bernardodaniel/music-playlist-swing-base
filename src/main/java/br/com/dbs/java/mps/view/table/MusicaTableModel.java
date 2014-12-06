package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MusicaTableModel extends AbstractTableModel {

    private List<Musica> musicas = new ArrayList<Musica>();
    private String[] colunas = {"ID", "Nome", "Duração", "Cantor"};

    public MusicaTableModel(List<Musica> musicas) {
        this.musicas = musicas;
    }
    
    @Override
    public int getRowCount() {
        return musicas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Musica musica = musicas.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return musica.getId();
            case 1:
                return musica.getNome();
            case 2:
                return musica.getDuracaoTexto();
            case 3:
                return musica.getCantor();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Musica getMusica(int selectedRow) {
        return musicas.get(selectedRow);
    }
    
}
