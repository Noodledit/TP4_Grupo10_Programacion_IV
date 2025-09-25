package servlets;

import dao.SeguroDao;
import dominio.Seguro;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AgregarSeguroServlet")
public class AgregarSeguroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        String descripcion = request.getParameter("txtNombre");
        String idTipoStr = request.getParameter("txtTipo");
        String costoContratacionStr = request.getParameter("txtCosto");
        String costoAseguradoStr = request.getParameter("txtCostoMaximo");

        if (descripcion == null || descripcion.trim().isEmpty()
                || idTipoStr == null || !idTipoStr.matches("\\d+")
                || costoContratacionStr == null || !costoContratacionStr.matches("\\d+(\\.\\d+)?")
                || costoAseguradoStr == null || !costoAseguradoStr.matches("\\d+(\\.\\d+)?")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Datos inválidos");
            return;
        }

        int idTipo = Integer.parseInt(idTipoStr);
        double costoContratacion = Double.parseDouble(costoContratacionStr);
        double costoAsegurado = Double.parseDouble(costoAseguradoStr);

        Seguro seg = new Seguro(descripcion, idTipo, costoContratacion, costoAsegurado);
        
        boolean ok = new SeguroDao().insert(seg);

        if (ok) {
            response.sendRedirect("Inicio.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo insertar");
        }
    }
}

