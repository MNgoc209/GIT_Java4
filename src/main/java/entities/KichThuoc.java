package entities;

public class KichThuoc {
    private int id;
    private String maKT;
    private String tenKT;
    private int trangThai;

    public KichThuoc() {
    }

    public KichThuoc(int id, String maKT, String tenKT, int trangThai) {
        this.id = id;
        this.maKT = maKT;
        this.tenKT = tenKT;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public String getTenKT() {
        return tenKT;
    }

    public void setTenKT(String tenKT) {
        this.tenKT = tenKT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
