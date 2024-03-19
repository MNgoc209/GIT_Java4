package controllers;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/mau-sac/create",  //GET
        "/mau-sac/store",   //POST
        "/mau-sac/edit",    //GET
        "/mau-sac/update",  //POST
        "/mau-sac/delete",  //GET
        "/mau-sac/index"    //GET
})
public class MauSacServlet extends HttpServlet {
    List<MauSac> ds = new ArrayList<>();

    public MauSacServlet() {
        this.ds.add(new MauSac(1, "MS001", "Hồng", 1));
        this.ds.add(new MauSac(2, "MS002", "Đen", 0));
        this.ds.add(new MauSac(3, "MS003", "Trắng", 1));
        this.ds.add(new MauSac(4, "MS004", "Tím", 1));
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
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

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("data", this.ds);
        request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/mau_sac/create.jsp").forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String ma = request.getParameter("maMS");// lấy name bên create.jsp
        String ten = request.getParameter("tenMS");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        MauSac ms = new MauSac(id, ma, ten, trangThai);
        this.ds.add(ms);
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("maMS");
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac mauSac = this.ds.get(i);
            if (mauSac.getMaMS().equals(ma)) {
                request.setAttribute("ms", mauSac);
            }
        }
        request.getRequestDispatcher("/views/mau_sac/edit.jsp").forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String maMS = request.getParameter("maMS");
        String tenMS = request.getParameter("tenMS");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        MauSac ms = new MauSac(id, maMS, tenMS, trangThai);
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac color = this.ds.get(i);
            if (color.getMaMS().equals(maMS)) {
                this.ds.set(i, ms);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("maMS");
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac mauSac = this.ds.get(i);
            if (mauSac.getMaMS().equals(ma)) {
                this.ds.remove(i);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }
}
