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
	
	public List<TipoSeguro> FiltrarTipoSeguros(int id ){
		List<TipoSeguro> ListaTipoSeguro = new ArrayList<>();
		
		String consulta = "SELECT * FROM tipoSeguros WHERE idTipo = ?";
		
		try(Connection conn = Conexion.getConnection();
		PreparedStatement pst = conn.prepareStatement(consulta)){
			
			pst.setInt(1, id);
			
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


}