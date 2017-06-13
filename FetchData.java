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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ignite259
 */
public class FetchData extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Session session = null;
//        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            session = RevisionHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT c From Revisiontable c";
            Query query = session.createQuery(hql);
            List<Revisiontable> listData = query.list();
            for (int i = 0; i < listData.size(); i++) {
                JSONObject jsono = new JSONObject();
                jsono.put("UserId", listData.get(i).getId());
                jsono.put("Email", listData.get(i).getEmail());
                jsono.put("Password", listData.get(i).getPassword());
                array.add(jsono);
            }
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        out.print(array);
    }
    
}
