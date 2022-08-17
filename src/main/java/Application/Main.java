/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Application;


import Views.JPanelBan;
import Views.JPanelNhanVien;
import Views.JPanelCombo;
import Views.PanelSanPham;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author LuongQuocBao
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    void showControl(JPanel view, JButton btn) {
        panel.removeAll();
        panel.add(view);
        panel.validate();
        btn.setBackground(Color.YELLOW);
    }

//    HoaDon guiDataHoaDon() {
//        int ma = 1;
//        for (int i = 0; i < _ServiceHoaDon.getlistHoaDon().size(); i++) {
//            ma++;            
//        }
//        Date date = new Date();
//        return new HoaDon(-1, "HD" + ma, date, 0, 1);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_SanPham = new javax.swing.JButton();
        btn_Combo = new javax.swing.JButton();
        btn_NhanVien = new javax.swing.JButton();
        btn_KhoaHoc = new javax.swing.JButton();
        btn_NguoiHoc = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_SanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_SanPham.setText("SẢN PHẨM");
        btn_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SanPhamActionPerformed(evt);
            }
        });

        btn_Combo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_Combo.setText("COMBO");
        btn_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ComboActionPerformed(evt);
            }
        });

        btn_NhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_NhanVien.setText("NHÂN VIÊN ");
        btn_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhanVienActionPerformed(evt);
            }
        });

        btn_KhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_KhoaHoc.setText("KHÓA HỌC");
        btn_KhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KhoaHocActionPerformed(evt);
            }
        });

        btn_NguoiHoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_NguoiHoc.setText("NGƯỜI HỌC");
        btn_NguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NguoiHocActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton6.setText("exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("Ban");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ban");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Combo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_KhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_NguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btn_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_Combo)
                        .addGap(36, 36, 36)
                        .addComponent(btn_NhanVien)
                        .addGap(34, 34, 34)
                        .addComponent(btn_KhoaHoc)
                        .addGap(34, 34, 34)
                        .addComponent(btn_NguoiHoc)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SanPhamActionPerformed
        showControl(new PanelSanPham(), btn_SanPham);
        btn_Combo.setBackground(Color.WHITE);
        btn_KhoaHoc.setBackground(Color.WHITE);
        btn_NguoiHoc.setBackground(Color.WHITE);
        btn_NhanVien.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_SanPhamActionPerformed

    private void btn_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ComboActionPerformed
        showControl(new JPanelCombo(), btn_Combo);
        btn_SanPham.setBackground(Color.WHITE);
        btn_KhoaHoc.setBackground(Color.WHITE);
        btn_NguoiHoc.setBackground(Color.WHITE);
        btn_NhanVien.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_ComboActionPerformed

    private void btn_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhanVienActionPerformed
        showControl(new PanelSanPham(), btn_NhanVien);
        btn_SanPham.setBackground(Color.WHITE);
        btn_KhoaHoc.setBackground(Color.WHITE);
        btn_NguoiHoc.setBackground(Color.WHITE);
        btn_Combo.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_NhanVienActionPerformed

    private void btn_KhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KhoaHocActionPerformed
        showControl(new PanelSanPham(), btn_KhoaHoc);
        btn_SanPham.setBackground(Color.WHITE);
        btn_Combo.setBackground(Color.WHITE);
        btn_NguoiHoc.setBackground(Color.WHITE);
        btn_NhanVien.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_KhoaHocActionPerformed

    private void btn_NguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NguoiHocActionPerformed
        showControl(new PanelSanPham(), btn_NguoiHoc);
        btn_SanPham.setBackground(Color.WHITE);
        btn_KhoaHoc.setBackground(Color.WHITE);
        btn_Combo.setBackground(Color.WHITE);
        btn_NhanVien.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_NguoiHocActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showControl(new JPanelBan(), jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showControl(new JPanelNhanVien(), jButton1);
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btn_Combo;
    private javax.swing.JButton btn_KhoaHoc;
    private javax.swing.JButton btn_NguoiHoc;
    private javax.swing.JButton btn_NhanVien;
    private javax.swing.JButton btn_SanPham;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
