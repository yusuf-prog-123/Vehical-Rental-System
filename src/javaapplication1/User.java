/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YUSUF IFTHIKAR
 */
public class User extends javax.swing.JFrame {
    
    private static final String username="root";
    private static final String password="root";
    private static final String dataConn="jdbc:mysql://localhost:3306/vehicalrental";
    
    
    Connection sqlConnUser=null;
    //For Rental Tab
    PreparedStatement pstUser=null,pstUser1=null,pstUser2=null,pstUser3=null,pstUser4=null;
    ResultSet rsUser=null,rsUser1=null;
    //For Return tab
    PreparedStatement pstUser5=null,pstUser6=null,pstUser7=null,pstUser8=null,pstUser9=null;
    ResultSet rsUser2=null,rsUser3=null;
    

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        
        LoadCategory();
        returnedvehitable();
        txtdate.setDateFormatString("yyyy/MM/dd");
        txtdue.setDateFormatString("yyyy/MM/dd");
        
       /*cusNICtxt.setEnabled(false);
        txtdate.setEnabled(false);
        txtdue.setEnabled(false);
        feetxt.setEnabled(false);*/ 
        
    }
    
    
    //Return Tab table
    
     public void returnedvehitable(){
    
        int colcount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnUser=DriverManager.getConnection(dataConn,username,password);
            pstUser9=sqlConnUser.prepareStatement("select * from returnvehi");
            /*executes the prepared statement and retrieves the result 
            set into the rs variable. The result set contains the rows that match 
            the criteria defined in the SQL query.*/
            rsUser3=pstUser9.executeQuery();
            
            //etrieves metadata about the result set, including the number of columns, which is stored in colcount
            ResultSetMetaData rd=(ResultSetMetaData) rsUser3.getMetaData();
            colcount=rd.getColumnCount();
            
            // gets the model of a JTable (presumably named "jTable1") 
            //and assigns it to the df variable. This model will be used to manage the table's data.
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            
            //Clears existing rows from the table: df.setRowCount(0); is used to clear the existing data in the table.
            df.setRowCount(0);//Set Row count if not when updated it will show another copy of the entire dataagain inside the tbale
            
            /*Populates the table with retrieved data: A while loop iterates through the rows of the result set (rsUser3) and 
            retrieves data for each column, adding it to a Vector (v2). The Vector represents a row of data, and each column's data is added 
            to the v2 vector. Finally, the v2 vector is added to the table model (df), which populates the JTable with the retrieved data.*/
            while (rsUser3.next()){
                Vector v2=new Vector();
                for(int i=1;i<colcount;i++){
                    v2.add(rsUser3.getString("CarNo"));
                    v2.add(rsUser3.getString("CustomerID"));
                    v2.add(rsUser3.getString("due_date"));
                    v2.add(rsUser3.getString("elap"));
                    v2.add(rsUser3.getString("fine"));
                }
//Finally, the v2 vector is added to the table model (df), which populates the JTable with the retrieved data.
                df.addRow(v2);
            }
  
        } catch (Exception e) {
            
            
        }

    }

    //Renatl Tab Load Cataogoary into drop down box
    /*The LoadCategory method appears to be designed to populate a combo box (presumably named combocarID) 
     with data retrieved from a MySQL database table named "vehicalReg." Here's a breakdown of what this method does:*/
    public void LoadCategory() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnUser=DriverManager.getConnection(dataConn,username,password);
            pstUser = sqlConnUser.prepareStatement("SELECT * FROM vehicalReg");
            rsUser = pstUser.executeQuery();
            combocarID.removeAllItems();//Clears existing items from the combo box

            while (rsUser.next()) {
                combocarID.addItem(rsUser.getString("CarNo"));
                /*. This effectively populates the combo box with the "CarNo" values from the "vehicalReg" table*/
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cusNICtxt = new javax.swing.JTextField();
        feetxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtdue = new com.toedter.calendar.JDateChooser();
        combocarID = new javax.swing.JComboBox<>();
        Statusetxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vehiIDreturntxt = new javax.swing.JTextField();
        NICtxt = new javax.swing.JTextField();
        datetxtt = new javax.swing.JTextField();
        elaptxt = new javax.swing.JTextField();
        finetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        returnokbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(153, 255, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Customer NIC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Vehicale-ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fee");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Due Date");

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setText("RENT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combocarID.setToolTipText("");
        combocarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cusNICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtdue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combocarID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(Statusetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusNICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combocarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Statusetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RENTAL", jPanel1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Vehicale-ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Customer NIC");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Due Date");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Days Elapsed");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Fine");

        vehiIDreturntxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vehiIDreturntxtKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicale-ID", "CustNIC", "Due-Date", "NoofDaysElapsed", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        returnokbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        returnokbtn.setText("OK");
        returnokbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnokbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vehiIDreturntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datetxtt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elaptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(returnokbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vehiIDreturntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnokbtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(NICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(datetxtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(elaptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(finetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("RETURN", jPanel2);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 3, 18)); // NOI18N
        jLabel1.setText("Rental-Employee Interface");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("LogOut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//cancel button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        loogin l2=new loogin();
        l2.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

//Function used to update weather the vehicale is available or Not on Status txt
    /*The combocarIDActionPerformed method appears to be an event handler for an 
    action event triggered when an item in a combo box (presumably named combocarID) is selected*/
    private void combocarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocarIDActionPerformed
        // TODO add your handling code here:
        String car_id = combocarID.getSelectedItem().toString();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnUser=DriverManager.getConnection(dataConn,username,password);
            pstUser1 = sqlConnUser.prepareStatement("SELECT * FROM vehicalReg where carNo = ?");
            pstUser1.setString(1, car_id);
            rsUser1 = pstUser1.executeQuery();
            

            if (!rsUser1.next())
            {
                JOptionPane.showMessageDialog(null, "Vehicale No not Found");
            }
            else {
                String ava = rsUser1.getString("Availability");
                System.out.println("Availability: [" + ava + "]"); // Debugging statement
                Statusetxt.setText(ava.trim());

                if ("Yes".equals(ava))//components disabeld
                {
                    cusNICtxt.setEnabled(true);
                    feetxt.setEnabled(true);
                    txtdate.setEnabled(true);
                    txtdue.setEnabled(true);
                }
                else if("No".equals(ava))//components disabled
                {
                    cusNICtxt.setEnabled(false);
                    txtdate.setEnabled(false);
                    txtdue.setEnabled(false);
                    feetxt.setEnabled(false);
                }

            }

        } catch (Exception ex) {

        }

    }//GEN-LAST:event_combocarIDActionPerformed
//rent button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String car_id = combocarID.getSelectedItem().toString();
         String custNIC = cusNICtxt.getText();
         String fee = feetxt.getText();
         
         SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
         String date = Date_Format.format(txtdate.getDate());
         
         SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
         String duedate = Date_Format1.format(txtdue.getDate());
         
         if (custNIC.length() != 12) {
            JOptionPane.showMessageDialog(this, "NIC must be exactly 12 characters long.");
        } else {
         
         
            try {

               Class.forName("com.mysql.jdbc.Driver");
               sqlConnUser=DriverManager.getConnection(dataConn,username,password);

               //prepares an SQL statement for inserting a new rental record into the "rental" table with values for "CustomerID," "CarNo," "fee," "date," and "due.
               pstUser3 = sqlConnUser.prepareStatement("insert into rental  (CustomerID,CarNo,fee,date,due)values(?,?,?,?,?)");
               pstUser3.setString(1, custNIC);
               pstUser3.setString(2, car_id);
               pstUser3.setString(3, fee);
               pstUser3.setString(4, date);
               pstUser3.setString(5, duedate);
               pstUser3.executeUpdate();


               //For updating the statustxt if the car is not avialable

               /*prepares an SQL statement to update the "Availability" column in the "vehicalReg" table to "No" for the selected car. 
               The selected car is specified as a parameter. The statement is executed with pstUser4.executeUpdate().*/
               pstUser4 = sqlConnUser.prepareStatement("update vehicalReg set Availability = 'No' where CarNo = ?");
               pstUser4.setString(1,car_id);
               pstUser4.executeUpdate();
               JOptionPane.showMessageDialog(this, "Sucsessfully Updated");


               cusNICtxt.setText("");
               feetxt.setText("");
               User use1=new User();
               use1.show();
               dispose();




           } catch (Exception e) {
           }
         }

    }//GEN-LAST:event_jButton2ActionPerformed
/*In summary, this event handler records a returned vehicle in the database, updates the availability status 
of the vehicle, deletes the corresponding rental record, and provides feedback to the user when the transaction is successfully 
completed.*/
    //return tab button ok
    private void returnokbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnokbtnActionPerformed
        // TODO add your handling code here:
           
        String vehi_id = vehiIDreturntxt.getText();
        String cusNIC = NICtxt.getText();
        String duedate = datetxtt.getText();
        String elped = elaptxt.getText();
        String fine = finetxt.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConnUser=DriverManager.getConnection(dataConn,username,password);
            /*prepares an SQL statement for inserting a new record into the "returnvehi" table 
            with values for "CarNo," "CustomerID," "due_date," "elap," and "fine."*/
            pstUser6 = sqlConnUser.prepareStatement("insert into returnvehi (CarNo,CustomerID,due_date,elap,fine)values(?,?,?,?,?)");
            pstUser6.setString(1,vehi_id);
            pstUser6.setString(2,cusNIC);
            pstUser6.setString(3,duedate); 
            pstUser6.setString(4,elped); 
            pstUser6.setString(5,fine); 
            pstUser6.executeUpdate();
            
            //check yes or No and act accordingly
            /* prepares an SQL statement to update the "Availability" column in the "vehicalReg" table 
            to "Yes" for the selected vehicle. The selected vehicle is specified as a parameter.*/
            pstUser7 = sqlConnUser.prepareStatement("update vehicalReg set Availability = 'Yes' where CarNo = ?  ");
            pstUser7.setString(1, vehi_id);
            pstUser7.executeUpdate();
            
            /*prepares an SQL statement to delete the rental record associated with the returned vehicle. 
            The selected vehicle is specified as a parameter. The statement is executed with */
            pstUser8=sqlConnUser.prepareStatement("Delete from rental where CarNo = ?");
            pstUser8.setString(1, vehi_id);
            pstUser8.executeUpdate();
            //updates the Jtable
            returnedvehitable();
            
            JOptionPane.showMessageDialog(this, "Car Returend Inventory Updated Saved");
            vehiIDreturntxt.setText("");
            NICtxt.setText("");
            datetxtt.setText("");
            elaptxt.setText("");
            finetxt.setText("");
            
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_returnokbtnActionPerformed
//When the text box of vehical-ID//Return Tab
    private void vehiIDreturntxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vehiIDreturntxtKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                sqlConnUser=DriverManager.getConnection(dataConn,username,password);
                
                
                /*DATEDIFF(NOW(), due) as elap:It calculates the difference in days between
                the current date and the "due" date for each row. The result of this calculation is given the alias "elap."*/
                String vehi_id=vehiIDreturntxt.getText();
                pstUser5 = sqlConnUser.prepareStatement("select CustomerID,CarNo,due,DATEDIFF(NOW(),due) as elap from rental where carNo = ?");
                pstUser5.setString(1,vehi_id);
                rsUser2=pstUser5.executeQuery();
                
                if(rsUser2.next()==false)
                {
                    JOptionPane.showMessageDialog(null, "Vehical No not Found");
                }
                else{
                
                   String customID = rsUser2.getString("CustomerID");          
                   NICtxt.setText(customID.trim());
                   
                   String duet = rsUser2.getString("due");          
                   datetxtt.setText(duet.trim());
                   
                  String elp = rsUser2.getString("elap");
                  int elaped = Integer.parseInt(elp);
                  
                  if(elaped>0){
                    elaptxt.setText(elp);
                    int fine = elaped * 2000;
                    finetxt.setText(String.valueOf(fine)); 
                  }
                  else{
                     elaptxt.setText("0");
                     finetxt.setText("0");  
                  }
                  
                }

            } catch (Exception e) {
            }
            
        
        }  
    }//GEN-LAST:event_vehiIDreturntxtKeyPressed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NICtxt;
    private javax.swing.JTextField Statusetxt;
    private javax.swing.JComboBox<String> combocarID;
    private javax.swing.JTextField cusNICtxt;
    private javax.swing.JTextField datetxtt;
    private javax.swing.JTextField elaptxt;
    private javax.swing.JTextField feetxt;
    private javax.swing.JTextField finetxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnokbtn;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdue;
    private javax.swing.JTextField vehiIDreturntxt;
    // End of variables declaration//GEN-END:variables
}
