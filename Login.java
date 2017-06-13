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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ignite259
 */
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pswrd = request.getParameter("password");
        Revisiontable rt = new Revisiontable();
        rt.setEmail(email);
        rt.setPassword(pswrd);
        Session session = null;
        try {
            session = RevisionHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT c From Revisiontable c where c.email=:email and c.password=:password";
            Query query = session.createQuery(hql);
            query.setParameter("email", rt.getEmail());
            query.setParameter("password", rt.getPassword());
            rt = (Revisiontable) query.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (rt != null) {
            response.sendRedirect("register.jsp");
        } else {
            out.println("Login failed");
        }
        
    }
}
