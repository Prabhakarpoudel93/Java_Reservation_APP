/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TableDAO;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AddTables;
import util.Global;

/**
 *
 * @author Prabhakar
 */
public class ViewTableWaiter extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewTableWaiter
     */
    
    DefaultTableModel model;
    public ViewTableWaiter() {
        initComponents();
        model=new DefaultTableModel(null, new String[]{"ID","Name"});
        jTable_viewTable.setModel(model);
        
    }
    public void clearTable()
    {
        int row=jTable_viewTable.getRowCount();
        for(int i=0;i<row;i++)
        {
            model.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_viewTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton_loadTable = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable_viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_viewTable);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        jButton_loadTable.setText("Load Table");
        jButton_loadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loadTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jButton_loadTable)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton_loadTable)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_loadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loadTableActionPerformed
        // TODO add your handling code here:
        clearTable();
        TableDAO tdao=new TableDAO();
        List<AddTables> adt=tdao.loadTable();
        for(AddTables at:adt)
        {
            model.addRow(new Object[]{at.getId(),at.getName()});
        }
    }//GEN-LAST:event_jButton_loadTableActionPerformed

    private void jTable_viewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewTableMouseClicked
        // TODO add your handling code here:
        
        int row=jTable_viewTable.getSelectedRow();
        int id=(int) jTable_viewTable.getValueAt(row, 0);
        String tablename=(String) jTable_viewTable.getValueAt(row, 1);
        int val=JOptionPane.showConfirmDialog(this, "Are you dure you want to select table name :"+tablename+"??","are you sure", JOptionPane.YES_NO_OPTION);
        if(val==JOptionPane.YES_OPTION)
        {
            Global.table_id=id;
            Global.table_name=tablename;
             JDesktopPane desktop2=getDesktopPane();   // to add the frame in desktop as it is being called with the help of
                                                       // another internal frame and closing the old internal frame
                                                       
             ViewMenuWaiter vmw=new ViewMenuWaiter();
             desktop2.add(vmw);
             vmw.show();
             this.dispose();
        }
    }//GEN-LAST:event_jTable_viewTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_loadTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_viewTable;
    // End of variables declaration//GEN-END:variables
}
