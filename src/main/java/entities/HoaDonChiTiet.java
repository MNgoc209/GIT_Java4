package entities;

public class HoaDonChiTiet {
    private int id;
    private String maHD;
    private String maSPCT;
    private int soLuong;
    private double donGia;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, String maHD, String maSPCT, int soLuong, double donGia, int trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.maSPCT = maSPCT;
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

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
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
