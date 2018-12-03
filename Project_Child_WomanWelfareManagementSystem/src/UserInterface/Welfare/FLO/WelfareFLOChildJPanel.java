/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.FLO;

import Business.EcoSystem;
import Business.Enterprise.WelfareEnterprise;
import Business.Organization.Organization;
import Business.Organization.WelfareFLOOrganization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WelfareFLOWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class WelfareFLOChildJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelfareFLOChildJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system; 
    WelfareEnterprise enterprise;
    Organization organization;
    UserAccount account;
    public WelfareFLOChildJPanel(JPanel userProcessContainer, WelfareEnterprise enterprise, Organization organization,EcoSystem system, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        this.organization=organization;
        this.account= account;
        lblEntName.setText(enterprise.getName());
        PopulateTable();
    }
    public void PopulateTable(){
        DefaultTableModel model = (DefaultTableModel) tblwork.getModel();
        model.setRowCount(0);
        WelfareFLOOrganization org = (WelfareFLOOrganization) organization;
        for(WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            WelfareFLOWorkRequest floRequest = (WelfareFLOWorkRequest) request;
            if(floRequest.getPatient().getAge()<=6){
                Object[] row = new Object[5];
                row[0] = floRequest;
                row[1] = floRequest.getPatient().getAge();
                row[2] = floRequest.getPatient().getDisease();
                row[3] = request.getReceiver();
                row[4] = floRequest.getTestResult()== null ? "waiting" : floRequest.getTestResult();
                model.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEntName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwork = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();

        jLabel1.setText("Field Level Officer Child Care");

        jLabel2.setText("Enterprise");

        lblEntName.setText("Ent Name");

        tblwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Patient Age", "Disease", "Reciever", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblwork);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblEntName)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(238, 238, 238)
                        .addComponent(btnProceed)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblEntName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnProceed))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        int selectedRow = tblwork.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WelfareFLOWorkRequest request = (WelfareFLOWorkRequest)tblwork.getValueAt(selectedRow, 0);

        ProcessFLOJPanel processFLOChildJPanel = new ProcessFLOJPanel(userProcessContainer, request,(WelfareOrganization)organization,account,enterprise);
        userProcessContainer.add("processFLOChildJPanel", processFLOChildJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTable tblwork;
    // End of variables declaration//GEN-END:variables
}
