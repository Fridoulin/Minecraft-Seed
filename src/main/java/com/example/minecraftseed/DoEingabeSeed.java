package com.example.minecraftseed;

        import java.io.IOException;
        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import models.EingabeSeedService;

/**
 * Servlet implementation class DoEingabeSeed
 */
@WebServlet("/DoEingabeSeed")
public class DoEingabeSeed extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEingabeSeed() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Auslesen der Parameter
        String s = request.getParameter("seed");
        String b = request.getParameter("beschreibung");

        boolean success = EingabeSeedService.getInstance().canInputSeed(s,b);


        //Werte für die JSP als Attribute festhalten
        HttpSession session = request.getSession();
        session.setAttribute("seed", s);
        session.setAttribute("beschreibung", b);

        //Weiterleitung
        if(success){
            RequestDispatcher d = request.getRequestDispatcher("EingabeSeed.jsp");
            d.forward(request, response);
        }else{
            request.setAttribute("errMsg", "Falsche Eingabe");
            RequestDispatcher d = request.getRequestDispatcher("EingabeSeed.jsp");
            d.forward(request, response);
        }



    }

}
