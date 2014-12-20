package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.dao.hibernate.CantorDaoHibernate;
import br.com.dbs.java.mps.util.ImagemUtil;
import br.com.dbs.java.mps.view.CantorFrame;
import br.com.dbs.java.mps.view.table.CantorTableModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class CantorController {
    
    private CantorFrame view;
    private Cantor cantor;
    private CantorDao cantorDao;
    private CantorTableModel cantorTableModel;
    
    public CantorController(CantorFrame view) {
        this.view = view;
        cantorDao = new CantorDaoHibernate();
    }
    
    public void salvar() {
        if (cantor == null) {
            cantor = new Cantor();
        }
        
        cantor.setNome(view.getNome());
        cantor.setSobrenome(view.getSobrenome());
        
        if (cantor.getId() == null) {
            cantorDao.adiciona(cantor);
        } else {
            cantorDao.atualiza(cantor);
        }
        
        preencheTabela();
        view.mostraMensagem("Salvo com sucesso!");
    }
    
    public void novo() {
        cantor = null;
        view.limpaCampos();
    }
    
    public void carregarFoto(File foto) {
        if (cantor == null) {
            cantor = new Cantor();
        }
        
        try {
            ImageIcon icone = ImagemUtil.converteArquivoEmIcone(foto);
            
            byte[] fotoByte = ImagemUtil.converteIconeEmByte(icone);
            
            cantor.setFoto(fotoByte);
            view.setFoto(icone);
            
        } catch (IOException ex) {
            Logger.getLogger(
                    CantorController.class.getName()).log(
                            Level.SEVERE, null, ex);
        }
    }
    
    public void preencheTabela() {
        List<Cantor> lista = cantorDao.lista();
        cantorTableModel = new CantorTableModel(lista);
        view.atualizaTabelaDeCantores(cantorTableModel);
    }

    public void preencheCampos(int linhaSelecionada) {
        cantor = 
                cantorTableModel.getCantor(linhaSelecionada);
        
        view.setNome(cantor.getNome());
        view.setSobrenome(cantor.getSobrenome());
        view.setFoto(ImagemUtil.
                converteByteEmIcone(cantor.getFoto()));
    }

    public void exclui(int linhaSelecionada) {
        cantor = cantorTableModel.getCantor(linhaSelecionada);
        cantorDao.remove(cantor.getId());
        preencheTabela();
        view.mostraMensagem("Cantor excluído!");
    }

    public void pesquisa() {
        final String nomeFiltro = view.getNomeFiltro();
        
        List<Cantor> cantores;
        
        if (nomeFiltro == null || nomeFiltro.isEmpty()) {
            cantores = cantorDao.lista();
        } else {
            cantores = cantorDao.pesquisaPorNome(nomeFiltro);
        }
        
        cantorTableModel = new CantorTableModel(cantores);
        view.atualizaTabelaDeCantores(cantorTableModel);
    }
    
    
    
    
    
    
    
}
