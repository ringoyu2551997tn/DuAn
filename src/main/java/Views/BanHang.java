/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DomainModel.Ban;
import DomainModel.Hoadoinchitiet;
import DomainModel.Hoadon;
import DomainModel.Khuyenmai;
import Services.IServiceBan;
import Services.IServiceCombo;
import Services.IServiceSanPham;
import Services.ServiceBan;
import Services.ServiceCombo;
import Services.ServiceSanPham;
import Utilities.GetID;
import ViewModels.BanView;
import ViewModels.ComboView;
import ViewModels.SanPhamView;
import ViewModels.SelectedItems;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import repositories.ImplBangBan;
import repositories.ImplBangHoaDon;
import repositories.ImplBangHoaDonChiTiet;
import repositories.ImplBangKhuyenMai;
import repositories.ImplBangNhanVien;
import repositories.InterfaceBangBan;
import repositories.InterfaceBangHoaDon;
import repositories.InterfaceBangHoaDonChiTiet;
import repositories.InterfaceBangKhuyenMai;
import repositories.InterfaceBangNhanVien;

/**
 *
 * @author lucif
 */
public class BanHang extends javax.swing.JPanel {

    InterfaceBangBan daoBan = new ImplBangBan();
    InterfaceBangKhuyenMai daoKM = new ImplBangKhuyenMai();
    InterfaceBangHoaDon daoHD = new ImplBangHoaDon();
    InterfaceBangNhanVien daoNV = new ImplBangNhanVien();
    InterfaceBangHoaDonChiTiet daoHDCT = new ImplBangHoaDonChiTiet();
    IServiceBan svsBan = new ServiceBan();
    IServiceCombo svsCombo = new ServiceCombo();
    IServiceSanPham svsSP = new ServiceSanPham();
    List<SelectedItems> lstSelected = new ArrayList<>();
    List<Khuyenmai> lstKhuyenMai = new ArrayList<>();
    Locale locale = new Locale("vi", "VN");
    NumberFormat format = NumberFormat.getCurrencyInstance(locale);
    String selectedBan;
    JButton btn;
    GetID util = new GetID();
    long millis = System.currentTimeMillis();

    /**
     * Creates new form a
     */
    public BanHang() {
        initComponents();
        selectedBan = String.valueOf(daoBan.findById(0).getMaBan());
        format.setRoundingMode(RoundingMode.HALF_UP);
        setTableHeader();
        loadTableBan(svsBan.findByStatus(2), btn_allBan);
        loadTableSanPham(btn_cafe, 1);
        txt_tongTien.setEnabled(false);
        txt_tienPhaiTra.setEnabled(false);
        txt_tienThua.setEnabled(false);
        CbcKhuyenMai();
    }

    void removeColorBan() {
        btn_allBan.setBackground(Color.white);
        btn_banHD.setBackground(Color.white);
        btn_banTrong.setBackground(Color.white);
        btn_allBan.setForeground(Color.black);
        btn_banHD.setForeground(Color.black);
        btn_banTrong.setForeground(Color.black);
    }

    void removeColorListSP() {
        btn_cafe.setBackground(Color.white);
        btn_comBo.setBackground(Color.white);
        btn_doAn.setBackground(Color.white);
        btn_doUongKhac.setBackground(Color.white);
        btn_cafe.setForeground(Color.black);
        btn_comBo.setForeground(Color.black);
        btn_doAn.setForeground(Color.black);
        btn_doUongKhac.setForeground(Color.black);
    }

    void loadTableBan(List<BanView> bv, JButton btn) {
        DefaultTableModel tbl = (DefaultTableModel) tbl_ban.getModel();
        tbl.setRowCount(0);
        for (BanView x : bv) {
            tbl.addRow(new Object[]{
                x.getMaBan(),
                x.getTrangThai()==1?"Hoạt động":"Trống"
            });
        }
        removeColorBan();
        btn.setBackground(Color.darkGray);
        btn.setForeground(Color.white);

    }

    void loadForm() {
        double money = 0;
        for (SelectedItems x : lstSelected) {
            money = money + (x.getSoLuong() * x.getGiaTien());
        }
        txt_tongTien.setText(String.valueOf(money));
        Khuyenmai km = (Khuyenmai) cbc_maKhuyenMai.getSelectedItem();
        txt_tienPhaiTra.setText(String.valueOf(Double.parseDouble(txt_tongTien.getText())
                - (Double.parseDouble(txt_tongTien.getText()) * km.getChietKhau().doubleValue() / 100)));
        if (!txt_khachDua.getText().isBlank()) {
            txt_tienThua.setText(String.valueOf(Double.parseDouble(txt_khachDua.getText())
                    - (Double.parseDouble(txt_tienPhaiTra.getText()))));
        }
    }


    void loadTableSanPham(JButton btn, int type) {
        DefaultTableModel tbl = (DefaultTableModel) tbl_listSP.getModel();
        tbl.setRowCount(0);
        if (type == 0) {
            for (ComboView x : svsCombo.findAll()) {
                tbl.addRow(new Object[]{
                    x.getHInhAnh(),
                    x.getMaComBo(),
                    x.getTenComBo(),
                    x.getGiaTien(),
                    "Thêm"
                });
            }
        } else {
            for (SanPhamView x : svsSP.findByType(type)) {
                tbl.addRow(new Object[]{
                    x.getHinhAnh(),
                    x.getMaSanPham(),
                    x.getTenSanPham(),
                    x.getGiaTien(),
                    "Thêm"
                });
            }
        }
        removeColorListSP();
        tbl_listSP.getColumn("Thêm").setCellRenderer(new ButtonRenderer());
        tbl_listSP.getColumn("Thêm").setCellEditor(new ButtonEditor(new JCheckBox()));
        btn.setBackground(Color.darkGray);
        btn.setForeground(Color.white);
    }

    void loadTableSelected(List<SelectedItems> lst) {
        DefaultTableModel tbl = (DefaultTableModel) tbl_selectedSP.getModel();
        tbl.setRowCount(0);
        for (SelectedItems x : lst) {
            tbl.addRow(new Object[]{
                x.getHinhAnh(),
                x.getMaSanPham(),
                x.getTenSanPham(),
                x.getGiaTien(),
                x.getSoLuong(),
                "Xóa"
            });
        }
    }

    public void CbcKhuyenMai() {
        lstKhuyenMai = daoKM.findAll();
        cbc_maKhuyenMai.setModel(new DefaultComboBoxModel(lstKhuyenMai.toArray()));
    }

    void setTableHeader() {
//        tbl_selectedSP.getColumn("Hình").setCellRenderer(new myCDTableRenderer());
//        tbl_selectedSP.setRowHeight(60);
//        tbl_listSP.getColumn("Hình ảnh").setCellRenderer(new myCDTableRenderer());
//        tbl_selectedSP.setRowHeight(60);
    }

    
    
    class ButtonRenderer extends JButton implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            setText((value == null) ? "" : value.toString());
            return this;

        }
    }

    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }
///

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                double money = 0;
                int temp = 0;
                int index = tbl_listSP.getSelectedRow();
                String maSP = tbl_listSP.getValueAt(index, 1).toString();
                System.out.println("mã là " + maSP);
                SelectedItems a = new SelectedItems();
                if (lstSelected.isEmpty()) {
                    a.setMaSanPham(maSP);
                    a.setHinhAnh(tbl_listSP.getValueAt(index, 0).toString());
                    a.setSoLuong(1);
                    a.setTenSanPham(tbl_listSP.getValueAt(index, 2).toString());
                    a.setGiaTien(Double.parseDouble(tbl_listSP.getValueAt(index, 3).toString()));
                    lstSelected.add(a);
                } else {
                    for (SelectedItems x : lstSelected) {
                        System.out.println(lstSelected.size());
                        if (x.getMaSanPham().equals(maSP)) {
                            x.setSoLuong(x.getSoLuong() + 1);
                            temp++;
                        }
                    }
                    if (temp == 0) {
                        a.setMaSanPham(maSP);
                        a.setHinhAnh(tbl_listSP.getValueAt(index, 0).toString());
                        a.setSoLuong(1);
                        a.setTenSanPham(tbl_listSP.getValueAt(index, 2).toString());
                        a.setGiaTien(Double.parseDouble(tbl_listSP.getValueAt(index, 3).toString()));
                        lstSelected.add(a);
                    }

                }
                loadForm();
                loadTableSelected(lstSelected);

            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
     
    public void ButtonEditor() {
        btn = new JButton();
        btn.setOpaque(true);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("K hiểu đoạn này lắm");
            }
        });
    }

    public void CreateNewHoaDon(String note, int trangThai) {
        Hoadon hd = new Hoadon();
        hd.setGhiChu(note);
        int maxIdHD = daoHD.findAll().get(daoHD.findAll().size() - 1).getID_HoaDon();
        hd.setNhanvien(daoNV.findById(1));
        hd.setMaHoaDon(util.getIDMax("HD", maxIdHD));
        hd.setNgayTao(java.util.Calendar.getInstance().getTime());
        hd.setThoiGian(new Time(millis));
        hd.setTrangThai( trangThai);
        hd.setKhuyenmai((Khuyenmai) cbc_maKhuyenMai.getSelectedItem());
        daoHD.create(hd);

    }

    public void CreateNewHoaDonChiTiet() {
        daoHDCT.UpdateSelected(Integer.parseInt(selectedBan.substring(1)));
        for (int i = 0; i < tbl_selectedSP.getRowCount(); i++) {
            Hoadoinchitiet hdct = new Hoadoinchitiet();
            hdct.setDonGia((double) tbl_selectedSP.getValueAt(i, 3));
            if (tbl_selectedSP.getValueAt(i, 1).toString().contains("CB")) {
                hdct.setKieu(0);
            } else {
                hdct.setKieu(1);
            }
            hdct.setMa(Integer.parseInt(tbl_selectedSP.getValueAt(i, 1).toString().substring(2)));
            int maxHDCT = daoHDCT.findAll().get(daoHDCT.findAll().size() - 1).getIdHdct();
            hdct.setMaHoaDonChiTiet(util.getIDMax("HDCT", maxHDCT));
            hdct.setSoLuong((int) tbl_selectedSP.getValueAt(i, 4));
            hdct.setBan(daoBan.findById(Long.parseLong(selectedBan.substring(1))));
            hdct.setHoadon(daoHD.findAll().get(daoHD.findAll().size() - 1));
            daoHDCT.create(hdct);
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

        jLabel6 = new javax.swing.JLabel();
        btn_allBan = new javax.swing.JButton();
        btn_banTrong = new javax.swing.JButton();
        btn_banHD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ban = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tongTien = new javax.swing.JTextField();
        txt_tienPhaiTra = new javax.swing.JTextField();
        txt_khachDua = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        cbc_maKhuyenMai = new javax.swing.JComboBox<>();
        btn_thanhToan = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        btn_move = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_selectedSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_cafe = new javax.swing.JButton();
        btn_doUongKhac = new javax.swing.JButton();
        btn_doAn = new javax.swing.JButton();
        btn_comBo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_listSP = new javax.swing.JTable();

        setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Bán hàng");
        add(jLabel6);
        jLabel6.setBounds(12, 6, 175, 48);

        btn_allBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_allBan.setText("Tất cả bàn");
        btn_allBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allBanActionPerformed(evt);
            }
        });
        add(btn_allBan);
        btn_allBan.setBounds(12, 67, 113, 33);

        btn_banTrong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_banTrong.setText("Bàn trống");
        btn_banTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banTrongActionPerformed(evt);
            }
        });
        add(btn_banTrong);
        btn_banTrong.setBounds(161, 67, 124, 33);

        btn_banHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_banHD.setText("Bàn hoạt động");
        btn_banHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banHDActionPerformed(evt);
            }
        });
        add(btn_banHD);
        btn_banHD.setBounds(312, 67, 151, 33);

        tbl_ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Bàn", "Trạng thái", "Di chuyển"
            }
        ));
        tbl_ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_banMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ban);

        add(jScrollPane1);
        jScrollPane1.setBounds(12, 128, 452, 198);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tổng tiền");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Giảm giá");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tiền phải trả");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Khách đưa");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tiền thừa");

        txt_tongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_tienPhaiTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_khachDua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_khachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_khachDuaCaretUpdate(evt);
            }
        });

        txt_tienThua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cbc_maKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbc_maKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbc_maKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbc_maKhuyenMaiItemStateChanged(evt);
            }
        });

        btn_thanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_thanhToan.setText("Thanh toán");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        btn_luu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_huy.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_huy.setText("Hủy");

        btn_move.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_move.setText("Chuyển bàn");
        btn_move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_khachDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_move)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_tienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbc_maKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_thanhToan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbc_maKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tienPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_khachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thanhToan)
                    .addComponent(btn_luu)
                    .addComponent(btn_huy)
                    .addComponent(btn_move))
                .addGap(26, 26, 26))
        );

        add(jPanel1);
        jPanel1.setBounds(543, 364, 605, 361);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm đã chọn"));

        tbl_selectedSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hình ảnh", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng", "Xóa"
            }
        ));
        jScrollPane3.setViewportView(tbl_selectedSP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(528, 67, 599, 269);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("List sản phẩm"));

        btn_cafe.setText("Caffe");
        btn_cafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cafeActionPerformed(evt);
            }
        });

        btn_doUongKhac.setText("Đồ uống khác");
        btn_doUongKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doUongKhacActionPerformed(evt);
            }
        });

        btn_doAn.setText("Đồ ăn");
        btn_doAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doAnActionPerformed(evt);
            }
        });

        btn_comBo.setText("Combo");
        btn_comBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comBoActionPerformed(evt);
            }
        });

        tbl_listSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hình ảnh", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Thêm"
            }
        ));
        jScrollPane2.setViewportView(tbl_listSP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_cafe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_doUongKhac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_doAn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_comBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cafe)
                    .addComponent(btn_doUongKhac)
                    .addComponent(btn_doAn)
                    .addComponent(btn_comBo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(12, 364, 502, 384);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_doAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doAnActionPerformed
        loadTableSanPham(btn_doAn, 3);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_doAnActionPerformed

    private void btn_allBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allBanActionPerformed
        loadTableBan(svsBan.findByStatus(2), btn_allBan);// TODO add your handling code here:
    }//GEN-LAST:event_btn_allBanActionPerformed

    private void btn_banTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banTrongActionPerformed
        loadTableBan(svsBan.findByStatus(0), btn_banTrong);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_banTrongActionPerformed

    private void btn_banHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banHDActionPerformed
        loadTableBan(svsBan.findByStatus(1), btn_banHD);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_banHDActionPerformed

    private void btn_cafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cafeActionPerformed
        loadTableSanPham(btn_cafe, 1);// TODO add your handling code here:
    }//GEN-LAST:event_btn_cafeActionPerformed

    private void btn_comBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comBoActionPerformed
        loadTableSanPham(btn_comBo, 0);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_comBoActionPerformed

    private void btn_doUongKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doUongKhacActionPerformed
        loadTableSanPham(btn_doUongKhac, 2);// TODO add your handling code here:
    }//GEN-LAST:event_btn_doUongKhacActionPerformed

    private void cbc_maKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbc_maKhuyenMaiItemStateChanged
        loadForm();        // TODO add your handling code here:
    }//GEN-LAST:event_cbc_maKhuyenMaiItemStateChanged

    private void txt_khachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_khachDuaCaretUpdate
        loadForm();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_khachDuaCaretUpdate

    private void tbl_banMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_banMouseClicked
        int index = tbl_ban.getSelectedRow();
        selectedBan = tbl_ban.getValueAt(index, 0).toString();
        int trangThai = tbl_ban.getValueAt(index, 1).toString().equals("Trống")?0:1;
        lstSelected = svsBan.showSelectedItems(Integer.parseInt(selectedBan.substring(1)), trangThai);
        loadTableSelected(lstSelected);
//        svsBan.showSelectedItems(Integer.parseInt(selectedBan.substring(1)), trangThai);
        tbl_ban.setSelectionBackground(Color.red);
        loadForm();
    }//GEN-LAST:event_tbl_banMouseClicked

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        if (txt_khachDua.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Đưa tiền đây");
        } else if(Double.parseDouble(txt_khachDua.getText()) < Double.parseDouble(txt_tienPhaiTra.getText())){
            JOptionPane.showMessageDialog(this, "Đưa thêm tiền đây");
        }else {
            int idBan = Integer.parseInt(selectedBan.substring(1));
            if(idBan == 0){
                String note = JOptionPane.showInputDialog("Ghi chú");
                CreateNewHoaDon(note, 0);
                CreateNewHoaDonChiTiet();
                Hoadon hd =  daoHD.findHoaDonByBan(idBan);
                Ban ban = daoBan.findById(0);
                ban.setTrangThai(0);
                hd.setTrangThai(1);
                daoHD.update(hd);
                daoBan.update(ban);
                loadTableBan(svsBan.findByStatus(2), btn_allBan);
            }else{
                Hoadon hd =  daoHD.findHoaDonByBan(idBan);
                Ban ban = daoBan.findById(Long.parseLong(selectedBan.substring(1)));
                ban.setTrangThai(0);
                hd.setTrangThai(1);
                daoHD.update(hd);
                daoBan.update(ban);
                loadTableBan(svsBan.findByStatus(2), btn_allBan);
            }
        }
            txt_khachDua.setText("");
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        String note = JOptionPane.showInputDialog("Ghi chú");
        if (tbl_ban.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn bàn");
        } else {
            if (tbl_ban.getValueAt(tbl_ban.getSelectedRow(), 1).equals("Trống")) {
                CreateNewHoaDon(note, 0);
                CreateNewHoaDonChiTiet();
                Ban ban = new Ban();
                ban = daoBan.findById(Long.parseLong(selectedBan.substring(1)));
                ban.setTrangThai(1);
                daoBan.update(ban);
                List<BanView> lst = svsBan.findByStatus(2);
                for (BanView x : lst) {
                    System.out.println(x.getTrangThai());
                }
                loadTableBan(svsBan.findByStatus(2), btn_allBan);
            } else {
                Ban ban = new Ban();
                ban = daoBan.findById(Long.parseLong(selectedBan.substring(1)));
                int idBan = ban.getID_Ban();
                CreateNewHoaDonChiTiet();
                loadTableBan(svsBan.findByStatus(2), btn_allBan);
            }
        }
        txt_khachDua.setText("");
        loadForm();
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_moveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moveActionPerformed
     
        int index= tbl_ban.getSelectedRow();
        String trangThai = tbl_ban.getValueAt(index, 1).toString();
        if(trangThai.equals("Trống")){
            JOptionPane.showMessageDialog(this, "Bàn đang trống");
        }else{
            int i = JOptionPane.showConfirmDialog(this, "Chọn chức năng");
            //Chuyển bàn
            if(i ==0){
                new ChuyenBan(new FrmViewMainPage(), true,0,Integer.parseInt(tbl_ban.getValueAt(index, 0).toString().substring(1))).setVisible(true);
            }else{  //Gộp bàn
               new ChuyenBan(new FrmViewMainPage(), true,1,Integer.parseInt(tbl_ban.getValueAt(index, 0).toString().substring(1))).setVisible(true);
            }
        }
        
      // TODO add your handling code here:
    }//GEN-LAST:event_btn_moveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_allBan;
    private javax.swing.JButton btn_banHD;
    private javax.swing.JButton btn_banTrong;
    private javax.swing.JButton btn_cafe;
    private javax.swing.JButton btn_comBo;
    private javax.swing.JButton btn_doAn;
    private javax.swing.JButton btn_doUongKhac;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_move;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JComboBox<String> cbc_maKhuyenMai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_ban;
    private javax.swing.JTable tbl_listSP;
    private javax.swing.JTable tbl_selectedSP;
    private javax.swing.JTextField txt_khachDua;
    private javax.swing.JTextField txt_tienPhaiTra;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongTien;
    // End of variables declaration//GEN-END:variables

    private static class myCDTableRenderer implements TableCellRenderer {

        public myCDTableRenderer() {
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            return (Component) value;
        }
    }
}
