/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.BLO;

import Business.EcoSystem;
import Business.Enterprise.WelfareEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class WelfareBLOWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelfareBLOWorkRequestJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system; 
    WelfareEnterprise enterprise;
    Organization organization;
    UserAccount account;
    Network network;
    public WelfareBLOWorkRequestJPanel(JPanel userProcessContainer, WelfareEnterprise enterprise, Organization organization,EcoSystem system, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        this.organization=organization;
        this.account= account;
        lblEntName.setText(enterprise.getName());
        network = GetNetwork();
    }
    private Network GetNetwork(){
        Network thisNetwork = null;
        for(Network net: system.getNetworkList()){
            for(WelfareEnterprise wel : net.getEnterpriseDirectory().getWelfareEnterpriseList()){
                if(enterprise.equals(wel)){
                    thisNetwork= net;
                }
            }
        }
        return thisNetwork;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEntName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblwork = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();

        lblEntName.setText("Ent Name");

        tblwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Reciever", "Result"
            }
        ));
        jScrollPane1.setViewportView(tblwork);

        jLabel2.setText("Enterprise");

        jLabel1.setText("Block Level Officer Work Request");

        jButton1.setText("<<Back");

        jButton2.setText("Assign To Me");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(lblEntName)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(74, 74, 74)
                            .addComponent(jButton2)
                            .addGap(64, 64, 64)
                            .addComponent(btnProceed))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
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
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnProceed))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        ProcessBLOWorkRequestJPanel processBLOWorkRequestJPanel = new ProcessBLOWorkRequestJPanel(userProcessContainer, (WelfareOrganization)organization,account,enterprise,network);
        userProcessContainer.add("processBLOWorkRequestJPanel", processBLOWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProceedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTable tblwork;
    // End of variables declaration//GEN-END:variables
}
