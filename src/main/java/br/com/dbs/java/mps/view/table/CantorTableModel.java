package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Cantor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CantorTableModel 
    extends AbstractTableModel {
    
    private List<Cantor> cantores = new ArrayList<Cantor>();
    private String[] colunas = {"ID", "Nome", "Sobrenome"};
    
    public CantorTableModel(List<Cantor> cantores) {
        if (cantores != null) {
            this.cantores = cantores;
        }
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cantor cantor = cantores.get(rowIndex);
        
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

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Cantor getCantor(int linhaSelecionada) {
        return cantores.get(linhaSelecionada);
    }
    
}
