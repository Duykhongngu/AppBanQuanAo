/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DaoAccount;
import dao.DaoDanhMucSanPham;
import dao.*;
import entity.*;
import entity.DanhMucSanPham;
import entity.SanPham;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hieu.Nguyxn
 */
@WebServlet(name = "AdminShowControl", urlPatterns = {"/ashowcontrol"})
public class AdminShowControl extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Sản Phẩm
        DaoSanPham daoSP = new DaoSanPham();
        List<SanPham> ListSP = daoSP.getAllSanPham();
        request.setAttribute("ListSP", ListSP);
        
        String name = request.getParameter("btnname");
        
        //Danh mục
        DaoDanhMucSanPham daodm = new DaoDanhMucSanPham();
        List<DanhMucSanPham> ListDM = daodm.getAllDanhMucSanPham();
        request.setAttribute("ListDM", ListDM);
        
        //Account
        dao.DaoAccount daoacc = new DaoAccount();
        List<Account> ListACC = daoacc.getAllAccount();
        request.setAttribute("ListACC", ListACC);
        
        //DonHang
        DaoDonHang daodh = new DaoDonHang();
        List<DonHang> ListDH = daodh.getAllDonHang();
        request.setAttribute("ListDH", ListDH);
        
        //ChiTietDonHang
        DaoChiTietDonHang daoct = new DaoChiTietDonHang();
        List<ChiTietDonHang> ListCT = daoct.getAllChiTietDonHang();
        request.setAttribute("ListCT", ListCT);
        if(name != null){
            switch (name) {
                case "addsp":
                    request.setAttribute("btnname", name);
                    request.getRequestDispatcher("Add.jsp").forward(request, response);
                    break;
                case "dmsp":
                    request.setAttribute("btnname", name);
                    request.getRequestDispatcher("Add.jsp").forward(request, response);
                    break;
                case "addacc":
                    request.setAttribute("btnname", name);
                    request.getRequestDispatcher("Add.jsp").forward(request, response);
                    break;
                case "adddh":
                    request.setAttribute("btnname", name);
                    request.getRequestDispatcher("Add.jsp").forward(request, response);
                default:
                    request.setAttribute("ListSP", ListSP);
                    request.setAttribute("btnname", name);
            }
        }
            
        request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
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
