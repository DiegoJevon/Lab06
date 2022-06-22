package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Maia
 */
public class ShoppingListServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
        String operation = request.getParameter("action");
                        
        if(operation != null && operation.equals("logout")){ 
            session.invalidate(); 
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        return;
        }
        if (username != null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response);
            return;
            
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        return;

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         
         String username = request.getParameter("username");
         
         
         ArrayList<String> shopCart = (ArrayList<String>) session.getAttribute("shopCart");
          
         
         String operation = request.getParameter("action");
         String itemName = request.getParameter("item_name");
         
         
         if (operation != null && operation.equals("register")){
            session.setAttribute("username", username);
            response.sendRedirect("shoppingList");
            return; 
         } else if(operation != null && operation.equals("add")){
             if (shopCart == null){
                 shopCart = new ArrayList();
                 shopCart.add(itemName);
                session.setAttribute("shopCart", shopCart);
                 
             }else {
                shopCart.add(itemName);
                session.setAttribute("shopCart", shopCart);
             }
         } else if (operation != null && operation.equals("delete")){
            String deleteItem = request.getParameter("to_delete");
            shopCart.remove(deleteItem);
            session.setAttribute("shopCart", shopCart);
         } else if(operation != null && operation.equals("logout")){ 
            session.invalidate();
           
    } 
         getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response);
            return;
    }
}
