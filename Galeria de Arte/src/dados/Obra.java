package dados;

public class Obra {
    private int codObra;
    private String titulo;
    private int ano;
    private double preco;
    private byte[] imagem;

    public int getCodObra() {
        return codObra;
    }

    public void setCodObra(int codObra) {
        this.codObra = codObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String toString(){
        String s = "";
        s += "Titulo: " + titulo + "\n";
        s += "Ano: " + ano + "\n";
        s += "Preco: " + preco + "\n";
        s += "Codigo: " + codObra + "\n";
        return s;
    }

    public Obra(String titulo, int ano, double preco, byte[] imagem) {
        this.titulo = titulo;
        this.ano = ano;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Obra() {
    }

}
