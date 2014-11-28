/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Cantor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class CantorTableModel  extends AbstractTableModel {
    
    private static final long serialVersionUID = 3547632541183372655L;
    
    private String[] colunas = {"ID", "Nome", "Sobrenome"};
    
    private List<Cantor> cantores = new ArrayList<>();
    
    public CantorTableModel(List<Cantor> cantores) {
        this.cantores = cantores;
    }

    @Override
    public int getRowCount() {
        return cantores.size();
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
        
        if (cantores == null || cantores.isEmpty())
            return null;
        
        if (rowIndex >= cantores.size())
            return null;
        
        final Cantor cantor = cantores.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return cantor.getId();
            case 1:
                return cantor.getNome();
            case 2:
                return cantor.getSobrenome();
        }
        return null;
    }
    
    public List<Cantor> getCantores() {
        return cantores;
    }
}
