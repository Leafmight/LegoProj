package Presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Data.DAO;
import Logic.BandCalculator;
import Data.User;
import Data.Order;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jacobfolkehildebrandt
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    DAO d = new DAO();
    HttpSession session;
    ArrayList<Order> orders = d.getAllOrderList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");

        String origin = request.getParameter("origin");
        switch (origin) {
            case "index":
                index(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "createUser":
                createUser(request, response);
                break;
            case "makeUser":
                makeUser(request, response);
                break;
            case "checkLogin":
                checkLogin(request, response);
                break;
            case "shop":
                shop(request, response);
                break;
            case "admin":
                admin(request, response);
                break;
            case "userOrders":
                userOrders(request, response);
                break;
            case "calculateBricks":
                calculateBricks(request, response);
                break;
            case "createOrder":
                createOrder(request, response);
                break;
            case "allUserOrders":
                allUserOrders(request, response);
                break;
            case "updateShipping":
                updateShipping(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createUser.jsp").forward(request, response);
    }

    private void shop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    private void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = d.getUser(email, password);

        session.setAttribute("user", user);
        orders = d.getAllOrderList();
        session.setAttribute("allUserOrders", orders);

        boolean valid = d.checkLogin(email, password);

        if (valid && email != null && password != null && !("".equals(email))
                       && !("".equals(password))) {
            if (user.isAdmin() == true) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void makeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        d.createUser(email, password);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void allUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        orders.clear();
        orders = d.getAllOrderList();

        session.setAttribute("allUserOrders", orders);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private void userOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) session.getAttribute("user");
        ArrayList<Order> o = d.getUserOrderList(u.getEmail());
        o.clear();
        o = d.getUserOrderList(u.getEmail());

        session.setAttribute("userOrders", o);

        request.getRequestDispatcher("userOrders.jsp").forward(request, response);
    }

    private void calculateBricks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = Integer.parseInt(request.getParameter("Width"));
        int height = Integer.parseInt(request.getParameter("Height"));
        int length = Integer.parseInt(request.getParameter("Length"));
        int bandType = Integer.parseInt(request.getParameter("band"));

        String band = "";
        switch (bandType) {
            case 1:
                band = "½-Stoneband";
                break;
            case 2:
                band = "1/4-Stoneband";
                break;
            case 3:
                band = "Brick Band";
                break;
            case 4:
                band = "Cross Band";
                break;
            case 5:
                band = "English Band";
                break;
            default:
                throw new AssertionError();
        }
        BandCalculator q = new BandCalculator();
        int brickList[] = q.calculateBricks(width, length, height, bandType);
        session.setAttribute("brickList", brickList);
        session.setAttribute("width", width);
        session.setAttribute("length", length);
        session.setAttribute("height", height);
        session.setAttribute("band", band);

        request.getRequestDispatcher("calculateBricks.jsp").forward(request, response);

    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) session.getAttribute("user");
        int[] brickList = (int[]) session.getAttribute("brickList");
        int width = (int) session.getAttribute("width");
        int length = (int) session.getAttribute("length");
        int height = (int) session.getAttribute("height");
        String bandType = (String) session.getAttribute("band");

        int x4 = brickList[0] + brickList[3];
        int x2 = brickList[1] + brickList[4];
        int x1 = brickList[2] + brickList[5];
        d.insertOrder(width, length, height, bandType, x4, x2, x1, u.getEmail());
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    private void updateShipping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        d.setIsShipped(orderID);

        session.setAttribute("allUserOrders", d.getAllOrderList());

        request.getRequestDispatcher("admin.jsp").forward(request, response);
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
