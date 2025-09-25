package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.TipoSeguro;

public class TipoSeguroDAO {
    
    private static final String GET_ALL = "SELECT idTipo, descripcion FROM tipoSeguros ORDER BY descripcion";
    
    public List<TipoSeguro> getAll() {
        List<TipoSeguro> tipos = new ArrayList<>();
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_ALL);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TipoSeguro tipo = new TipoSeguro();
                tipo.setIdTipo(rs.getInt("idTipo"));
                tipo.setDescripcion(rs.getString("descripcion"));
                tipos.add(tipo);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tipos;
    }
}
