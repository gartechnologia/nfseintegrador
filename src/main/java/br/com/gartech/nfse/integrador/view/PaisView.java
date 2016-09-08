/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.view;

import br.com.gartech.nfse.integrador.model.Pais;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilson
 */
public class PaisView extends javax.swing.JDialog {
    
    Boolean editando;

    /**
     * Creates new form PaisView
     */
    public PaisView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void atualizarGrid() {
        String ejbql = "from Pais order by nome";
        queryObjetos = entityManager.createQuery(ejbql);
        listObjetos.clear();
        listObjetos.addAll(queryObjetos.getResultList());

        int row = listObjetos.size()-1;
        tblObjetos.setRowSelectionInterval(row, row);
        tblObjetos.scrollRectToVisible(tblObjetos.getCellRect(row, row, true));
    }
    
    private void trataEdicao() {
        btnCancelar.setEnabled(editando);
        btnGravar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        btnFechar.setEnabled(!editando);
        btnPrimeiro.setEnabled(!editando);
        btnAnterior.setEnabled(!editando);
        btnProximo.setEnabled(!editando);
        btnUltimo.setEnabled(!editando);
        btnFiltrar.setEnabled(!editando);
        cbxOrdem.setEditable(!editando);
        txtFiltro.setEditable(!editando);
        tblObjetos.setEnabled(!editando);
        
        // tratar os campso do formulário
        txtNome.setEditable(editando);
        txtISO.setEnabled(editando);
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("integradorPU").createEntityManager();
        queryObjetos = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("from Pais order by nome");
        listObjetos = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryObjetos.getResultList();
        painelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        abas = new javax.swing.JTabbedPane();
        tabLista = new javax.swing.JPanel();
        painelFiltro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxOrdem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblObjetos = new javax.swing.JTable();
        tabDados = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtISO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
        painelNavegacao.setLayout(new java.awt.GridLayout());

        btnPrimeiro.setText("Primeiro");
        painelNavegacao.add(btnPrimeiro);

        btnAnterior.setText("Anterior");
        painelNavegacao.add(btnAnterior);

        btnProximo.setText("Próximo");
        painelNavegacao.add(btnProximo);

        btnUltimo.setText("Último");
        painelNavegacao.add(btnUltimo);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        painelNavegacao.add(btnFechar);

        getContentPane().add(painelNavegacao, java.awt.BorderLayout.PAGE_START);

        tabLista.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabLista.setLayout(new java.awt.BorderLayout());

        painelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel1.setText("Ordem:");

        cbxOrdem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Filtro:");

        btnFiltrar.setText("Filtrar");

        javax.swing.GroupLayout painelFiltroLayout = new javax.swing.GroupLayout(painelFiltro);
        painelFiltro.setLayout(painelFiltroLayout);
        painelFiltroLayout.setHorizontalGroup(
            painelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar))
        );
        painelFiltroLayout.setVerticalGroup(
            painelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabLista.add(painelFiltro, java.awt.BorderLayout.PAGE_START);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listObjetos, tblObjetos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${iso}"));
        columnBinding.setColumnName("Iso");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tblObjetos);

        tabLista.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        abas.addTab("Lista", tabLista);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        jPanel1.setLayout(new java.awt.GridLayout());

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo);

        btnEditar.setText("Editar");
        jPanel1.add(btnEditar);

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGravar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar);

        btnExcluir.setText("Excluir");
        jPanel1.add(btnExcluir);

        jLabel3.setText("Código:");

        txtCodigo.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel4.setText("Nome:");

        jLabel5.setText("ISO");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblObjetos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.iso}"), txtISO, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout tabDadosLayout = new javax.swing.GroupLayout(tabDados);
        tabDados.setLayout(tabDadosLayout);
        tabDadosLayout.setHorizontalGroup(
            tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDadosLayout.createSequentialGroup()
                .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabDadosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabDadosLayout.setVerticalGroup(
            tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDadosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        abas.addTab("Dados", tabDados);

        getContentPane().add(abas, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        listObjetos.add((Pais) new Pais());
        int row = listObjetos.size()-1;
        tblObjetos.setRowSelectionInterval(row, row);
        
        editando = true;
        trataEdicao();
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        
        try {
            int linhaClicada = tblObjetos.getSelectedRow();
            Pais obj = listObjetos.get(linhaClicada);

            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
            
            editando = false;
            trataEdicao();
            atualizarGrid();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erro ao gravar: " + e.getMessage());
            if(entityManager.getTransaction().isActive() == false) {
                entityManager.getTransaction().begin();
            }
            entityManager.getTransaction().rollback();
            editando = false;
            trataEdicao();
            atualizarGrid();            
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaisView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PaisView dialog = new PaisView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abas;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxOrdem;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.util.List<Pais> listObjetos;
    private javax.swing.JPanel painelFiltro;
    private javax.swing.JPanel painelNavegacao;
    private javax.persistence.Query queryObjetos;
    private javax.swing.JPanel tabDados;
    private javax.swing.JPanel tabLista;
    private javax.swing.JTable tblObjetos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtISO;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}