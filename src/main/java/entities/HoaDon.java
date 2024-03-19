package entities;

public class HoaDon {
    private int id;
    private String maHD;
    private String maNV;
    private String maKH;
    private String ngayMuaHang;
    private int trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, String maHD, String maNV, String maKH, String ngayMuaHang, int trangThai) {
        this.id = id;
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayMuaHang = ngayMuaHang;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(String ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
