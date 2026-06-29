package dados;

import java.sql.Date;

public class Artista {
    private int codArtista;
    private String nome;
    private String nacionalidade;
    private Date dataNascimento;

    public Artista() {}

    public Artista(String nome, String nasc, Date dataNasc) {
        this.nome = nome;
        this.nacionalidade = nasc;
        this.dataNascimento = dataNasc;
    }

    public int getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(int codArtista) {
        this.codArtista = codArtista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        String s = "";
        s += "Nome: " + nome + "\n";;
        s += "Nacionalidade: " + nacionalidade + "\n";
        s += "Data de Nascimento: " + dataNascimento + "\n";
        s += "Codigo: " + codArtista + "\n";
        return s;
    }
}
