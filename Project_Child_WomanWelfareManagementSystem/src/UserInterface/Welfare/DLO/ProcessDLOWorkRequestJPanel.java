/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Welfare.DLO;

import Business.Enterprise.WelfareEnterprise;
import Business.Organization.WelfareSLOOrganization;
import Business.Organization.WelfareOrganization;
import Business.Organization.WelfareOrganization.Type;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WelfareDLOWorkRequest;
import Business.WorkQueue.WelfareSLOWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ProcessDLOWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessDLOWorkRequestJPanel
     */
    JPanel userProcessContainer;
    WelfareDLOWorkRequest request;
    WelfareOrganization organization;
    UserAccount userAccount;
    WelfareEnterprise enterprise;
    public ProcessDLOWorkRequestJPanel(JPanel userProcessContainer, WelfareDLOWorkRequest request, WelfareOrganization organization,UserAccount userAccount, WelfareEnterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.organization = organization;
        this.userAccount = userAccount;
        this.enterprise=enterprise;
        populateOrgCombo();
    }
    private void populateOrgCombo(){
        ddlOrgType.removeAllItems();
        for(Type type : WelfareOrganization.Type.values()){
            if(!type.equals(WelfareOrganization.Type.Admin))
            ddlOrgType.addItem(type);
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
        txtMessage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ddlOrgType = new javax.swing.JComboBox();
        btnAssign = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();

        jLabel1.setText("Message");

        jLabel2.setText("Assign To");

        ddlOrgType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(40, 40, 40)
                        .addComponent(btnAssign))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMessage)
                            .addComponent(txtResult)
                            .addComponent(ddlOrgType, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlOrgType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign)
                    .addComponent(btnBack))
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        WelfareSLOWorkRequest sloRequest= null;
        String result = txtResult.getText();
        String message = txtMessage.getText();
        Type type =(Type) ddlOrgType.getSelectedItem();
        if(type.equals(WelfareOrganization.Type.SLO)){
            sloRequest = new WelfareSLOWorkRequest();
        }
        if(type.equals(WelfareOrganization.Type.BLO)){
            //request = new WelfareSLOWorkRequest();
        }
        if(type.equals(WelfareOrganization.Type.FLO)){
            //request = new WelfareSLOWorkRequest();
        }
        request.setTestResult(result);
        request.setResolveDate(new Date());
        request.setStatus("Completed");
        sloRequest.setMessage(message);
        sloRequest.setSender(userAccount);
        sloRequest.setStatus("Sent");
        
        WelfareOrganization org = null;
        for (WelfareOrganization organization : enterprise.getWelfareOrganizationDirectory().getWelfareOrganizationList()){
            if (organization instanceof WelfareSLOOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(sloRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(sloRequest);
        }
        
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WelfareDLOWorkRequestJPanel dwjp = (WelfareDLOWorkRequestJPanel) component;
        dwjp.PopulateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox ddlOrgType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
