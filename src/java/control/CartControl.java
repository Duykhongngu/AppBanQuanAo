/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DaoSanPham;
import entity.GioHang;
import entity.SanPham;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin
 */
@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {
    public static List<GioHang> dsgh = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        String spid = request.getParameter("spid");
//        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
//        String action = request.getParameter("action");
//        DaoSanPham daoSP = new DaoSanPham();
//        
//        GioHang gh = new GioHang();
//        SanPham sp = null;
//        switch (action) {
//            case "addCart":
//                sp = daoSP.getAllSanPhamByID(spid);
//                gh.setPro(sp);
//                gh.setSoluong(soLuong); 
//                dsgh.add(gh);
//                response.sendRedirect("home");
//                break;
//            default:
//                throw new AssertionError();
//        }
        String spid = request.getParameter("spid");
        String action = request.getParameter("action");

//        if (spid == null || action == null) {
//            response.sendRedirect("view-cart.jsp?error=Invalid+request");
//            return;
//        }

        int soLuong = 0;
        
        String s = request.getParameter("soLuong");
        if(s != null)
            soLuong = Integer.parseInt(s);

        DaoSanPham daoSP = new DaoSanPham();

        switch (action) {
            case "addCart":
                boolean found = false;
                for (GioHang gh : dsgh) {
                    if (gh.getPro().getSanPhamid() == Integer.parseInt(spid)) {
                        gh.setSoluong(gh.getSoluong() + soLuong);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    SanPham sp = daoSP.getAllSanPhamByID(spid);
                    GioHang gh = new GioHang(sp, soLuong);
                    dsgh.add(gh);
                }
                response.sendRedirect("home");
                break;
            case "updateCart":
                for (GioHang gh : dsgh) {
                    if (gh.getPro().getSanPhamid() == Integer.parseInt(spid)) {
                        gh.setSoluong(soLuong);
                        break;
                    }
                }
                //response.sendRedirect("view-cart.jsp");
                break;
            case "removeCart":
                dsgh.clear();
                response.sendRedirect("home");
                break;
            default:
                response.sendRedirect("view-cart.jsp?error=Unknown+action");
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
