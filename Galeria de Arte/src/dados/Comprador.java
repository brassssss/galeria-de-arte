package dados;

public class Comprador {
    private int codComprador;
    private String nome;
    private String pais;
    private String telefone;

    public int getCodComprador() {
        return codComprador;
    }

    public void setCodComprador(int codComprador) {
        this.codComprador = codComprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Comprador() {}

    public Comprador(String nome, String pais, String telefone) {
        this.nome = nome;
        this.pais = pais;
        this.telefone = telefone;
    }

    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";
        s += "Pais: " + pais + "\n";
        s += "Telefone: " + telefone + "\n";
        s += "Codigo: " + codComprador + "\n";
        return s;
    }


}
