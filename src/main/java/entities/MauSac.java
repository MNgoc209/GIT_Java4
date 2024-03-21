package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Ma")
    private String maMS;
    @Column(name = "Ten")
    private String tenMS;
    @Column(name = "TrangThai")
    private int trangThai;

    public MauSac() {
    }

    public MauSac(Integer id, String maMS, String tenMS, int trangThai) {
        this.id = id;
        this.maMS = maMS;
        this.tenMS = tenMS;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
