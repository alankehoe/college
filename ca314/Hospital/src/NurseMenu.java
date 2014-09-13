
import com.mysql.jdbc.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alan, David, Jack, Jinn
 */
public class NurseMenu extends javax.swing.JFrame {

    Connection con = null;
    String host = "jdbc:mysql://199.195.214.108/ca314project";
    //String host = "jdbc:mysql://localhost/ca314project";
    private String adminU = "college";
    private String adminP = "collegeproject";
    //private String adminU = "root";
    //private String adminP = "root";
    
    PreparedStatement stmt = null;
    private SecureRandom random = new SecureRandom();
    
    String name, gender, id, notes;
    double age, weight, height, highTemp, lowTemp, highBPM, lowBPM, highBP, lowBP;
    double highBG, lowBG;
    
    public NurseMenu() {
        initComponents();
    }
    
        
    public void openConnect() {
        try {
            con = (Connection) DriverManager.getConnection(host, adminU, adminP);
            System.out.println("Connection Made");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ""
                    + "The Server Is Offline, Contact Your Administrator If The Matter Persists",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeConnect() {
        try {
            con.close();
            System.out.println("Connection Closed");
        } catch (Exception e) {}
    }
    
    public String rand() {
        return new BigInteger(130, random).toString(32);
    }
    
    public void addPatient() {
        try {
            openConnect();

            name = patientFirstName.getText() + " " + patientSecondName.getText();
            
            String ageTmp = ageText.getText();
            if(ageTmp.equals(""))
                age = 0;
            else
                age = Double.parseDouble(ageTmp);
            
            gender = (String) genderText.getSelectedItem();
            
            String weightTmp = weightText.getText();
            if(weightTmp.equals(""))
                    weight = 0;
            else
                weight = Double.parseDouble(weightTmp);
            
            String heightTmp = heightText.getText();
            if(heightTmp.equals(""))
                height = 0;
            else
                height = Double.parseDouble(heightTmp);
            
            String highTempTmp = highTempText.getText();
            if(highTempTmp.equals(""))
                highTemp = 0;
            else
                highTemp = Double.parseDouble(highTempTmp);
            
            String lowTempTmp = lowTempText.getText();
            if(lowTempTmp.equals(""))
                lowTemp = 0;
            else
                lowTemp = Double.parseDouble(lowTempTmp);
            
            String highBPMTmp = highBPMText.getText();
            if(highBPMTmp.equals(""))
                highBPM = 0;
            else
                highBPM = Double.parseDouble(highBPMTmp);
            
            String lowBPMTmp = lowBPMText.getText();
            if(lowBPMTmp.equals(""))
                lowBPM = 0;
            else
                lowBPM = Double.parseDouble(lowBPMTmp);
            
            String highBPTmp = highBPText.getText();
            if(highBPTmp.equals(""))
                highBP = 0;
            else
                highBP = Double.parseDouble(highBPTmp);
            
            String lowBPTmp = lowBPText.getText();
            if(lowBPTmp.equals(""))
                lowBP = 0;
            else
                lowBP = Double.parseDouble(lowBPTmp);
            
            String highBGTmp = highBGText.getText();
            if(highBGTmp.equals(""))
                highBG = 0;
            else
                highBG = Double.parseDouble(highBGTmp);
            
            String lowBGTmp = lowBGText.getText();
            if(lowBGTmp.equals(""))
                lowBG = 0;
            else
                lowBG = Double.parseDouble(lowBGTmp);
            
            id = rand();

            stmt = con.prepareStatement("INSERT INTO patients VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, name);
            stmt.setDouble(2, age);
            stmt.setDouble(3, weight);
            stmt.setDouble(4, height);
            stmt.setString(5, gender);
            stmt.setDouble(6, highTemp);
            stmt.setDouble(7, lowTemp);
            stmt.setDouble(8, highBPM);
            stmt.setDouble(9, lowBPM);
            stmt.setDouble(10, highBP);
            stmt.setDouble(11, lowBP);
            stmt.setDouble(12, highBG);
            stmt.setDouble(13, lowBG);
            stmt.setString(14, "");
            stmt.setString(15, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient " + name + " Was added to the database.");
            closeConnect();

        } catch (SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
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

        firstNameLabel = new javax.swing.JLabel();
        genderText = new javax.swing.JComboBox();
        patientFirstName = new javax.swing.JTextField();
        heartRateHighLabel1 = new javax.swing.JLabel();
        secondNameLabel = new javax.swing.JLabel();
        heightText = new javax.swing.JTextField();
        weightText = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        lowBPText = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        gluecoseLimit = new javax.swing.JLabel();
        lowTempText = new javax.swing.JTextField();
        ageText = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        highBPText = new javax.swing.JTextField();
        patientSecondName = new javax.swing.JTextField();
        lowBGText = new javax.swing.JTextField();
        highBGText = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        lowBPMText = new javax.swing.JTextField();
        bloodPressureLabel = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        heightLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        highTempText = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        TempLabel = new javax.swing.JLabel();
        highBPMText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PatientMonitoringSystem - Nurse");
        setLocation(new java.awt.Point(300, 150));
        setMaximumSize(new java.awt.Dimension(777, 532));
        setPreferredSize(new java.awt.Dimension(777, 532));
        setResizable(false);
        setSize(new java.awt.Dimension(777, 532));
        getContentPane().setLayout(null);

        firstNameLabel.setText("First Name");
        getContentPane().add(firstNameLabel);
        firstNameLabel.setBounds(100, 130, 80, 16);

        genderText.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        getContentPane().add(genderText);
        genderText.setBounds(100, 330, 140, 27);
        getContentPane().add(patientFirstName);
        patientFirstName.setBounds(100, 150, 140, 28);

        heartRateHighLabel1.setText("Heart Rate High / Low Limits (BPM)");
        getContentPane().add(heartRateHighLabel1);
        heartRateHighLabel1.setBounds(350, 190, 230, 16);

        secondNameLabel.setText("Second Name");
        getContentPane().add(secondNameLabel);
        secondNameLabel.setBounds(100, 190, 90, 16);
        getContentPane().add(heightText);
        heightText.setBounds(100, 450, 140, 28);
        getContentPane().add(weightText);
        weightText.setBounds(100, 390, 140, 28);

        genderLabel.setText("Gender");
        getContentPane().add(genderLabel);
        genderLabel.setBounds(100, 310, 110, 16);

        lowBPText.setEditable(false);
        getContentPane().add(lowBPText);
        lowBPText.setBounds(450, 270, 90, 28);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.jpg"))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(610, 450, 100, 40);

        gluecoseLimit.setText("Blood Gluecose High / Low Limits (mmol/l)");
        getContentPane().add(gluecoseLimit);
        gluecoseLimit.setBounds(350, 310, 290, 16);

        lowTempText.setEditable(false);
        getContentPane().add(lowTempText);
        lowTempText.setBounds(450, 150, 80, 28);
        getContentPane().add(ageText);
        ageText.setBounds(100, 270, 140, 28);

        title.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        title.setText("Enter New Patient Details");
        getContentPane().add(title);
        title.setBounds(280, 90, 230, 20);

        highBPText.setEditable(false);
        getContentPane().add(highBPText);
        highBPText.setBounds(350, 270, 80, 28);
        getContentPane().add(patientSecondName);
        patientSecondName.setBounds(100, 210, 140, 28);

        lowBGText.setEditable(false);
        getContentPane().add(lowBGText);
        lowBGText.setBounds(350, 330, 80, 28);

        highBGText.setEditable(false);
        getContentPane().add(highBGText);
        highBGText.setBounds(450, 330, 90, 28);

        submitButton.setText("Submit Details");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);
        submitButton.setBounds(450, 390, 130, 29);

        lowBPMText.setEditable(false);
        getContentPane().add(lowBPMText);
        lowBPMText.setBounds(450, 210, 84, 28);

        bloodPressureLabel.setText("Blood Pressure High / Low Limits");
        getContentPane().add(bloodPressureLabel);
        bloodPressureLabel.setBounds(350, 250, 220, 16);

        skipButton.setText("Monitor");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(skipButton);
        skipButton.setBounds(340, 390, 100, 29);

        heightLabel.setText("Height (CM)");
        getContentPane().add(heightLabel);
        heightLabel.setBounds(100, 430, 90, 16);

        weightLabel.setText("Weight (KG)");
        getContentPane().add(weightLabel);
        weightLabel.setBounds(100, 370, 80, 16);

        highTempText.setEditable(false);
        getContentPane().add(highTempText);
        highTempText.setBounds(350, 150, 80, 28);

        ageLabel.setText("Age");
        getContentPane().add(ageLabel);
        ageLabel.setBounds(100, 250, 24, 16);

        TempLabel.setText("Body Temprature High / Low Limits (°C)");
        getContentPane().add(TempLabel);
        TempLabel.setBounds(350, 130, 250, 16);

        highBPMText.setEditable(false);
        getContentPane().add(highBPMText);
        highBPMText.setBounds(350, 210, 80, 28);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/white.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 80, 680, 420);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BigBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 60, 780, 480);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 790, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        setVisible(false);
        DoctorMonitor doctor = new DoctorMonitor();
        doctor.setup();
        doctor.setVisible(true);
    }//GEN-LAST:event_skipButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        addPatient();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        setVisible(false);
        Login log = new Login();
        log.setup();
        log.setVisible(true);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DoctorMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TempLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageText;
    private javax.swing.JLabel bloodPressureLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JComboBox genderText;
    private javax.swing.JLabel gluecoseLimit;
    private javax.swing.JLabel heartRateHighLabel1;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightText;
    private javax.swing.JTextField highBGText;
    private javax.swing.JTextField highBPMText;
    private javax.swing.JTextField highBPText;
    private javax.swing.JTextField highTempText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lowBGText;
    private javax.swing.JTextField lowBPMText;
    private javax.swing.JTextField lowBPText;
    private javax.swing.JTextField lowTempText;
    private javax.swing.JTextField patientFirstName;
    private javax.swing.JTextField patientSecondName;
    private javax.swing.JLabel secondNameLabel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JTextField weightText;
    // End of variables declaration//GEN-END:variables
}
