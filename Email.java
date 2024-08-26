
import java.util.ArrayList;
import java.util.List;

public class Email {

    private Integer id;
    private String assunto;
    private String mensagem;
    private Usuario de;
    private List<Usuario> listaPara = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getDe() {
        return de;
    }

    public void setDe(Usuario de) {
        this.de = de;
    }

    public List<Usuario> getListaPara() {
        return listaPara;
    }

    public void setListaPara(List<Usuario> listaPara) {
        this.listaPara = listaPara;
    }

    public boolean existeEmail(String email) {
        Usuario user = new Usuario();
        user.setEmail(email);
        for (Usuario u : this.getListaPara()) {
            if (u.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionaListaPara(Usuario u) {
        if (!this.existeEmail(u.getEmail())) {
            this.getListaPara().add(u);
            return true;
        }
        System.out.println("\nUsuário de email " + u.getEmail() + " duplicado!");
        return false;
    }

    @Override
    public String toString() {
        return "\nDe: " + this.getDe().toString() + "\nPara: " + this.getListaPara().toString()
                + "\nAssunto: " + this.getAssunto() + "\nMensagem: " + this.getMensagem()+"\n";
    }
}
