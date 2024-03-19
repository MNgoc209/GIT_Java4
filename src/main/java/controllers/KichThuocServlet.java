package controllers;

import entities.KichThuoc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/kich-thuoc/index",
        "/kich-thuoc/delete",
        "/kich-thuoc/store",
        "/kich-thuoc/create",
        "/kich-thuoc/edit",
        "/kich-thuoc/update"
})
public class KichThuocServlet extends HttpServlet {
    List<KichThuoc> list = new ArrayList<>();

    public KichThuocServlet() {
        this.list.add(new KichThuoc(1, "KT001", "M", 1));
        this.list.add(new KichThuoc(2, "KT002", "L", 0));
        this.list.add(new KichThuoc(3, "KT003", "XL", 1));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
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
        request.setAttribute("data", this.list);
        request.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maKT");
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kichThuoc = this.list.get(i);
            if (kichThuoc.getMaKT().equals(ma)) {
                this.list.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/kich-thuoc/index");
    }

    public void store(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maKT");
        String ten = request.getParameter("tenKT");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        KichThuoc kichThuoc = new KichThuoc(id, ma, ten, trangThai);
        this.list.add(kichThuoc);
        response.sendRedirect("/BTVN_B2_war_exploded/kich-thuoc/index");
    }

    public void create(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/kich_thuoc/create.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request,
                     HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maKT");
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kt = this.list.get(i);
            if (kt.getMaKT().equals(ma)) {
                request.setAttribute("kt", kt);
            }
        }
        request.getRequestDispatcher("/views/kich_thuoc/edit.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maKT");
        String ten = request.getParameter("tenKT");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        KichThuoc kichThuoc = new KichThuoc(id, ma, ten, trangThai);
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kt = this.list.get(i);
            if (kt.getMaKT().equals(ma)) {
                this.list.set(i, kichThuoc);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/kich-thuoc/index");
    }
}