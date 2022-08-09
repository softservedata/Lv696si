package com.softserve.web.controller;

import com.google.gson.Gson;
import com.softserve.db.services.AppService;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSourceRepository;
import com.softserve.web.services.RoleWebService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/", "/app" })
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AppService appService;

    public AppController() {
        super();
        System.out.println("\tConstructor public AppController() done");
        // TODO Auto-generated constructor stub
        appService = new AppService();
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        //ConnectionManager.getInstance(DataSourceRepository.getMySqlVM());
        //ConnectionManager.getInstance(DataSourceRepository.getMySqlProperties());
        ConnectionManager.getInstance(DataSourceRepository.getPostgreSqlProperties());
        appService.checkDatabase();
        System.out.println("\tpublic void init(ServletConfig config) done");
    }

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("\tpublic void destroy() done");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String base = request.getRequestURI().toString();
        base = base.replaceAll("/app$|/$", "");
        response.setContentType("application/json; charset=UTF-8");
        response.sendRedirect(base + "/role");
    }

}
