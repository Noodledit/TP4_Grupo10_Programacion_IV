package servlets;

import java.io.IOException;
import java.util.ArrayList; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TipoSeguro;
import dao.SeguroDAO;

@WebServlet("/ListarSegurosServlet")
public class ListarSegurosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarSegurosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
		SeguroDAO sDao = new SeguroDAO();

		if (request.getParameter("btnFiltrar") != null) {
			ArrayList<TipoSeguro> listaTS = sDao.listarTipoSeguros();
			request.setAttribute("ListaTS", listaTS);
			request.getDispatcherType();
			rd.forward(request, response);
		}
	}
}
