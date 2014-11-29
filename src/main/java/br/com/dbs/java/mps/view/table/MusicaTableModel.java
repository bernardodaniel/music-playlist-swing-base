/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class MusicaTableModel extends AbstractTableModel {
    
    private static final long serialVersionUID = -2265702537261265251L;

    private List<Musica> musicas = new ArrayList<>();
    private String[] colunas = {"id", "nome", "duração", "cantor"};
    
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
        if (musicas == null || musicas.isEmpty())
            return null;
        
        if (rowIndex >= musicas.size())
            return null;
        
        Musica musica = getMusica(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return musica.getId();
            case 1:
                return musica.getNome();
            case 2:
                return musica.getDuracao();
            case 3:
                return musica.getCantor();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public Musica getMusica(int rowIndex) {
        if (rowIndex >= musicas.size())
            return null;
        return musicas.get(rowIndex);
    }
    
}
