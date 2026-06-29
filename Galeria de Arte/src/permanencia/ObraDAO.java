package permanencia;

import dados.Obra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObraDAO {

    public void inserir(Obra o) throws SQLException {
        String sql = "INSERT INTO Obra (titulo, ano, preco, imagem) VALUES (?, ?, ?, ?)";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, o.getTitulo());
        st.setInt(2, o.getAno());
        st.setDouble(3, o.getPreco());
        st.setBytes(4, o.getImagem());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            o.setCodObra(rs.getInt(1));
        }
        rs.close();
        st.close();
    }

    public void remover(int codObra) throws SQLException{
        String sql = "DELETE FROM Obra WHERE codObra = ?";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codObra);
        st.executeUpdate();
        st.close();
    }

    public List<Obra> listarTodos()  throws SQLException {
        String sql = "SELECT * FROM Obra";
        Connection con = ConexaoDB.getConexao();
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        List<Obra> lista = new ArrayList<>();
        while(rs.next()){
            Obra o = new Obra();
            o.setCodObra(rs.getInt(1));
            o.setTitulo(rs.getString(2));
            o.setAno(rs.getInt(3));
            o.setPreco(rs.getDouble(4));
            o.setImagem(rs.getBytes(5));
            lista.add(o);
        }
        return lista;
    }

}
