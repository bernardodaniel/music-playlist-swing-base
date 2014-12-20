/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dbs.java.mps.view;

import br.com.dbs.java.mps.controller.CantorController;
import java.awt.Frame;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author DBS
 */
public class CantorFrame extends javax.swing.JDialog {

    public CantorFrame(Frame owner) {
        super(owner);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botoesPnl = new javax.swing.JPanel();
        novoBtn = new javax.swing.JButton();
        salvarBtn = new javax.swing.JButton();
        excluirBtn = new javax.swing.JButton();
        camposPnl = new javax.swing.JPanel();
        fotoPnl = new javax.swing.JPanel();
        fotoLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sobrenomeTxt = new javax.swing.JTextField();
        carregarFotoBtn = new javax.swing.JButton();
        tabelaPnl = new javax.swing.JScrollPane();
        cantoresTbl = new javax.swing.JTable();
        filtrosPnl = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomeFiltroTxt = new javax.swing.JTextField();
        pesquisarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cantor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        botoesPnl.setBackground(new java.awt.Color(102, 153, 255));

        novoBtn.setText("Novo");
        novoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoBtnActionPerformed(evt);
            }
        });
        botoesPnl.add(novoBtn);

        salvarBtn.setText("Salvar");
        salvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtnActionPerformed(evt);
            }
        });
        botoesPnl.add(salvarBtn);

        excluirBtn.setText("Excluir");
        excluirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBtnActionPerformed(evt);
            }
        });
        botoesPnl.add(excluirBtn);

        camposPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fotoPnl.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        javax.swing.GroupLayout fotoPnlLayout = new javax.swing.GroupLayout(fotoPnl);
        fotoPnl.setLayout(fotoPnlLayout);
        fotoPnlLayout.setHorizontalGroup(
            fotoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        fotoPnlLayout.setVerticalGroup(
            fotoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fotoPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome");

        jLabel2.setText("Sobrenome");

        carregarFotoBtn.setText("Carregar Foto");
        carregarFotoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarFotoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout camposPnlLayout = new javax.swing.GroupLayout(camposPnl);
        camposPnl.setLayout(camposPnlLayout);
        camposPnlLayout.setHorizontalGroup(
            camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTxt)
                    .addComponent(sobrenomeTxt)
                    .addGroup(camposPnlLayout.createSequentialGroup()
                        .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(carregarFotoBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        camposPnlLayout.setVerticalGroup(
            camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(camposPnlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sobrenomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(carregarFotoBtn))
                    .addComponent(fotoPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cantoresTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        cantoresTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantoresTblMouseClicked(evt);
            }
        });
        tabelaPnl.setViewportView(cantoresTbl);

        filtrosPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nome");

        pesquisarBtn.setText("Pesquisar");
        pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filtrosPnlLayout = new javax.swing.GroupLayout(filtrosPnl);
        filtrosPnl.setLayout(filtrosPnlLayout);
        filtrosPnlLayout.setHorizontalGroup(
            filtrosPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeFiltroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtrosPnlLayout.setVerticalGroup(
            filtrosPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtrosPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomeFiltroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botoesPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(camposPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtrosPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(filtrosPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camposPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoesPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed
        controller.salvar();
    }//GEN-LAST:event_salvarBtnActionPerformed

    private void novoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoBtnActionPerformed
        controller.novo();
    }//GEN-LAST:event_novoBtnActionPerformed

    private void carregarFotoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarFotoBtnActionPerformed
        JFileChooser selecionador = new JFileChooser();
        int opcao = selecionador.showOpenDialog(this);
        
        if (opcao == JFileChooser.APPROVE_OPTION) {
            File foto = selecionador.getSelectedFile();
            controller.carregarFoto(foto);
        }
    }//GEN-LAST:event_carregarFotoBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controller.preencheTabela();
    }//GEN-LAST:event_formWindowOpened

    private void cantoresTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantoresTblMouseClicked
        controller.preencheCampos(
                cantoresTbl.getSelectedRow());
    }//GEN-LAST:event_cantoresTblMouseClicked

    private void excluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBtnActionPerformed
        controller.exclui(cantoresTbl.getSelectedRow());
    }//GEN-LAST:event_excluirBtnActionPerformed

    private void pesquisarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarBtnActionPerformed
        controller.pesquisa();
    }//GEN-LAST:event_pesquisarBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoesPnl;
    private javax.swing.JPanel camposPnl;
    private javax.swing.JTable cantoresTbl;
    private javax.swing.JButton carregarFotoBtn;
    private javax.swing.JButton excluirBtn;
    private javax.swing.JPanel filtrosPnl;
    private javax.swing.JLabel fotoLbl;
    private javax.swing.JPanel fotoPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeFiltroTxt;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JButton novoBtn;
    private javax.swing.JButton pesquisarBtn;
    private javax.swing.JButton salvarBtn;
    private javax.swing.JTextField sobrenomeTxt;
    private javax.swing.JScrollPane tabelaPnl;
    // End of variables declaration//GEN-END:variables

    private CantorController controller 
            = new CantorController(this);

    public String getNomeFiltro() {
        return nomeFiltroTxt.getText();
    }
    
    public String getNome() {
        return nomeTxt.getText();
    }

    public String getSobrenome() {
        return sobrenomeTxt.getText();
    }
    
    public void setNome(String nome) {
        nomeTxt.setText(nome);
    }
    
    public void setSobreNome(String sobrenome) {
        sobrenomeTxt.setText(sobrenome);
    }
    
    public void mostraMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public void limpaCampos() {
        nomeTxt.setText(null);
        sobrenomeTxt.setText(null);
        setFoto(null);
    }

    public void setFoto(ImageIcon icone) {
        fotoLbl.setIcon(icone);
    }
    }
}
    
    public void atualizaTabelaDeCantores(TableModel tableModel) {
        cantoresTbl.setModel(tableModel);
        cantoresTbl.repaint();
    }

    public void setNome(String nome) {
        nomeTxt.setText(nome);
    }

    public void setSobrenome(String sobrenome) {
        sobrenomeTxt.setText(sobrenome);
    }

    public String getNomeFiltro() {
        return nomeFiltroTxt.getText();
