package permanencia;


import dados.Registro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {

    public void inserir(Registro r) throws SQLException {
        String sql = "INSERT INTO Registro (codComprador, codObra, numRegistro, dtVenda, formaPgto, descricao, precoFinal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, r.getCodComprador());
        st.setInt(2, r.getCodObra());
        st.setInt(3, r.getNumRegistro());
        st.setDate(4, r.getDtVenda());
        st.setString(5, r.getFormaPgto());
        st.setString(6, r.getDescricao());
        st.setDouble(7, r.getPrecoFinal());
        st.executeUpdate();

        st.close();
    }

    public void remover(int codComprador, int codObra) throws SQLException{
        String sql = "DELETE FROM Registro WHERE codComprador = ? AND codObra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codComprador);
        st.setInt(2, codObra);
        st.executeUpdate();
        st.close();
    }

    public List<Registro> listarTodos()  throws SQLException {
        String sql = "SELECT * FROM Registro";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        List<Registro> lista = new ArrayList<>();
        while(rs.next()){
            Registro r = new Registro();
            r.setCodComprador(rs.getInt("codComprador"));
            r.setCodObra(rs.getInt("codObra"));
            r.setNumRegistro(rs.getInt("numRegistro"));
            r.setDtVenda(rs.getDate("dtVenda"));
            r.setFormaPgto(rs.getString("formaPgto"));
            r.setDescricao(rs.getString("descricao"));
            r.setPrecoFinal(rs.getDouble("precoFinal"));
            lista.add(r);
        }
        return lista;
    }

    public boolean obraVendida(int codObra) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Registro WHERE codObra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codObra);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }
}
