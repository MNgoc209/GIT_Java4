package controllers;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.MauSacRepository;

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
    private MauSacRepository msRepo = new MauSacRepository();

    public MauSacServlet() {
//        this.ds.add(new MauSac(1, "MS001", "Hồng", 1));
//        this.ds.add(new MauSac(2, "MS002", "Đen", 0));
//        this.ds.add(new MauSac(3, "MS003", "Trắng", 1));
//        this.ds.add(new MauSac(4, "MS004", "Tím", 1));
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
        request.setAttribute("data", msRepo.findAll());
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
//        String idStr = request.getParameter("id");
//        Integer id = Integer.parseInt(idStr);
        String ma = request.getParameter("maMS");// lấy name bên create.jsp
        String ten = request.getParameter("tenMS");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);

        MauSac ms = new MauSac(null, ma, ten, trangThai);
        this.msRepo.create(ms);
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        for (int i = 0; i < this.msRepo.findAll().size(); i++) {
            MauSac mauSac = this.msRepo.findAll().get(i);
            if (mauSac.getId() == id) {
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
        Integer id = Integer.parseInt(idStr);
        String maMS = request.getParameter("maMS");
        String tenMS = request.getParameter("tenMS");
        String ttStr = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttStr);
        MauSac ms = new MauSac(id, maMS, tenMS, trangThai);
        for (int i = 0; i < this.msRepo.findAll().size(); i++) {
            MauSac color = this.msRepo.findAll().get(i);
            if (color.getId() == id) {
                this.msRepo.update(ms);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        for (int i = 0; i < this.msRepo.findAll().size(); i++) {
            MauSac mauSac = this.msRepo.findAll().get(i);
            if (mauSac.getId() == id) {
                this.msRepo.delete(mauSac);
            }
        }
        response.sendRedirect("/BTVN_B2_war_exploded/mau-sac/index");
    }
}
