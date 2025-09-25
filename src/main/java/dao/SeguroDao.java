package dao;

import dominio.Seguro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeguroDAO {
    private static final String INSERT =
        "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";

    public boolean insert(Seguro s) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT)) {

            ps.setString(1, s.getDescripcion());
            ps.setInt(2, s.getIdTipo());
            ps.setDouble(3, s.getCostoContratacion());
            ps.setDouble(4, s.getCostoAsegurado());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
