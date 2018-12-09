/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hospital.Doctor;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Logger;
import Business.Network.Network;
import Business.Organization.HospitalDoctorOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HospitalDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kavit
 */
public class DoctorAssignedWorkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctoeAssignedWorkJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private HospitalEnterprise enterprise;
    private EcoSystem system;
    private Organization organization;
    Network network;
    public DoctorAssignedWorkJPanel(JPanel userProcessContainer, EcoSystem system, HospitalEnterprise enterprise, UserAccount account,Organization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.system=system;
        this.organization=organization;
        network = GetNetwork();
        populateTable();
        
    }
    private Network GetNetwork(){
        Network thisNetwork = null;
        for(Network net: system.getNetworkList()){
            for(HospitalEnterprise wel : net.getEnterpriseDirectory().getHospitalnterpriseList()){
                if(enterprise.equals(wel)){
                    thisNetwork= net;
                }
            }
        }
        return thisNetwork;
    }
    
     public void populateTable(){
         try{
            DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();

            model.setRowCount(0);
            HospitalDoctorOrganization hosDocOrg=new HospitalDoctorOrganization();
            for(HospitalEnterprise hos : network.getEnterpriseDirectory().getHospitalnterpriseList()){
                for(HospitalOrganization hosOrg : hos.getHospitalOrganizationDirectory().getHospitalOrganizationList()){
                    if(hosOrg instanceof HospitalDoctorOrganization)
                    hosDocOrg=(HospitalDoctorOrganization) hosOrg;
                }
            }
            for(WorkRequest request : hosDocOrg. getWorkQueue().getWorkRequestList()){

              Object[] row = new Object[8];
                row[0] = request;
                row[1] = request.getReceiver();
                row[2] = request.getStatus();

                Patient patient = ((HospitalDoctorWorkRequest)request).getPatient();
                //Remove this check during testing
                if(patient!=null){
                row[3] = patient.getName();
                row[4] = patient.getAge();
                row[5] = patient.getProblem();
                row[6] = patient.getServiceProvided();
                String result=((HospitalDoctorWorkRequest)request).getResult();
                row[7]= result == null ? "Waiting" : result;
                model.addRow(row);   
                }

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnRequestWork = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Assigned Work");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Patient Name", "Age", "Disease", "Service Provided", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        btnRequestWork.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnRequestWork.setText("Assign work");
        btnRequestWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestWorkActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(109, 109, 109)
                        .addComponent(btnRequestWork, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRequestWork)
                    .addComponent(btnBack))
                .addContainerGap(265, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestWorkActionPerformed
        try{
            
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!");
            return;
        }
        HospitalDoctorWorkRequest request = (HospitalDoctorWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
     
        request.setStatus("Processing");
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestWorkJPanel", new RequestWorkJPanel(userProcessContainer, system, enterprise, userAccount,organization,request,network));
        layout.next(userProcessContainer);
        }
        catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
        }
        
    }//GEN-LAST:event_btnRequestWorkActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try{
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
            catch(Exception ex){
            Logger.getInstance().exceptionLogs(ex);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestWork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
