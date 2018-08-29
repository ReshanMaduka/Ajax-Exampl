/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ranjith Suranga
 */
public class Main extends javax.swing.JFrame {

    private boolean playTitle = false;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();

        // Hiding elements
//        lblLogo.setVisible(false);
//        lblTitle.setVisible(false);
//        lblCopyright.setVisible(false);
//        pnlMenu.setVisible(false);
        // Setting size
        setSize(850, 600);

        // Centering the form
        setLocationRelativeTo(null);

        // Setting frame icon
        ImageIcon frameIcon = new ImageIcon(this.getClass().getResource("/lk/ijse/pos/asset/frame_icon.png"));
        this.setIconImage(frameIcon.getImage());

        // Setting background color to white
        this.getContentPane().setBackground(Color.WHITE);

//        handleAnimation();
        initMenuItems(this);
        
    }

    private void initMenuItems(Container container) {

        for (Component cmp : container.getComponents()) {

            if (cmp.getName() != null && cmp.getName().equals("mnItem")) {

                initMenuEvents((Container) cmp);

                cmp.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Container cnt = (Container) cmp;

                        for (Component lbl : cnt.getComponents()) {
                            if (lbl.getName() != null) {
                                JLabel lblIcon = (JLabel) lbl;
                                ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/pos/asset/" + lblIcon.getName() + "_2x.png"));
                                lblIcon.setIcon(icon);
                            } else {
                                JLabel lblIcon = (JLabel) lbl;
                                lblIcon.setForeground(new Color(0xFF0033));
                            }
                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        Container cnt = (Container) cmp;
                        for (Component lbl : cnt.getComponents()) {
                            if (lbl.getName() != null) {
                                JLabel lblIcon = (JLabel) lbl;
                                ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/pos/asset/" + lblIcon.getName() + ".png"));
                                lblIcon.setIcon(icon);
                            } else {
                                JLabel lblIcon = (JLabel) lbl;
                                lblIcon.setForeground(Color.BLACK);
                            }
                        }
                    }

                });
            }

            if (cmp instanceof Container) {
                initMenuItems((Container) cmp);
            }
        }

    }

    private void initMenuEvents(Container container) {

        class SuraMouseAdapter extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                switch (getMenuItemIndex(e.getSource())) {
                    case 1:
                        ManageCustomerForm frmManageCustomers = new ManageCustomerForm();
                        frmManageCustomers.setVisible(true);
                        break;
                    case 2:                       
                        break;
                    case 3:
                        PlaceOrderForm frmPlaceOrder = new PlaceOrderForm();
                        frmPlaceOrder.setVisible(true);
                        break;
                    case 4:
                        break;
                }

            }

        }

        container.addMouseListener(new SuraMouseAdapter());

//        for (Component cmp : container.getComponents()) {
//            //cmp.addMouseListener(new SuraMouseAdapter());
//        }
    }

    private int getMenuItemIndex(Object source) {

        JLabel lbl = null;

        if (source instanceof JLabel && ((JLabel) source).getName() == null) {
            // This is probability what we are looking for
            lbl = (JLabel) source;
        } else {
            // If that is not the case, it should be the icon label or jpanel
            JPanel pnlContainer = (source instanceof JPanel) ? (JPanel) source : (JPanel) ((JLabel) source).getParent();

            for (Component cmp : pnlContainer.getComponents()) {
                if (cmp instanceof JLabel && ((JLabel) cmp).getText() != null) {
                    lbl = (JLabel) cmp;
                    break;
                }
            }
        }

        if (lbl != null) {
            switch (lbl.getText()) {
                case "Manage Customers":
                    return 1;
                case "Manage Items":
                    return 2;
                case "Place Orders":
                    return 3;
                case "Reports":
                    return 4;
                case "System Settings":
                    return 5;
                default:
                    return -1;
            }
        } else {
            return -1;
        }

    }

    private void handleAnimation() {

        // Centering the image
        Point pntLogo = new Point();
        pntLogo.x = (this.getWidth() - lblLogo.getWidth()) / 2;
        pntLogo.y = (this.getHeight() - lblLogo.getHeight()) / 2;
        pntLogo.y -= 20;
        lblLogo.setLocation(pntLogo);

        // Changing location of title
        lblTitle.setLocation(this.getWidth() - 100, 0);
        lblCopyright.setLocation(this.getWidth() - 100, 0);

        // Showing image
        lblLogo.setVisible(true);

        Timer tmrMover = new Timer(10, (ActionEvent e) -> {
            Point pntLogo1 = lblLogo.getLocation();
            if (pntLogo1.y > 100) {
                pntLogo1.y -= 3;
            } else {
                pntLogo1.y = 100;
                if (pntLogo1.x > 30) {
                    pntLogo1.x -= 3;
                } else {
                    pntLogo1.x = 30;
                    playTitle = true;
                }
            }
            lblLogo.setLocation(pntLogo1);
            if (playTitle) {
                Point pntTitle = lblTitle.getLocation();
                pntTitle.y = pntLogo1.y + 5;
                if (pntTitle.x > 530) {
                    pntTitle.x -= 10;
                } else {
                    pntTitle.x = 530;
                    pnlMenu.setVisible(true);
                }
                lblTitle.setLocation(pntTitle);
                lblTitle.setVisible(true);
                lblCopyright.setLocation(pntTitle.x, pntTitle.y + lblTitle.getHeight() + 5);
                lblCopyright.setVisible(true);
            }
        });

        Thread thrMover = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            tmrMover.start();
        });

        thrMover.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnlManageEmployee = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IJSE RMI POS - 2017");
        setResizable(false);
        getContentPane().setLayout(null);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/ijse-logo.gif"))); // NOI18N
        getContentPane().add(lblLogo);
        lblLogo.setBounds(40, 130, 460, 100);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setText("<html>Modern <span style=\"color: red;\">P</span>O<span style=\"color: red;\">S</span></html>");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(540, 130, 260, 50);

        lblCopyright.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCopyright.setText("Copyright © 2018");
        getContentPane().add(lblCopyright);
        lblCopyright.setBounds(540, 190, 190, 26);

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        pnlManageEmployee.setBackground(new java.awt.Color(0, 153, 204));
        pnlManageEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlManageEmployee.setName("mnItem"); // NOI18N
        pnlManageEmployee.setOpaque(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/manage_employees.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setName("manage_employees"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Manage Customers");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlManageEmployeeLayout = new javax.swing.GroupLayout(pnlManageEmployee);
        pnlManageEmployee.setLayout(pnlManageEmployeeLayout);
        pnlManageEmployeeLayout.setHorizontalGroup(
            pnlManageEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageEmployeeLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlManageEmployeeLayout.setVerticalGroup(
            pnlManageEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageEmployeeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(0, 0, 0))
        );

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setName("mnItem"); // NOI18N
        jPanel1.setOpaque(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/manage_paysheets.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setName("manage_paysheets"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Manage Items");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(0, 0, 0))
        );

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setName("mnItem"); // NOI18N
        jPanel2.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/create_paysheets.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setName("create_paysheets"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Place Orders");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(0, 0, 0))
        );

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setName("mnItem"); // NOI18N
        jPanel3.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reports");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/reports.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setName("reports"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel9))
        );

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setName("mnItem"); // NOI18N
        jPanel4.setOpaque(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/pos/asset/system_settings.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setName("system_settings"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("System Settings");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu);
        pnlMenu.setBounds(30, 280, 760, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlManageEmployee;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
