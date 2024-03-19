package entities;

public class MauSac {
    private int id;
    private String maMS;
    private String tenMS;
    private int trangThai;

    public MauSac() {
    }

    public MauSac(int id, String maMS, String tenMS, int trangThai) {
        this.id = id;
        this.maMS = maMS;
        this.tenMS = tenMS;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
