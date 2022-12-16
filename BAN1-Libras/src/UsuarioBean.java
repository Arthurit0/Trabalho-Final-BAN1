/**
 *
 * @author desenv06
 */
public class UsuarioBean {
    private int id;
    private String nome;
    private String email;
    private int regiao;
    private float avaliacao;
    private String instituicao;
    private String profissao;
    private String senha;
    private int contadorDeDenuncias;
    private boolean isAdm;

    public UsuarioBean(int id, String nome, String email, int regiao, float avaliacao, String instituicao, String profissao, String senha, int contadorDeDenuncias, boolean isAdm) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.regiao = regiao;
        this.avaliacao = avaliacao;
        this.instituicao = instituicao;
        this.profissao = profissao;
        this.senha = senha;
        this.contadorDeDenuncias = contadorDeDenuncias;
        this.isAdm = isAdm;
    }

    public UsuarioBean(String nome, String email, int regiao, float avaliacao, String instituicao, String profissao, String senha, int contadorDeDenuncias, boolean isAdm) {
        this.nome = nome;
        this.email = email;
        this.regiao = regiao;
        this.avaliacao = avaliacao;
        this.instituicao = instituicao;
        this.profissao = profissao;
        this.senha = senha;
        this.contadorDeDenuncias = contadorDeDenuncias;
        this.isAdm = isAdm;
    }

    public UsuarioBean(int id, String nome, String email, int regiao, float avaliacao, int contadorDeDenuncias, boolean isAdm) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.regiao = regiao;
        this.avaliacao = avaliacao;
        this.contadorDeDenuncias = contadorDeDenuncias;
        this.isAdm = isAdm;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegiao() {
        return regiao;
    }

    public void setRegiao(int regiao) {
        this.regiao = regiao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getContadorDeDenuncias() {
        return contadorDeDenuncias;
    }

    public void setContadorDeDenuncias(int contadorDeDenuncias) {
        this.contadorDeDenuncias = contadorDeDenuncias;
    }       

    public boolean getIsAdm() {
        return isAdm;
    }

    public void setIsAdm(boolean isAdm) {
        this.isAdm = isAdm;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Nome: " + nome + " | Email: " + email + " | Região: " + regiao + " | Avaliação: " + avaliacao + " | Instituição: " + instituicao + " | Profissão: " + profissao + " | Nº de Denúncias: " + contadorDeDenuncias + " | É admin: " + isAdm;
    }

    
    
}
