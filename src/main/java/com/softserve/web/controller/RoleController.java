package com.softserve.web.controller;

import com.google.gson.Gson;
import com.softserve.db.services.AppService;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSourceRepository;
import com.softserve.web.dto.ResponceDto;
import com.softserve.web.dto.RoleProfile;
import com.softserve.web.services.RoleWebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Role
 */
@WebServlet({ "/role" })
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson;
	//private AppService appService;
	private RoleWebService roleWebService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleController() {
        super();
		System.out.println("\tConstructor public RoleController() done");
        // TODO Auto-generated constructor stub
		gson = new Gson();
		//appService = new AppService();
		roleWebService = new RoleWebService();
    }

	/*
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//ConnectionManager.getInstance(DataSourceRepository.getMySqlVM());
		ConnectionManager.getInstance(DataSourceRepository.getMySqlProperties());
		//ConnectionManager.getInstance(DataSourceRepository.getPostgreSqlProperties());
		appService.checkDatabase();
		System.out.println("\tpublic void init(ServletConfig config) done");
	}
	*/

	/*
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("\tpublic void destroy() done");
	}
	*/

	private RoleProfile fromJson(HttpServletRequest request) {
		String json = null;
		try (BufferedReader reader = request.getReader()) {
			json = reader.readLine();
		} catch (Exception e) {
			System.out.println("Exception e = " + e);
		}
		RoleProfile roleProfile = gson.fromJson(json, RoleProfile.class);
		return roleProfile;
	}

	private void sendJson(ResponceDto responceDto, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(responceDto));
		out.close();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		System.out.println("***Method GET");
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Map.Entry<String, String[]> param : requestParams.entrySet()) {
			System.out.println("key = " + param.getKey() + " value =  " + Arrays.toString(param.getValue()));
		}
		*/
		//
		ResponceDto responceDto = roleWebService.getAllRoles();
		sendJson(responceDto, response);
		//
		/*
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"key\":\"value doGet\"}");
		out.close();
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*
		System.out.println("***Method POST");
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Map.Entry<String, String[]> param : requestParams.entrySet()) {
			System.out.println("key = " + param.getKey() + " value =  " + Arrays.toString(param.getValue()));
		}
		//
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				System.out.println("Read Line = " + line);
				sb.append(line);
		} catch (Exception e) {
			System.out.println("Exception e = " + e);
		}
		System.out.println("StringBuilder sb = " + sb);
		*/
		//
		RoleProfile roleProfile = fromJson(request);
		ResponceDto responceDto = roleWebService.addRole(roleProfile);
		sendJson(responceDto, response);
		/*
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"key\":\"value doPost\"}");
		out.close();
		*/
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		RoleProfile roleProfile = fromJson(request);
		ResponceDto responceDto = roleWebService.updateRole(roleProfile);
		sendJson(responceDto, response);
		//
		/*
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"key\":\"value doPut\"}");
		out.close();
		*/
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		RoleProfile roleProfile = fromJson(request);
		ResponceDto responceDto = roleWebService.deleteRole(roleProfile);
		sendJson(responceDto, response);
		//
		/*
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"key\":\"value doDelete\"}");
		out.close();
		*/
	}

	//@Override
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"key\":\"value doPatch\"}");
		out.close();
	}

}