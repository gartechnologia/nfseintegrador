/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.view;

import br.com.gartech.nfse.integrador.model.FaturamentoImport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Gilson
 */
public class ImportarView extends javax.swing.JDialog {
    
    private List<FaturamentoImport> faturamento;

    /**
     * Creates new form ImportarView
     */
    public ImportarView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            }
        return null;
    }
    
    public List<FaturamentoImport> readFaturamentoExcelFile(String excelFilePath) throws IOException {
        List<FaturamentoImport> listaFaturamento = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        
        while( iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            FaturamentoImport aFaturamentoImport = new FaturamentoImport();
            
            while(cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                
                switch(columnIndex) {
                    case 0:
                        if(nextRow.getRowNum() == 0) {
                            if(!getCellValue(nextCell).equals("CAMPUS") ) {
                                
                            }
                        } else {
                            aFaturamentoImport.setCampus((String) getCellValue(nextCell));
                        }
                        break;                    
                    case 1:
                        aFaturamentoImport.setCampus((String) getCellValue(nextCell));
                        break;
                    case 2:
                        aFaturamentoImport.setNumero((String) getCellValue(nextCell));
                        break;                   
//                    case 3:
//                        aFaturamentoImport.setTipo_fatura((String) getCellValue(nextCell));
//                        break;                        
//                    case 4:
//                        aFaturamentoImport.setAnocompetencia((Integer) getCellValue(nextCell));
//                        break;                        
//                    case 5:
//                        aFaturamentoImport.setMescompetencia((int) getCellValue(nextCell));
//                        break;                        
//                    case 6:
//                        aFaturamentoImport.setCodaluno((int) getCellValue(nextCell));
//                        break;                        
//                    case 7:
//                        aFaturamentoImport.setAlunome((String) getCellValue(nextCell));
//                        break;                        
//                    case 8:
//                        aFaturamentoImport.setCodcurso((int) getCellValue(nextCell));
//                        break;                        
//                    case 9:
//                        aFaturamentoImport.setCurso((String) getCellValue(nextCell));
//                        break;                      
//                    case 10:
//                        aFaturamentoImport.setTipocurso((String) getCellValue(nextCell));
//                        break;                        
//                    case 11:
//                        aFaturamentoImport.setAluendereco((String) getCellValue(nextCell));
//                        break;                        
//                    case 12:
//                        aFaturamentoImport.setAlubairro((String) getCellValue(nextCell));
//                        break;                        
//                    case 13:
//                        aFaturamentoImport.setAlucep((String) getCellValue(nextCell));
//                        break;                       
//                    case 14:
//                        aFaturamentoImport.setCiddesc((String) getCellValue(nextCell));
//                        break;                        
//                    case 15:
//                        aFaturamentoImport.setCiduf((String) getCellValue(nextCell));
//                        break;                      
//                    case 16:
//                        aFaturamentoImport.setAlutelefone((String) getCellValue(nextCell));
//                        break;                        
//                    case 17:
//                        aFaturamentoImport.setAlutelefone2((String) getCellValue(nextCell));
//                        break;                        
//                    case 18:
//                        aFaturamentoImport.setAluemail((String) getCellValue(nextCell));
//                        break;                        
//                    case 19:
//                        aFaturamentoImport.setAlucpf((String) getCellValue(nextCell));
//                        break;                       
                    case 20:
                        aFaturamentoImport.setValor((float) getCellValue(nextCell));
                        break;                        
                }
            }
            listaFaturamento.add(aFaturamentoImport);
        }
        //workbook.close;
        inputStream.close();        
        
        return listaFaturamento;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Importar Excel");

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImportar)
                .addContainerGap(814, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(btnImportar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Por favor, selecione um arquivo excel para importar");
        int result = jf.showOpenDialog(null);
        
        if(result== JFileChooser.APPROVE_OPTION) {
            try {
                String excelPath = jf.getSelectedFile().getAbsolutePath();
                //JOptionPane.showMessageDialog(null, excelPath);
                
                faturamento = new ArrayList<>();
                faturamento = readFaturamentoExcelFile(excelPath);
            } catch (IOException ex) {
                Logger.getLogger(ImportarView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_btnImportarActionPerformed

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
            java.util.logging.Logger.getLogger(ImportarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImportarView dialog = new ImportarView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnImportar;
    // End of variables declaration//GEN-END:variables


}
