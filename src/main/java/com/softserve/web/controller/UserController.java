package com.softserve.web.controller;

import com.google.gson.Gson;
import com.softserve.web.dto.ResponceDto;
import com.softserve.web.dto.RoleProfile;
import com.softserve.web.dto.UserProfile;
import com.softserve.web.services.UserWebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({ "/user" })
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson;
    //private AppService appService;
    private UserWebService userWebService;

    public UserController() {
        super();
        System.out.println("\tConstructor public UserController() done");
        // TODO Auto-generated constructor stub
        gson = new Gson();
        //appService = new AppService();
        userWebService = new UserWebService();
    }

    private UserProfile fromJson(HttpServletRequest request) {
        String json = null;
        try (BufferedReader reader = request.getReader()) {
            json = reader.readLine();
        } catch (Exception e) {
            System.out.println("Exception e = " + e);
        }
        UserProfile userProfile = gson.fromJson(json, UserProfile.class);
        return userProfile;
    }

    private void sendJson(ResponceDto responceDto, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(responceDto));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponceDto responceDto = userWebService.getAllUsers();
        sendJson(responceDto, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProfile userProfile = fromJson(request);
        ResponceDto responceDto = userWebService.addUser(userProfile);
        sendJson(responceDto, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProfile userProfile = fromJson(request);
        ResponceDto responceDto = userWebService.updateUser(userProfile);
        sendJson(responceDto, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProfile userProfile = fromJson(request);
        ResponceDto responceDto = userWebService.deleteUser(userProfile);
        sendJson(responceDto, response);
    }
}
