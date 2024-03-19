package controllers;

import entities.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/delete",
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update"
})
public class NhanVienServlet extends HttpServlet {
    List<NhanVien> listNV = new ArrayList<>();

    public NhanVienServlet() {
        this.listNV.add(new NhanVien(1, "Nguyễn Minh Ngọc", "NV001", "ngocnmph25730", "ngoc209203", 1));
        this.listNV.add(new NhanVien(2, "A", "NV002", "a123", "123", 1));
        this.listNV.add(new NhanVien(3, "B", "NV003", "b123", "1234", 1));
        this.listNV.add(new NhanVien(4, "C", "NV004", "c123", "12345", 0));
        this.listNV.add(new NhanVien(5, "D", "NV005", "d123", "123456", 1));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void index(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("data", this.listNV);
        request.getRequestDispatcher("/views/nhan_vien/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maNV");
        for (int i = 0; i < this.listNV.size(); i++) {
            NhanVien nv = this.listNV.get(i);
            if (nv.getMaNV().equals(ma)) {
                this.listNV.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/nhan-vien/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/views/nhan_vien/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ten = request.getParameter("tenNV");
        String ma = request.getParameter("maNV");
        String user = request.getParameter("tenDangNhap");
        String pwd = request.getParameter("matKhau");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        NhanVien nv = new NhanVien(id, ten, ma, user, pwd, trangThai);
        this.listNV.add(nv);
        response.sendRedirect("/BTVN_B2_war_exploded/nhan-vien/index");
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maNV");
        for (int i = 0; i < this.listNV.size(); i++) {
            NhanVien nv = this.listNV.get(i);
            if (nv.getMaNV().equals(ma)) {
                request.setAttribute("nv", nv);
            }
        }
        request.getRequestDispatcher("/views/nhan_vien/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ten = request.getParameter("tenNV");
        String ma = request.getParameter("maNV");
        String user = request.getParameter("tenDangNhap");
        String pwd = request.getParameter("matKhau");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        NhanVien nv = new NhanVien(id, ten, ma, user, pwd, trangThai);
        for (int i = 0; i < this.listNV.size(); i++) {
            NhanVien nhanVien = this.listNV.get(i);
            if (nhanVien.getMaNV().equals(ma)) {
                this.listNV.set(i, nv);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/nhan-vien/index");
    }

}
