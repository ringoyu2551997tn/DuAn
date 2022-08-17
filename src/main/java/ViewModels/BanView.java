package ViewModels;

public class BanView {
    private int ID_Ban;
    private String maBan;
    private int trangThai;

    public BanView() {
    }

    public BanView(int ID_Ban, String maBan, int trangThai) {
        this.ID_Ban = ID_Ban;
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    public BanView(String maBan, int trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }

    public int getID_Ban() {
        return ID_Ban;
    }

    public void setID_Ban(int ID_Ban) {
        this.ID_Ban = ID_Ban;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    

}