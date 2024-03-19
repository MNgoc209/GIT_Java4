package controllers;

import entities.HoaDonChiTiet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/hoa-don-chi-tiet/index",
        "/hoa-don-chi-tiet/delete",
        "/hoa-don-chi-tiet/create",
        "/hoa-don-chi-tiet/store",
        "/hoa-don-chi-tiet/edit",
        "/hoa-don-chi-tiet/update"
})
public class HoaDonChiTietServlet extends HttpServlet {
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    public HoaDonChiTietServlet() {
        this.listHDCT.add(new HoaDonChiTiet(1, "HD001", "SPCT001", 2, 2000, 1));

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
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
        request.setAttribute("data", this.listHDCT);
        request.getRequestDispatcher("/views/hoa_don_chi_tiet/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        for (int i = 0; i < this.listHDCT.size(); i++) {
            HoaDonChiTiet hdct = this.listHDCT.get(i);
            if (hdct.getId() == id) {
                this.listHDCT.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don-chi-tiet/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/views/hoa_don_chi_tiet/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String maHD = request.getParameter("maHD");
        String maSpct = request.getParameter("maSPCT");
        String soLuongStr = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(soLuongStr);
        String donGiaStr = request.getParameter("donGia");
        double donGia = Double.parseDouble(donGiaStr);
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        HoaDonChiTiet hdct = new HoaDonChiTiet(id, maHD, maSpct, soLuong, donGia, trangThai);
        this.listHDCT.add(hdct);
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don-chi-tiet/index");
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        for (int i = 0; i < this.listHDCT.size(); i++) {
            HoaDonChiTiet hdct = this.listHDCT.get(i);
            if (hdct.getId() == id) {
                request.setAttribute("hdct", hdct);
            }
        }
        request.getRequestDispatcher("/views/hoa_don_chi_tiet/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String maHD = request.getParameter("maHD");
        String maSpct = request.getParameter("maSPCT");
        String soLuongStr = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(soLuongStr);
        String donGiaStr = request.getParameter("donGia");
        double donGia = Double.parseDouble(donGiaStr);
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        HoaDonChiTiet hdct = new HoaDonChiTiet(id, maHD, maSpct, soLuong, donGia, trangThai);
        for (int i = 0; i < this.listHDCT.size(); i++) {
            HoaDonChiTiet hoaDonChiTiet = this.listHDCT.get(i);
            if (hoaDonChiTiet.getId() == id) {
                this.listHDCT.set(i, hdct);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don-chi-tiet/index");
    }
}
