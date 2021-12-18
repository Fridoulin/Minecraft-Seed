package com.example.minecraftseed;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.RegisterService;
/**
 * Servlet implementation class DoRegister
 */
@WebServlet("/DoRegister")
public class DoRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Auslesen der Parameter
        String u = request.getParameter("name");
        String p = request.getParameter("password");
        String nn = request.getParameter("nachname");
        String e = request.getParameter("email");

        //Lösung der Aufgabe

        String success = RegisterService.getInstance().canRegister(e, p, u, nn);

        //Werte für die JSP als Attribute festhalten
        HttpSession session = request.getSession();
        session.setAttribute("email", e);
        session.setAttribute("passwort", p);
        session.setAttribute("vorname", u);
        session.setAttribute("nachname", nn);



        //Weiterleitung
        if(success.equals("ok")){
            RequestDispatcher d = request.getRequestDispatcher("index.jsp");
            d.forward(request, response);
        }else if(success.equals("email")){
            request.setAttribute("errMsg", "Email enthält kein @!");
            RequestDispatcher d = request.getRequestDispatcher("Register.jsp");
            d.forward(request,response);
        }else if(success.equals("vorna")){
            request.setAttribute("errMsg", "Passwort darf den Vor- oder Nachnamen nicht enthalten");
            RequestDispatcher d = request.getRequestDispatcher("Register.jsp");
            d.forward(request,response);
        }
        RequestDispatcher d = request.getRequestDispatcher("index.jsp");
        d.forward(request, response);

    }

}
