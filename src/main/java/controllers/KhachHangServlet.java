package controllers;

import entities.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/khach-hang/index",
        "/khach-hang/delete",
        "/khach-hang/create",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update",
})
public class KhachHangServlet extends HttpServlet {
    List<KhachHang> listKH = new ArrayList<>();

    public KhachHangServlet() {
        this.listKH.add(new KhachHang(1, "A", "0339293844", "KH001", 1));
        this.listKH.add(new KhachHang(2, "B", "0239293844", "KH002", 1));
        this.listKH.add(new KhachHang(3, "C", "0259293844", "KH003", 0));
        this.listKH.add(new KhachHang(4, "D", "0119293844", "KH004", 0));
        this.listKH.add(new KhachHang(5, "E", "0669293844", "KH005", 1));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
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
                       HttpServletResponse response) throws IOException, ServletException {
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
                      HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("data", this.listKH);
        request.getRequestDispatcher("/views/khach_hang/index.jsp").forward(request, response);

    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maKH");
        for (int i = 0; i < this.listKH.size(); i++) {
            KhachHang kh = this.listKH.get(i);
            if (kh.getMaKH().equals(ma)) {
                this.listKH.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/khach-hang/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maKH");
        String ten = request.getParameter("tenKH");
        String sdt = request.getParameter("soDienThoai");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        KhachHang kh = new KhachHang(id, ten, sdt, ma, trangThai);

        this.listKH.add(kh);
        response.sendRedirect("/BTVN_B2_war_exploded/khach-hang/index");
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maKH");
        for (int i = 0; i < this.listKH.size(); i++) {
            KhachHang kh = this.listKH.get(i);
            if (kh.getMaKH().equals(ma)) {
                request.setAttribute("kh", kh);
            }
        }
        request.getRequestDispatcher("/views/khach_hang/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maKH");
        String ten = request.getParameter("tenKH");
        String sdt = request.getParameter("soDienThoai");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        KhachHang kh = new KhachHang(id, ten, sdt, ma, trangThai);
        for (int i = 0; i < this.listKH.size(); i++) {
            KhachHang khachHang = this.listKH.get(i);
            if (khachHang.getMaKH().equals(ma)) {
                this.listKH.set(i, kh);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/khach-hang/index");
    }
}
