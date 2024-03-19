package controllers;

import entities.HoaDon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/hoa-don/index",
        "/hoa-don/delete",
        "/hoa-don/create",
        "/hoa-don/store",
        "/hoa-don/edit",
        "/hoa-don/update"
})
public class HoaDonServlet extends HttpServlet {
    List<HoaDon> listHD = new ArrayList<>();

    public HoaDonServlet() {
        this.listHD.add(new HoaDon(1, "HD001", "NV001", "KH002", "11/03/2024", 1));
        this.listHD.add(new HoaDon(2, "HD002", "NV002", "KH001", "16/02/2024", 1));
        this.listHD.add(new HoaDon(3, "HD003", "NV001", "KH001", "01/01/2024", 1));
        this.listHD.add(new HoaDon(4, "HD004", "NV003", "KH003", "20/01/2024", 0));
        this.listHD.add(new HoaDon(5, "HD005", "NV004", "KH005", "12/03/2024", 0));
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
        request.setAttribute("data", this.listHD);
        request.getRequestDispatcher("/views/hoa_don/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maHD");
        for (int i = 0; i < this.listHD.size(); i++) {
            HoaDon hd = this.listHD.get(i);
            if (hd.getMaHD().equals(ma)) {
                this.listHD.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/views/hoa_don/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String maHD = request.getParameter("maHD");
        String maNV = request.getParameter("maNV");
        String maKH = request.getParameter("maKH");
        String ngayMH = request.getParameter("ngayMuaHang");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        HoaDon hd = new HoaDon(id, maHD, maNV, maKH, ngayMH, trangThai);
        this.listHD.add(hd);
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don/index");
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("maHD");
        for (int i = 0; i < this.listHD.size(); i++) {
            HoaDon hd = this.listHD.get(i);
            if (hd.getMaHD().equals(ma)) {
                request.setAttribute("hd", hd);
            }
        }
        request.getRequestDispatcher("/views/hoa_don/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String maHD = request.getParameter("maHD");
        String maNV = request.getParameter("maNV");
        String maKH = request.getParameter("maKH");
        String ngayMH = request.getParameter("ngayMuaHang");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        HoaDon hd = new HoaDon(id, maHD, maNV, maKH, ngayMH, trangThai);
        String ma = request.getParameter("maHD");
        for (int i = 0; i < this.listHD.size(); i++) {
            HoaDon hoaDon = this.listHD.get(i);
            if (hoaDon.getMaHD().equals(ma)) {
                this.listHD.set(i, hd);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/hoa-don/index");
    }
}
