/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DaoDanhMucSanPham;
import dao.*;
import dao.DaoAccount;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hieu.Nguyxn
 */
@WebServlet(name = "AdminDeleteControl", urlPatterns = {"/adeletecontrol"})
public class AdminDeleteControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String delete = request.getParameter("sid");
        String btnname = request.getParameter("btnname");
        //SanPham
        dao.DaoSanPham dao = new DaoSanPham();
        //DanhMuc
        DaoDanhMucSanPham daodm = new DaoDanhMucSanPham();
        //Account
        DaoAccount daoacc = new DaoAccount();
        //DonHang
        DaoDonHang daodh = new DaoDonHang();
        switch (btnname) {
            case "deletesp":
                dao.deleteSanPham(delete);
                response.sendRedirect("/WebBanQuanAo/ashowcontrol?btnname=btnsanpham");
                break;
            case "deletedm":
                daodm.deleteDanhMuc(delete);
                response.sendRedirect("/WebBanQuanAo/ashowcontrol?btnname=danhmucsanpham");
                break;
            case "deleteacc":
                daoacc.deleteAccount(delete);
                response.sendRedirect("/WebBanQuanAo/ashowcontrol?btnname=account");
                break;
            case "deletedh":
                daodh.deleteDonHang(delete);
                response.sendRedirect("/WebBanQuanAo/ashowcontrol?btnname=donhang");
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
