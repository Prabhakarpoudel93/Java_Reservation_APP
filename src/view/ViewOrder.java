/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OrderDAO;
import java.awt.print.PrinterException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.AddItemWaiter;

/**
 *
 * @author Prabhakar
 */
public class ViewOrder extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewOrder
     */
    DefaultTableModel model;
    //double total=0;
    public ViewOrder() {
        initComponents();
        model= new DefaultTableModel(null,new String[]{"Name","Price","Qty","total"});
        jTable_viewOrder.setModel(model);
    }
    public void clearTable()
    {
        int row=jTable_viewOrder.getRowCount();
        for(int i=0;i<row;i++)
        {
            model.removeRow(0);
        }
    }
    private void printBill()
    {
        int count=jTable_viewOrder.getRowCount();
        String str="\t  FastFood Center\n  \t  Koteshwor,Ktm\n";
        str+="\nName\tprice\tqty\ttotal\n";
        str+=".............................................................................................\n";
        for(int i=0;i<count;i++) {
            str+=jTable_viewOrder.getValueAt(i, 0).toString()+"\t";
            str+=jTable_viewOrder.getValueAt(i, 1).toString()+"\t";
            str+=jTable_viewOrder.getValueAt(i, 2).toString()+"\t";
            str+=jTable_viewOrder.getValueAt(i, 3).toString()+"\n";
            
//            System.out.println("Hello");
        }
    str+="\nGross Total:\t\t"+jLabel_total.getText();
    str+="\nDiscount Percent: \t"+jTextField_discountPercent.getText()+"%";
    str+="\nTaxable Amount: \t"+jLabel_taxableAmt.getText();
    str+="\nVAT 13% Percent: \t"+jLabel_vatAmt.getText();
    str+="\nNet Total:\t\t"+jLabel_netAmt.getText();
    str+="\n\n\t !!Thanks for visiting!!";
    
    BillPrint bp=new BillPrint();
    bp.jTextArea_Bill.setLineWrap(true);
    bp.jTextArea_Bill.setText(str);
    try{
        bp.jTextArea_Bill.print();
    }catch(PrinterException ex){
        
        System.out.println(ex);
    }
    }
    
    public void payments()
    {
        String name=jTextField_name.getText();
        String contact=jTextField_contact.getText();
        int tableid=Integer.parseInt(jTextField_tableID.getText());
        double grossamt=Double.parseDouble(jLabel_total.getText());
        double netamt=Double.parseDouble(jLabel_netAmt.getText());
        double discount=Double.parseDouble(jTextField_discount.getText());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_total1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_tableId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_viewOrder = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_contact = new javax.swing.JTextField();
        jTextField_tableID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_total = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jTextField_discount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel_vatAmt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_netAmt = new javax.swing.JLabel();
        jTextField_discountPercent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel_taxableAmt = new javax.swing.JLabel();

        jLabel_total1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_total1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_total1.setText("jLabel4");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Table Name ");

        jTextField_tableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_tableIdActionPerformed(evt);
            }
        });

        jLabel2.setText("current date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_tableId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_tableId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jTable_viewOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_viewOrder);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Table Id");

        jButton2.setText("PrintBill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_contact)
                            .addComponent(jTextField_tableID)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(223, 223, 223))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_tableID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gross Amt : ");

        jLabel_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_total.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_total.setText("jLabel4");

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel.setText("Discount % : ");

        jTextField_discount.setUI(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VAT 13% : ");

        jLabel_vatAmt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_vatAmt.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_vatAmt.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Net Amt : ");

        jLabel_netAmt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_netAmt.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_netAmt.setText("jLabel4");

        jTextField_discountPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_discountPercentActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Taxable Amt : ");

        jLabel_taxableAmt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_taxableAmt.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_taxableAmt.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_total)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField_discountPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_vatAmt)
                                    .addComponent(jLabel_netAmt))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_taxableAmt)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel_total))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(jTextField_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_discountPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_taxableAmt))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_vatAmt))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_netAmt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_tableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_tableIdActionPerformed
        // TODO add your handling code here:
        clearTable();
        double total=0;
        int id=Integer.parseInt(jTextField_tableId.getText());
        jTextField_tableID.setText(id+"");
        System.out.println(id);
        OrderDAO odao=new OrderDAO();
        List<AddItemWaiter> laiw=odao.viewOrder(id);
        for(AddItemWaiter aiw:laiw)
        {
            model.addRow(new Object[]{aiw.getName(),aiw.getPrice(),aiw.getQty(),aiw.getTotal()});
            total+=aiw.getTotal();
        }
        jLabel_total.setText(total+"");
        jTextField_discountPercent.setText(0+"");
        double discount= Double.parseDouble(jTextField_discountPercent.getText());
        double discountindecimal=discount/100;
        double discountamt=total*discountindecimal;
        double taxableamt=(total-discountamt);
        jLabel_taxableAmt.setText(taxableamt+"");
        double tax=0.13*taxableamt;
        jLabel_vatAmt.setText(tax+"");
        double netamt=taxableamt+tax;
        jLabel_netAmt.setText(netamt+"");
        
        
        
    }//GEN-LAST:event_jTextField_tableIdActionPerformed

    private void jTextField_discountPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_discountPercentActionPerformed
        // TODO add your handling code here:
        double total=Double.parseDouble(jLabel_total.getText());
        double discount= Double.parseDouble(jTextField_discountPercent.getText());
        double discountindecimal=discount/100;
        double discountamt=total*discountindecimal;
        double taxableamt=(total-discountamt);
        jLabel_taxableAmt.setText(taxableamt+"");
        double tax=0.13*taxableamt;
        jLabel_vatAmt.setText(tax+"");
        double netamt=taxableamt+tax;
        jLabel_netAmt.setText(netamt+"");
    }//GEN-LAST:event_jTextField_discountPercentActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        printBill();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_netAmt;
    private javax.swing.JLabel jLabel_taxableAmt;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JLabel jLabel_total1;
    private javax.swing.JLabel jLabel_vatAmt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_viewOrder;
    private javax.swing.JTextField jTextField_contact;
    private javax.swing.JTextField jTextField_discount;
    private javax.swing.JTextField jTextField_discountPercent;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_tableID;
    private javax.swing.JTextField jTextField_tableId;
    // End of variables declaration//GEN-END:variables
}
