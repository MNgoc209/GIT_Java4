package controllers;

import entities.SanPhamChiTiet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/san-pham-chi-tiet/index",
        "/san-pham-chi-tiet/create",
        "/san-pham-chi-tiet/store",
        "/san-pham-chi-tiet/delete",
        "/san-pham-chi-tiet/edit",
        "/san-pham-chi-tiet/update"
})
public class SanPhamChiTietServlet extends HttpServlet {
    List<SanPhamChiTiet> listSPCT = new ArrayList<>();

    public SanPhamChiTietServlet() {
        this.listSPCT.add(new SanPhamChiTiet(1, "SPCT001", "KT001", "MS001", "SP001", 2, 25000, 1));
        this.listSPCT.add(new SanPhamChiTiet(2, "SPCT002", "KT002", "MS002", "SP002", 3, 55000, 1));
        this.listSPCT.add(new SanPhamChiTiet(3, "SPCT003", "KT003", "MS003", "SP003", 5, 15000, 0));
        this.listSPCT.add(new SanPhamChiTiet(4, "SPCT004", "KT002", "MS004", "SP004", 1, 22000, 1));
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
        request.setAttribute("data", this.listSPCT);
        request.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maSPCT");
        for (int i = 0; i < this.listSPCT.size(); i++) {
            SanPhamChiTiet spct = this.listSPCT.get(i);
            if (spct.getMaSPCT().equals(ma)) {
                this.listSPCT.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/san-pham-chi-tiet/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/views/san_pham_chi_tiet/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maSPCT");
        String maKT = request.getParameter("maKT");
        String maMS = request.getParameter("maMS");
        String maSP = request.getParameter("maSP");
        String soLuongStr = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(soLuongStr);
        String donGiaStr = request.getParameter("donGia");
        double donGia = Double.parseDouble(donGiaStr);
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        if (soLuong < 0) {
            request.getRequestDispatcher("/views/san_pham_chi_tiet/create.jsp").forward(request, response);
        } else {
            SanPhamChiTiet spct = new SanPhamChiTiet(id, ma, maKT, maMS, maSP, soLuong, donGia, trangThai);
            this.listSPCT.add(spct);
            response.sendRedirect("/BTVN_B2_war_exploded/san-pham-chi-tiet/index");
        }
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maSPCT");
        for (int i = 0; i < this.listSPCT.size(); i++) {
            SanPhamChiTiet spct = this.listSPCT.get(i);
            if (spct.getMaSPCT().equals(ma)) {
                request.setAttribute("spct", spct);
            }
        }
        request.getRequestDispatcher("/views/san_pham_chi_tiet/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maSPCT");
        String maKT = request.getParameter("maKT");
        String maMS = request.getParameter("maMS");
        String maSP = request.getParameter("maSP");
        String soLuongStr = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(soLuongStr);
        String donGiaStr = request.getParameter("donGia");
        double donGia = Double.parseDouble(donGiaStr);
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        SanPhamChiTiet spct = new SanPhamChiTiet(id, ma, maKT, maMS, maSP, soLuong, donGia, trangThai);
        for (int i = 0; i < this.listSPCT.size(); i++) {
            SanPhamChiTiet sanPhamChiTiet = this.listSPCT.get(i);
            if (sanPhamChiTiet.getMaSPCT().equals(ma)) {
                this.listSPCT.set(i, spct);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/san-pham-chi-tiet/index");
    }
}
