
import com.mysql.jdbc.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Alan, David, Jack, Jinn
 */
public class Login extends javax.swing.JFrame {

    String name, type, password, id;
    Connection con = null;
    String host = "jdbc:mysql://199.195.214.108/ca314project";
    //String host = "jdbc:mysql://localhost/ca314project";
    private String adminU = "college";
    private String adminP = "collegeproject";
    //private String adminU = "root";
    //private String adminP = "root";
    
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private SecureRandom random = new SecureRandom();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        passwordText.addKeyListener(new KeyAdapter()
        {       
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    checkLogin();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        userNameText = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(300, 150, 777, 532));
        setMaximumSize(new java.awt.Dimension(777, 532));
        setMinimumSize(new java.awt.Dimension(777, 532));
        setPreferredSize(new java.awt.Dimension(777, 532));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLocation(new java.awt.Point(300, 150));
        jPanel1.setMaximumSize(new java.awt.Dimension(777, 532));
        jPanel1.setMinimumSize(new java.awt.Dimension(777, 532));
        jPanel1.setSize(new java.awt.Dimension(777, 532));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 840, 80);

        UserNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserNameLabel.setText("USERNAME");
        jPanel1.add(UserNameLabel);
        UserNameLabel.setBounds(360, 210, 85, 20);
        jPanel1.add(userNameText);
        userNameText.setBounds(310, 240, 190, 28);

        PasswordLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("PASSWORD");
        jPanel1.add(PasswordLabel);
        PasswordLabel.setBounds(360, 290, 90, 20);
        jPanel1.add(passwordText);
        passwordText.setBounds(310, 320, 190, 28);

        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LoginButton.jpg"))); // NOI18N
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LoginButton);
        LoginButton.setBounds(340, 360, 140, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(777, 532));
        jLabel2.setMinimumSize(new java.awt.Dimension(777, 532));
        jLabel2.setPreferredSize(new java.awt.Dimension(777, 532));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 60, 800, 510);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setup() {
        openConnect();
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

    private void checkLogin() {
        try {
            name = this.userNameText.getText();
            password = this.passwordText.getText();
            int size = 0;

            stmt = con.prepareStatement("select * from users where username = ? "
                    + "and password = ? ");

            stmt.setString(1, name);
            stmt.setString(2, password);

            stmt.executeQuery();
            rs = stmt.getResultSet();

            //if (rs.next() == false) {
            //    JOptionPane.showMessageDialog(this, "Password and Username Combination Incorrect",
            //            "Error", JOptionPane.ERROR_MESSAGE);
            //} else {
            while (rs.next()) {
                name = rs.getString("username");
                type = rs.getString("type");
                password = rs.getString("password");
                id = rs.getString("id");

                if (type.equals("Admin")) {
                    AdminMenu admin = new AdminMenu();
                    admin.setVisible(true);
                    setVisible(false);
                    closeConnect();
                    break;
                } else if (type.equals("Doctor")) {
                    DoctorMenu doctor = new DoctorMenu();
                    doctor.setVisible(true);
                    setVisible(false);
                    closeConnect();
                    break;
                } else if (type.equals("Nurse")) {
                    NurseMenu nurse = new NurseMenu();
                    nurse.setVisible(true);
                    setVisible(false);
                    closeConnect();
                    break;
                }
            }
            //}

        } catch (Exception e) {
            System.out.println("Can not get values");
        }
    }

    public String rand() {
        return new BigInteger(130, random).toString(32);
    }
    
    private void Initialise(){
        try {
            name = "ADMIN";
            type = "Admin";
            password = "admin";
            
            stmt = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
            
            stmt.setString(1,name);
            stmt.setString(2,type);
            stmt.setString(3,password);
            stmt.setString(4,rand());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("was not added");
            System.out.println(rand());
        }
    }
   
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        //Initialise();
        checkLogin();
    }//GEN-LAST:event_LoginButtonActionPerformed
        
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField userNameText;
    // End of variables declaration//GEN-END:variables
}
