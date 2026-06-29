package permanencia;

import dados.Comprador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {

    public void inserir(Comprador c) throws SQLException{
        String sql = "INSERT INTO Comprador (nome, pais, telefone) VALUES (?, ?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, c.getNome());
        st.setString(2, c.getPais());
        st.setString(3, c.getTelefone());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            c.setCodComprador(rs.getInt(1));
        }
        rs.close();
        st.close();
    }

    public void remover(int codComprador) throws SQLException{
        String sql = "DELETE FROM Comprador WHERE codComprador = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codComprador);
        st.executeUpdate();
        st.close();
    }

    public List<Comprador> listarTodos()  throws SQLException {
        String sql = "SELECT * FROM Comprador";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        List<Comprador> lista = new ArrayList<>();
        while(rs.next()){
            Comprador c = new Comprador();
            c.setCodComprador(rs.getInt("codComprador"));
            c.setNome(rs.getString("nome"));
            c.setPais(rs.getString("pais"));
            c.setTelefone(rs.getString("telefone"));
            lista.add(c);
        }
        return lista;
    }

}
