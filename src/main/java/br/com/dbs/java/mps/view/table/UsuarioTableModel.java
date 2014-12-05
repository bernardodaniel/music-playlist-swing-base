
package br.com.dbs.java.mps.view.table;

import br.com.dbs.java.mps.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private String[] colunas = {"ID", "Nome", "Login"};

    public UsuarioTableModel(List<Usuario> usuairos) {
        this.usuarios = usuairos;
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
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
        
        if (usuarios == null || usuarios.isEmpty())
            return null;
        
        Usuario usuario = usuarios.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return usuario.getId();
            case 1:
                return usuario.getNome();
            case 2:
                return usuario.getLogin();
        }
        return null;
    }

    public Usuario getUsuario(int selectedRow) {
        return usuarios.get(selectedRow);
    }
    
}
