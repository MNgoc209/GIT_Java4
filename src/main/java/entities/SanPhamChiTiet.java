package entities;

public class SanPhamChiTiet {
    private int id;
    private String maSPCT;
    private String maKT;
    private String maMS;
    private String maSP;
    private int soLuong;
    private double donGia;
    private int trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int id, String maSPCT, String maKT, String maMS, String maSP, int soLuong, double donGia, int trangThai) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.maKT = maKT;
        this.maMS = maMS;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
