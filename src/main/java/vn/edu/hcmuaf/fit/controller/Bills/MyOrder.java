package vn.edu.hcmuaf.fit.controller.Bills;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.model.Customer;
import vn.edu.hcmuaf.fit.model.Order;
import vn.edu.hcmuaf.fit.model.Receipt;
import vn.edu.hcmuaf.fit.service.CustomerService;
import vn.edu.hcmuaf.fit.service.ReceiptService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyOrder", value = "/MyOrder")
public class MyOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
//        Order order =(Order) session.getAttribute("order");
        User auth = (User) session.getAttribute("auth");

        if(auth != null){
            List<Receipt> receipts = ReceiptService.getReceiptByMakh(auth.getId());

            session.setAttribute("listRe", receipts);


            request.getRequestDispatcher("order.jsp").forward(request, response);
        }else{
            response.sendRedirect("signin.jsp");

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}