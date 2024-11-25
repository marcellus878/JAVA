import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    public register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 754));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(135, 128, 110, 28);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("EMAIL ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(135, 184, 140, 28);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(135, 309, 150, 28);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(343, 129, 190, 34);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(343, 185, 190, 30);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(343, 310, 190, 30);

        jButton1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton1.setText("SIGN UP");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 380, 220, 41);

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel4.setText("NEW REGISTER");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 30, 300, 47);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("PHONE NUMBER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(135, 250, 200, 28);

        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        getContentPane().add(jTextField4);
        jTextField4.setBounds(343, 245, 190, 30);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String password = jTextField3.getText();
        String phone = jTextField4.getText();

        // Validate input
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/UserRegistrationDB", "root", "Janet_88");
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO register (name, email, password, phone) VALUES (?, ?, ?, ?)")) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registration successful!");
            this.setVisible(false);
            new login().setVisible(true);

        } catch (SQLException e) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new register().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
}