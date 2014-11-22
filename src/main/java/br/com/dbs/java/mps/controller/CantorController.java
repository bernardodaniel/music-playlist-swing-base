package br.com.dbs.java.mps.controller;

import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.model.dao.CantorDao;
import br.com.dbs.java.mps.model.dao.hibernate.CantorDaoHibernate;
import br.com.dbs.java.mps.util.ImagemUtil;
import br.com.dbs.java.mps.view.CantorFrame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class CantorController {
    
    private CantorFrame view;
    private Cantor cantor;
    private CantorDao cantorDao;
    
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
    
    
    
    
    
    
    
    
    
}
