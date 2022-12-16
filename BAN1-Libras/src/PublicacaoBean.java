
import java.util.Date;

/**
 *
 * @author desenv06
 */
public class PublicacaoBean {
    private int id;
    private int id_autor;
    private String texto;
    private int likes;
    private int deslikes;
    private Date dataPublicacao;
    private boolean removido;
    private String tipo_pub; 
    private int id_regiao;
    private int id_pub;
    private int id_mencao;
    private String arquivo;
    private UsuarioBean usuario;

    public PublicacaoBean(int id, int id_autor, String texto, int likes, int deslikes, Date dataPublicacao, boolean removido, String tipo_pub, int id_regiao, int id_pub, int id_mencao, String arquivo) {
        this.id = id;
        this.id_autor = id_autor;
        this.texto = texto;
        this.likes = likes;
        this.deslikes = deslikes;
        this.dataPublicacao = dataPublicacao;
        this.removido = removido;
        this.tipo_pub = tipo_pub;
        switch (tipo_pub) {
            case "P":
                this.id_regiao = id_regiao;
                break;
            case "R":
                this.id_pub = id_pub;
                this.arquivo = arquivo;
                break;
            case "C":
                this.id_pub = id_pub;
                this.id_mencao = id_mencao;
                break;
            default:
                break;
        }
    }
    
    public PublicacaoBean(int id_autor, String texto, int likes, int deslikes, Date dataPublicacao, String tipo_pub, int id_regiao, int id_pub, int id_mencao, String arquivo) {
        this.id_autor = id_autor;
        this.texto = texto;
        this.likes = likes;
        this.deslikes = deslikes;
        this.removido = false;
        this.dataPublicacao = dataPublicacao;
        this.tipo_pub = tipo_pub;
        switch (tipo_pub) {
            case "P":
                this.id_regiao = id_regiao;
                break;
            case "R":
                this.id_pub = id_pub;
                this.arquivo = arquivo;
                break;
            case "C":
                this.id_pub = id_pub;
                this.id_mencao = id_mencao;
                break;
            default:
                break;
        }
    }

    public PublicacaoBean(int id, String texto, int likes, int deslikes, Date dataPublicacao, boolean removido, String tipo_pub, int id_regiao, int id_pub, int id_mencao, String arquivo) {
        this.id = id;
        this.texto = texto;
        this.likes = likes;
        this.deslikes = deslikes;
        this.dataPublicacao = dataPublicacao;
        this.removido = removido;
        this.tipo_pub = tipo_pub;
        switch (tipo_pub) {
            case "P":
                this.id_regiao = id_regiao;
                break;
            case "R":
                this.id_pub = id_pub;
                this.arquivo = arquivo;
                break;
            case "C":
                this.id_pub = id_pub;
                this.id_mencao = id_mencao;
                break;
            default:
                break;
        }
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDeslikes() {
        return deslikes;
    }

    public void setDeslikes(int deslikes) {
        this.deslikes = deslikes;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isRemovido() {
        return removido;
    }

    public void setRemovido(boolean removido) {
        this.removido = removido;
    }

    public String getTipo_pub() {
        return tipo_pub;
    }

    public void setTipo_pub(String tipo_pub) {
        this.tipo_pub = tipo_pub;
    }

    public int getId_regiao() {
        return id_regiao;
    }

    public void setId_regiao(int id_regiao) {
        this.id_regiao = id_regiao;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public int getId_mencao() {
        return id_mencao;
    }

    public void setId_mencao(int id_mencao) {
        this.id_mencao = id_mencao;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Id: " + id;
        
        if(usuario != null){
            str += "\nNome: " + usuario.getNome() + ", Email: " + usuario.getEmail() + ", Id da Região: " + usuario.getRegiao() + ", Avaliação: " + usuario.getAvaliacao() + ", Nº de Denúncias: "+ usuario.getContadorDeDenuncias() + ", Admin? "+ usuario.getIsAdm();
        }else{
            str += ", Id do Autor: " + id_autor;
        }
        
        str += "\nTexto: \"" + texto + "\"\nLikes: " + likes + ", Deslikes: " + deslikes + "\nData de Publicação: " + dataPublicacao + "\nFoi removido? " + removido + "\nTipo da Publicação: ";
        
        switch (tipo_pub) {
            case "P":
                str += "Pergunta\nRegião da Pergunta: " + id_regiao;
                break;
            case "R":
                str += "Resposta\nId da Pergunta: " + id_pub + "\nLink do Arquivo: " + arquivo;
                break;
            case "C":
                str += "Comentário\nId da Publicação: " + id_pub + "\nUsuário Mencionado: " + id_mencao;
                break;
            default:
                break;
        }
        
        str += "\n";
        
        return str;
    }
    
    
}