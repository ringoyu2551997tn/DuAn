/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModel.Ban;
import DomainModel.Combo;
import DomainModel.Hoadoinchitiet;
import DomainModel.Hoadon;
import DomainModel.Sanpham;
import Services.Date;
import Services.IServiceBangHoaDon;
import Services.ServiceHoaDon;
import ViewModels.HoadonView;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repositories.ImplBangHoaDon;
import repositories.ImplBangHoaDonChiTiet;
import repositories.InterfaceBangHoaDon;
import repositories.InterfaceBangHoaDonChiTiet;

/**
 *
 * @author ADMIN
 */
public class JpanelHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form JpanelHoaDon
     */
    InterfaceBangHoaDonChiTiet hdct = new ImplBangHoaDonChiTiet();
     InterfaceBangHoaDon hd = new ImplBangHoaDon();
    DefaultTableModel _dTableModel = new DefaultTableModel();
    IServiceBangHoaDon hdService;
    
    public JpanelHoaDon() {
        initComponents();
        hdService = new ServiceHoaDon();
        loaddata(hdService.findAll());
        add();
        date1.setDateFormatString("yyyy-MM-dd");
        date2.setDateFormatString("yyyy-MM-dd");
    }
    
    void add() {
        cbcTrangthai.removeAllItems();
        
        cbcTrangthai.addItem("Tất cả");
        cbcTrangthai.addItem("Đã thanh toán");
        cbcTrangthai.addItem("Chưa thanh toán ");
        cbcTrangthai.addItem("Hủy");
        
    }
    
    void loaddata(List<HoadonView> list) {
        
        _dTableModel = (DefaultTableModel) tbl_hd.getModel();
        _dTableModel.setRowCount(0);
        int stt = 0;
        for (HoadonView x : list) {
            _dTableModel.addRow(new Object[]{stt++, x.getMaHoaDon(),
                x.getNhanvien().getTenNhanVien(),
                x.getTrangThai() == 0 ? "Chưa thanh toán" : x.getTrangThai() == 1 ? "Đã thanh toán" : "Hủy",
                x.getGhiChu(),
                x.getKhuyenmai().getTenKhuyenMai(),
                x.getNgayTao()});
        }
    }
    
    void loaddataHDCT(List<Hoadoinchitiet> list) {
        
        _dTableModel = (DefaultTableModel) tbl_hd1.getModel();
        _dTableModel.setRowCount(0);
        int stt = 0;
        for (Hoadoinchitiet x : list) {
            if (x.getKieu() == 1) {
                for (Sanpham s : hdct.findSanPham(x.getHoadon().getID_HoaDon())) {
                    _dTableModel.addRow(new Object[]{stt++, s.getMaSanPham(), s.getTenSanPham(), x.getDonGia(), x.getSoLuong(), x.getDonGia() * x.getSoLuong()});
                }
            }else if (x.getKieu() == 0){
                for (Combo c : hdct.findCombo(x.getHoadon().getID_HoaDon())) {
                    _dTableModel.addRow(new Object[]{stt++, c.getMaComBo(), c.getTenComBo(), x.getDonGia(), x.getSoLuong(),x.getDonGia() * x.getSoLuong()});
                }
            }
            
            
     }
    }

    
    int IDHD(String maHD){
        for (Hoadon x : hd.findAll()) {
            if(x.getMaHoaDon().equals(maHD)){
                return x.getID_HoaDon();
            }
        }
        return 0 ;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hd = new javax.swing.JTable();
        cbcTrangthai = new javax.swing.JComboBox<>();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        Xuat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hd1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Loc = new javax.swing.JButton();

        tbl_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ma NV", "Tình Trạng", "Ghi chu", "Ma Khuyen Mai", "Ngày tạo "
            }
        ));
        tbl_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hdMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_hdMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hd);

        cbcTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbcTrangthai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcTrangthaiItemStateChanged(evt);
            }
        });
        cbcTrangthai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbcTrangthaiKeyPressed(evt);
            }
        });

        Xuat.setText("Xuất");
        Xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuatActionPerformed(evt);
            }
        });

        tbl_hd1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Đơn giá", "số lượng", "Thành tiền "
            }
        ));
        tbl_hd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hd1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_hd1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_hd1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Danh sách hóa đơn ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Hóa đơn chi tiết ");

        Loc.setText("Lọc");
        Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(281, 281, 281)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbcTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbcTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void tbl_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseClicked
       String mahd = tbl_hd.getModel().getValueAt(tbl_hd.getSelectedRow(),1).toString();
       loaddataHDCT(hdct.findByIdHD(IDHD(mahd)));

    }//GEN-LAST:event_tbl_hdMouseClicked

    private void tbl_hdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_hdMouseReleased

    private void tbl_hd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hd1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_hd1MouseClicked

    private void tbl_hd1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hd1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_hd1MouseReleased

    private void cbcTrangthaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcTrangthaiItemStateChanged
        if (cbcTrangthai.getSelectedIndex() == 0) {
            loaddata(hdService.findAll());
        } else if (cbcTrangthai.getSelectedIndex() == 1) {
            loaddata(hdService.findByTStatus(1));
        } else if (cbcTrangthai.getSelectedIndex() == 2) {
            loaddata(hdService.findByTStatus(0));
        } else if (cbcTrangthai.getSelectedIndex() == 3) {
            loaddata(hdService.findByTStatus(2));
        }
    }//GEN-LAST:event_cbcTrangthaiItemStateChanged

    private void XuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XuatActionPerformed
         if(tbl_hd.getSelectedRow() < 0){
              JOptionPane.showMessageDialog(this, "Muốn xuất hóa đơn nào phải chọn chứ");
                return;
         }
        String mahd = tbl_hd.getModel().getValueAt(tbl_hd.getSelectedRow(),1).toString();
       
        PdfWriter pdfwriter = null;
        try {
           
            String path = "D:\\PDF\\"+ IDHD(tbl_hd.getModel().getValueAt(tbl_hd.getSelectedRow(),1).toString()) + ".pdf";
            pdfwriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfwriter);
            Document document = new Document(pdfDocument);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont(fontProgram, "UTF-8");
            document.setFont(font);
            float col = 280f;
            float columwith[] = {col, col};
            Table table = new Table(columwith);
            Color color = WebColors.getRGBColor("white");
            table.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(color);
            table.addCell(new Cell().add(new Paragraph("HDCT"))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginTop(60f)
                    .setMarginBottom(30f)
                    .setFontSize(30f)
                    .setBorder(Border.NO_BORDER).setFont(font)
            );
            table.addCell(new Cell().add(new Paragraph("Quán Coffee \n Address : Hà Nội \n"
                    + "Điện Thoại : 0816134100 "))
                    .setMarginTop(60f)
                    .setMarginBottom(30f)
                    .setFontSize(10f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f).setFont(font)
            );
            //Thông tin hóa đơn
            float colwith[] = {80, 300, 100, 80};
            Table customerInfortable = new Table(colwith);
            customerInfortable.addCell(new Cell(0, 4).add(new Paragraph("thong tin chi tiet")).setBold().setBorder(Border.NO_BORDER));
            customerInfortable.addCell(new Cell().add(new Paragraph("Ten NV : ")).setBorder(Border.NO_BORDER));
            customerInfortable.addCell(new Cell().add(new Paragraph(hd.findById(IDHD(mahd)).getNhanvien().getTenNhanVien())).setBorder(Border.NO_BORDER));
           customerInfortable.addCell(new Cell().add(new Paragraph("Date : ")).setBorder(Border.NO_BORDER));
          customerInfortable.addCell(new Cell().add(new Paragraph(String.valueOf(hd.findById(IDHD(mahd)).getNgayTao()))).setBorder(Border.NO_BORDER));
           customerInfortable.addCell(new Cell().add(new Paragraph("Time  : ")).setBorder(Border.NO_BORDER));
            customerInfortable.addCell(new Cell().add(new Paragraph(String.valueOf(hd.findById(IDHD(mahd)).getThoiGian()))).setBorder(Border.NO_BORDER));
            customerInfortable.addCell(new Cell().add(new Paragraph("Ban : ")).setBorder(Border.NO_BORDER));
           	Set<Ban> listbanHD  = new HashSet<Ban>();
		for (Hoadoinchitiet x : hdct.findByIdHD(IDHD(mahd))) {
		listbanHD.add(x.getBan());
			}
          for (Ban f : listbanHD) {
              customerInfortable.addCell(new Cell().add(new Paragraph(f.getMaBan())).setBorder(Border.NO_BORDER));
          }
            
            //thông tin sản phẩm
            double sum = 0;
            for (Hoadoinchitiet x : hdct.findByIdHD(IDHD(mahd))) {
                sum += (x.getSoLuong() * x.getDonGia());
            }
            float itemInfoColWith[] = {112,112,112,112,112};
            Table itemInfoTable = new Table(itemInfoColWith);
            itemInfoTable.addCell(new Cell().add( new Paragraph("Ma SP")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("Ten SP")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("Gia Ban")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("So luong")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("Thanh Tien")).setBorder(Border.NO_BORDER));
            for (Hoadoinchitiet x :hdct.findByIdHD(IDHD(mahd)) ) {
                if(x.getKieu() == 1) {
                    for (Sanpham s :  hdct.findSanPham(x.getHoadon().getID_HoaDon())) {
                        itemInfoTable.addCell(new Cell().add( new Paragraph(s.getMaSanPham())).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(s.getTenSanPham())).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getDonGia()))).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getSoLuong()))).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getSoLuong() *x.getDonGia()))).setBorder(Border.NO_BORDER));
                    }
                }else  {
                    for (Combo c : hdct.findCombo(x.getHoadon().getID_HoaDon())) {
                        itemInfoTable.addCell(new Cell().add( new Paragraph(c.getMaComBo())).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(c.getTenComBo())).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getDonGia()))).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getSoLuong()))).setBorder(Border.NO_BORDER));
                        itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(x.getSoLuong() *x.getDonGia()))).setBorder(Border.NO_BORDER));
                    }
                }
                
                
                
            }
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("Giam Gia ")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf(hd.findById(IDHD(mahd)).getKhuyenmai().getChietKhau()))).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph("Tong ")).setBorder(Border.NO_BORDER));
            itemInfoTable.addCell(new Cell().add( new Paragraph(String.valueOf((sum * (100-hd.findById(IDHD(mahd)).getKhuyenmai().getChietKhau() )) / 100 ))).setBorder(Border.NO_BORDER));
            document.add(table);
            document.add(new Paragraph());
            document.add(customerInfortable);
            document.add(itemInfoTable);
            document.close();
              JOptionPane.showMessageDialog(this, "Xuất thành công!");
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Xuất thất bại !");
        } finally {
            try {
                pdfwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(JpanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_XuatActionPerformed

    private void cbcTrangthaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbcTrangthaiKeyPressed
        if (cbcTrangthai.getSelectedItem().toString().equals("Tất cả")) {
            loaddata(hdService.findAll());
        } else if (cbcTrangthai.getSelectedItem().toString().equals("Đã thanh toán")) {
            loaddata(hdService.findByTStatus(1));
        } else if (cbcTrangthai.getSelectedItem().toString().equals("Chưa thanh toán")) {
            loaddata(hdService.findByTStatus(0));
        } else if (cbcTrangthai.getSelectedItem().toString().equals("Hủy")) {
            loaddata(hdService.findByTStatus(2));
        }
    }//GEN-LAST:event_cbcTrangthaiKeyPressed

    private void LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocActionPerformed
         Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
            cal1.setTime(date1.getDate());
            cal2.setTime(date2.getDate());
            if(fomat.format(date2.getDate()).isEmpty() || fomat.format(date1.getDate()).isEmpty()){
                 JOptionPane.showMessageDialog(this, "Không được null !");
                return;
            }
            if(cal1.after(cal2)){
                JOptionPane.showMessageDialog(this, "Không được chọn ngày bắt đầu < ngày khết thúc!");
                return;
            }
          
//            if (!date1.getDateFormatString().(fomat.format(date1.getDate()))){
//                JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày ");
//                return;
//            }      
        
        loaddata(hdService.findByDate(date1.getDate(), date2.getDate()));
    }//GEN-LAST:event_LocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Loc;
    private javax.swing.JButton Xuat;
    private javax.swing.JComboBox<String> cbcTrangthai;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_hd;
    private javax.swing.JTable tbl_hd1;
    // End of variables declaration//GEN-END:variables
}
