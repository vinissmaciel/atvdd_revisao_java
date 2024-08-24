
public class Usuario {

    private String nome;
    private String email;

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Usuario usuario) {
            return usuario.getEmail().equals(this.getEmail());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome:" + this.getNome() + " Email:" + this.getEmail();
    }
}
