/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbs.java.mps.view;

import br.com.dbs.java.mps.controller.MusicaController;
import br.com.dbs.java.mps.model.Cantor;
import br.com.dbs.java.mps.view.table.MusicaTableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author daniel
 */
public class MusicaDialog extends javax.swing.JDialog {

    private MusicaController controller = new MusicaController(this);
    
    /**
     * Creates new form MusicaDialog
     */
    public MusicaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        filtroPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeFiltroTxt = new javax.swing.JTextField();
        pesquisarBtn = new javax.swing.JButton();
        tabelaPnl = new javax.swing.JScrollPane();
        musicasTbl = new javax.swing.JTable();
        camposPnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        musicaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantorCb = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        duracaoTxt = new javax.swing.JFormattedTextField();
        botoesPnl = new javax.swing.JPanel();
        novoBtn = new javax.swing.JButton();
        salvarBtn = new javax.swing.JButton();
        excluirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome");

        pesquisarBtn.setText("Pesquisar");
        pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filtroPnlLayout = new javax.swing.GroupLayout(filtroPnl);
        filtroPnl.setLayout(filtroPnlLayout);
        filtroPnlLayout.setHorizontalGroup(
            filtroPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtroPnlLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeFiltroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarBtn))
        );
        filtroPnlLayout.setVerticalGroup(
            filtroPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtroPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filtroPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeFiltroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarBtn))
                .addContainerGap())
        );

        musicasTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        musicasTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicasTblMouseClicked(evt);
            }
        });
        tabelaPnl.setViewportView(musicasTbl);

        jLabel2.setText("Música");

        jLabel3.setText("Cantor");

        jLabel4.setText("Duração");

        duracaoTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("mm:ss"))));

        javax.swing.GroupLayout camposPnlLayout = new javax.swing.GroupLayout(camposPnl);
        camposPnl.setLayout(camposPnlLayout);
        camposPnlLayout.setHorizontalGroup(
            camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(camposPnlLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(musicaTxt))
                    .addGroup(camposPnlLayout.createSequentialGroup()
                        .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantorCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(camposPnlLayout.createSequentialGroup()
                                .addComponent(duracaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        camposPnlLayout.setVerticalGroup(
            camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camposPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(musicaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(camposPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(duracaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(filtroPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(camposPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(botoesPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(camposPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botoesPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controller.preencheComboBoxCantor();
        controller.preencheTabela();
    }//GEN-LAST:event_formWindowOpened

    private void salvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtnActionPerformed
        controller.salvar();
    }//GEN-LAST:event_salvarBtnActionPerformed

    private void musicasTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicasTblMouseClicked
        controller.carregaMusicaDaTabela(getLinhaSelecionada());
    }//GEN-LAST:event_musicasTblMouseClicked

    private void pesquisarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarBtnActionPerformed
        controller.pesquisa();
    }//GEN-LAST:event_pesquisarBtnActionPerformed

    private void novoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoBtnActionPerformed
        controller.novo();
    }//GEN-LAST:event_novoBtnActionPerformed

    private void excluirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBtnActionPerformed
        controller.excluir(getLinhaSelecionada());
    }//GEN-LAST:event_excluirBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoesPnl;
    private javax.swing.JPanel camposPnl;
    private javax.swing.JComboBox cantorCb;
    private javax.swing.JFormattedTextField duracaoTxt;
    private javax.swing.JButton excluirBtn;
    private javax.swing.JPanel filtroPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField musicaTxt;
    private javax.swing.JTable musicasTbl;
    private javax.swing.JTextField nomeFiltroTxt;
    private javax.swing.JButton novoBtn;
    private javax.swing.JButton pesquisarBtn;
    private javax.swing.JButton salvarBtn;
    private javax.swing.JScrollPane tabelaPnl;
    // End of variables declaration//GEN-END:variables

    public void adicionaCantorNoCombo(Cantor cantor) {
        cantorCb.addItem(cantor);
    }
    
    public void mostraMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public String getNome() {
        return musicaTxt.getText();
    }

    public Date getDuracao() {
        return (Date) duracaoTxt.getValue();
    }

    public Cantor getCantorSelecionado() {
        return (Cantor) cantorCb.getSelectedItem();
    }

    public void atualizaTabela(TableModel musicaTableModel) {
        musicasTbl.setModel(musicaTableModel);
    }
    
    private int getLinhaSelecionada() {
        return musicasTbl.getSelectedRow();
    }

    public void limpaCampos() {
        musicaTxt.setText(null);
        duracaoTxt.setText(null);
        cantorCb.repaint();
    }

    public void setMusica(String nome) {
        musicaTxt.setText(nome);
    }

    public void setCantor(Cantor cantor) {
        cantorCb.setSelectedItem(cantor);
        cantorCb.repaint();
    }

    public void setDuracao(Date duracao) {
        duracaoTxt.setValue(duracao);
    }
    
    public String getNomeFiltro() {
        return nomeFiltroTxt.getText();
    }
    
}
