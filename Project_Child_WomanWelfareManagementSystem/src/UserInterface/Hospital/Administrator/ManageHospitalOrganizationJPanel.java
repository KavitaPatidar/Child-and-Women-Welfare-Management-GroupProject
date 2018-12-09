/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Administrator;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Logger;
import Business.Organization.EducationOrganization;
import Business.Organization.HospitalOrganization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kavit
 */
public class ManageHospitalOrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageHospitalOrganization
     */
    JPanel container;
    HospitalEnterprise enterprise;
    private EcoSystem ecosystem;
    public ManageHospitalOrganizationJPanel(JPanel container, EcoSystem ecosystem, HospitalEnterprise enterprise) {
        initComponents();
        this.ecosystem = ecosystem;
        this.container = container;
        this.enterprise =  enterprise;
        populateTable();
        populateCombo();
    }
    public void populateTable(){
        try{
        DefaultTableModel model = (DefaultTableModel) tblOrganization.getModel();
        model.setRowCount(0);
        for(HospitalOrganization organization : enterprise.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            if(!organization.getName().equals("Admin Organization"))
            model.addRow(row);
        }
    }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    private void populateCombo(){
        try{
        ddlOrgType.removeAllItems();
        for (HospitalOrganization.Type type : HospitalOrganization.Type.values()){
            if (!type.getValue().equals(HospitalOrganization.Type.Admin.getValue()))
                ddlOrgType.addItem(type);
        }
    }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
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

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ddlOrgType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganization = new javax.swing.JTable();
        bbtnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Organization Type");

        ddlOrgType.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ddlOrgType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ddlOrgType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlOrgTypeActionPerformed(evt);
            }
        });

        tblOrganization.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tblOrganization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization ID", "Organization Namel"
            }
        ));
        jScrollPane1.setViewportView(tblOrganization);

        bbtnAdd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        bbtnAdd.setText("Add Organization");
        bbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbtnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Manage Hospital Organization");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnBack))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ddlOrgType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bbtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ddlOrgType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(bbtnAdd))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try{
        container.remove(this);
        CardLayout layout=(CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    
    private void bbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbtnAddActionPerformed
        boolean flag=true;
        try{
          
        String type = ddlOrgType.getSelectedItem().toString();
        type = type.concat(" Organization");
        for(HospitalOrganization hosOrg : enterprise.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
            if(hosOrg.getName().equals(type)){
                flag= false;
            }
        }
        if(flag)
        {
        HospitalOrganization ed= enterprise.getHospitalOrganizationDirectory().createHospitalOrganization(type);
        ed.setName(type);
        Logger.getInstance().writeLogs((type + " Organization created successfully"));
        JOptionPane.showMessageDialog(null, "Organization Created Successfully");
        populateTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Organization Already Created. Try adding other");
        }                
    }//GEN-LAST:event_bbtnAddActionPerformed
           catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }
    private void ddlOrgTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlOrgTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlOrgTypeActionPerformed
            
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbtnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox ddlOrgType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrganization;
    // End of variables declaration//GEN-END:variables
}
