package controller;

import model.Product;
import service.ProductImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    int id = 0;
    ProductImpl productImpl = new ProductImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acion = request.getParameter("action");
        if (acion == null) {
            acion = "";
        }
        switch (acion) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewForm(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acion = request.getParameter("action");
        if (acion == null) {
            acion = "";
        }
        switch (acion) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productImpl.findProductById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            response.sendRedirect("list.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("view.jsp");
            request.setAttribute("product", product);
            requestDispatcher.forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productImpl.findProductById(id);
        if (product == null) {
            response.sendRedirect("list.jsp");
        } else {
            this.productImpl.delete(id);
            response.sendRedirect("/productServlet");
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int maSP = Integer.parseInt(request.getParameter("masp"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String nhaSX = request.getParameter("nhasx");
        String note = request.getParameter("note");
        Product product = this.productImpl.findProductById(id);
        if (product == null) {
            response.sendRedirect("list.jsp");
        } else {
            product.setMaSP(maSP);
            product.setName(name);
            product.setPrice(price);
            product.setNhaSX(nhaSX);
            product.setNote(note);
            this.productImpl.update(id, product);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSP = Integer.parseInt(request.getParameter("maSP"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String nhaSX = request.getParameter("nhaSX");
        String note = request.getParameter("note");
        Product product = new Product(id, maSP, name, price, nhaSX, note);
        this.productImpl.add(product);
        id++;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productImpl.findAll();
        request.setAttribute("product", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productImpl.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("list.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("edit.jsp");
            request.setAttribute("product", product);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productImpl.findProductById(id);
        if (product == null) {
            response.sendRedirect("list.jsp");
        } else {
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
            dispatcher.forward(request, response);
        }
    }
}
