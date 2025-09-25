package dao;

import java.util.ArrayList;
import java.util.List;

import dao.Conexion;
import dominio.Seguro;
import dominio.TipoSeguro;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class SeguroDao {

	    public boolean insert(Seguro s) {
	        try (Connection conn = Conexion.getConnection();
	             PreparedStatement ps = conn.prepareStatement("INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)")) {

	            ps.setString(1, s.getDescripcion());
	            ps.setInt(2, s.getIdTipo());
	            ps.setDouble(3, s.getCostoContracion());
	            ps.setDouble(4, s.getCostoAsegurado());

	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	
	
	public List<TipoSeguro> listarTipoSeguros(){
		
		List<TipoSeguro> ListaTipoSeguro = new ArrayList<>();
		
		String consulta = "SELECT * FROM tiposeguros";
		try(Connection conn = Conexion.getConnection();
		PreparedStatement pst = conn.prepareStatement(consulta)){
			
			ResultSet Listado = pst.executeQuery();
			
			while(Listado.next()) {
				TipoSeguro ts = new TipoSeguro();
				ts.setIdTipo(Listado.getInt("idTipo"));
				ts.setDescripcion(Listado.getString("descripcion"));			
				ListaTipoSeguro.add(ts);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ListaTipoSeguro;

		
	}
	
	public List<Seguro> FiltrarPorTipo(int id ){
		List<Seguro> ListaSeguros = new ArrayList<>();
		String consulta = "SELECT * FROM Seguros WHERE idTipo = ?";
		
		try(Connection conn = Conexion.getConnection();
		PreparedStatement pst = conn.prepareStatement(consulta)){
			
			pst.setInt(1, id);
			
			ResultSet Listado = pst.executeQuery();
			
			while(Listado.next()) {
				Seguro s = new Seguro();
				s.setIdSeguro(Listado.getInt("idSeguro"));
                s.setDescripcion(Listado.getString("descripcion"));
                s.setIdTipo(Listado.getInt("idTipo"));
                s.setCostoContracion(Listado.getDouble("costoContracion"));
                s.setCostoAsegurado(Listado.getDouble("costoAsegurado"));	
				ListaSeguros.add(s);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ListaSeguros;

		
	}


}