package com.example.minecraftseed;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.LoginService;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
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
        String u = request.getParameter("email");
        String p = request.getParameter("password");

        boolean success = LoginService.getInstance().canLogin(u, p);


        //Lösung der Aufgabe


        //Werte für die JSP als Attribute festhalten
        HttpSession session = request.getSession();
        session.setAttribute("email", u);
        session.setAttribute("passwort", p);

        //Weiterleitung
        if(success){
            RequestDispatcher d = request.getRequestDispatcher("EingabeSeed.jsp");
            d.forward(request, response);
        }else{
            request.setAttribute("errMsg", "Email oder Passowrt ist falsch");
            RequestDispatcher d = request.getRequestDispatcher("index.jsp");
            d.forward(request, response);
        }



    }

}
