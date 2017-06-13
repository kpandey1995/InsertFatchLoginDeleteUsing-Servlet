/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.servlets;

import com.tcs.ignite.models.Revisiontable;
import com.tcs.ignite.utils.RevisionHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

public class PractiseServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pswrd = request.getParameter("password");
        Session is = null;
        Revisiontable rt = new Revisiontable();
        rt.setEmail(email);
        rt.setPassword(pswrd);
        try {
            is = RevisionHibernateUtil.getSessionFactory().openSession();
            is.beginTransaction();
            is.save(rt);
            is.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Exception" + e.getMessage());
            is.getTransaction().rollback();
            
        } finally {
            is.close();
        }
        response.sendRedirect("index.jsp");
    }
}
