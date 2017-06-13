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
public class DeleteData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int userId = Integer.parseInt(request.getParameter("userId"));
        Session session = null;
        Revisiontable rt = new Revisiontable();
        rt.setId(userId);
        try {
            session = RevisionHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "DELETE FROM Revisiontable r where r.id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", rt.getId());
            int a = query.executeUpdate();
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        response.sendRedirect("index.jsp");

    }
}
