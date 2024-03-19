package controllers;

import entities.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/san-pham/index",
        "/san-pham/delete",
        "/san-pham/store",
        "/san-pham/create",
        "/san-pham/edit",
        "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {
    List<SanPham> listSP = new ArrayList<>();

    public SanPhamServlet() {
        this.listSP.add(new SanPham(1, "SP001", "Áo thun", 1));
        this.listSP.add(new SanPham(2, "SP002", "Sản phẩm 1", 1));
        this.listSP.add(new SanPham(3, "SP003", "Sản phẩm 2", 0));
        this.listSP.add(new SanPham(4, "SP004", "Sản phẩm 3", 0));
        this.listSP.add(new SanPham(5, "SP005", "Sản phẩm 4", 1));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
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
        request.setAttribute("data", this.listSP);
        request.getRequestDispatcher("/views/san_pham/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maSP");
        for (int i = 0; i < this.listSP.size(); i++) {
            SanPham sanPham = this.listSP.get(i);
            if (sanPham.getMaSP().equals(ma)) {
                this.listSP.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/san-pham/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/san_pham/create.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        if (ma.isEmpty() || ten.isEmpty()) {
            request.getRequestDispatcher("/views/san_pham/create.jsp").forward(request, response);
        } else {
            SanPham sanPham = new SanPham(id, ma, ten, trangThai);
            this.listSP.add(sanPham);
            response.sendRedirect("/BTVN_B2_war_exploded/san-pham/index");
        }
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maSP");
        for (int i = 0; i < this.listSP.size(); i++) {
            SanPham sp = this.listSP.get(i);
            if (sp.getMaSP().equals(ma)) {
                request.setAttribute("sp", sp);
            }
        }
        request.getRequestDispatcher("/views/san_pham/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);

        if (ma.isEmpty() || ten.isEmpty()) {
            request.getRequestDispatcher("/views/san_pham/edit.jsp").forward(request, response);
        } else {
            SanPham sanPham = new SanPham(id, ma, ten, trangThai);
            for (int i = 0; i < this.listSP.size(); i++) {
                SanPham sp = this.listSP.get(i);
                if (sp.getMaSP().equals(ma)) {
                    this.listSP.set(i, sanPham);
                }
            }
            response.sendRedirect("/BTVN_B2_war_exploded/san-pham/index");
        }
    }
}
