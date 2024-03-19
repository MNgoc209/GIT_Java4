package entities;

public class KhachHang {
    private int id;
    private String tenKH;
    private String soDienThoai;
    private String maKH;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(int id, String tenKH, String soDienThoai, String maKH, int trangThai) {
        this.id = id;
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
        this.maKH = maKH;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
