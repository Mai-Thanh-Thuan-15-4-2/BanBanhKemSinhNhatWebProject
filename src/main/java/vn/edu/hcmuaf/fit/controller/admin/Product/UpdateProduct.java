package vn.edu.hcmuaf.fit.controller.admin.Product;

import vn.edu.hcmuaf.fit.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProduct", value = "/admin/Product/UpdateProduct")
public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
                String masp = request.getParameter("proId");
                String tensp = request.getParameter("proname");
                int gia = Integer.parseInt(request.getParameter("price"));
                String loai = request.getParameter("loaiBanh");
                String kichthuoc = request.getParameter("size");
                int khoiLuong = Integer.parseInt(request.getParameter("weight"));
                String mota = request.getParameter("description");
                String noidung = request.getParameter("intro");
                ProductService.updateProduct(masp,  loai, tensp,kichthuoc, khoiLuong, mota, noidung, gia);
                response.sendRedirect("../ListProduct_Admin");


    }
}
