
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciaEmail {

    private Map<Integer, Email> cEmail = new HashMap<>();
    private Map<String, Usuario> cUsuario = new HashMap<>();

    private boolean adicionaContato(Usuario u) {
        if (!this.cUsuario.containsKey(u.getEmail())) {
            this.cUsuario.put(u.getEmail(), u);
            return true;
        }
        System.out.println("\nO contato " + u.getEmail() + " já está cadastrado!");
        return false;
    }

    private boolean adicionaEmail(Email e, String emailDe, String emailPara) {
        if (this.cUsuario.containsKey(emailDe)) {
            if (!cEmail.containsKey(e.getId())) {
                e.setDe(cUsuario.get(emailDe));

                String[] tempPara = emailPara.split(";");
                for (int i = 0; i < tempPara.length; i++) {
                    e.adicionaListaPara(cUsuario.get(tempPara[i]));
                }

                cEmail.put(e.getId(), e);
                return true;
            }
            System.out.println("\nO email de ID " + e.getId() + " já está cadastrado!");
            return false;
        }
        System.out.println("\nO contato " + emailDe + " não está cadastrado!");
        return false;
    }

    private ArrayList listaEmailPara(String emailPara) { // Retorna uma lista com emails que o parâmetro emailPara está presente na lista para de usuários
        ArrayList<Email> lista = new ArrayList<>();

        for(Email email : cEmail.values()){
            if(email.existeEmail(emailPara)){
                lista.add(email);
            }
        }

        return lista;
    }

    private ArrayList listaEmailNomePara(String nome) {// Retorna uma lista com emails que o parâmetro nome está presente na lista para de usuários
        ArrayList<Email> lista = new ArrayList<>();

        for(Email email : cEmail.values()){
            for(Usuario usuario : email.getListaPara()){
                if(usuario.getNome().equals(nome)){
                    lista.add(email);
                }
            }
        }

        return lista;
    }

    public static void main(String args[]) {
        GerenciaEmail ge = new GerenciaEmail();
        Usuario[] u = new Usuario[3];
        u[0] = new Usuario();
        u[0].setEmail("carla@gmail.com");
        u[0].setNome("carla");
        ge.adicionaContato(u[0]);

        u[1] = new Usuario();
        u[1].setEmail("pedro@gmail.com");
        u[1].setNome("pedro");
        ge.adicionaContato(u[1]);

        u[2] = new Usuario();
        u[2].setEmail("maria@gmail.com");
        u[2].setNome("maria");
        ge.adicionaContato(u[2]);

        Email[] e = new Email[3];
        e[0] = new Email();
        e[0].setId(new Integer(1));
        e[0].setAssunto("Data da Prova");
        e[0].setMensagem("Prezados, Data da prova dia 18/04/2008");
        ge.adicionaEmail(e[0], "pedro@gmail.com", "carla@gmail.com;maria@gmail.com");

        e[1] = new Email();
        e[1].setId(new Integer(2));
        e[1].setAssunto("Lista de Exercício");
        e[1].setMensagem("Prezados, Segue anexo lista de exercício. Att, Maria");
        ge.adicionaEmail(e[1], "maria@gmail.com", "carla@gmail.com;pedro@gmail.com");

        e[2] = new Email();
        e[2].setId(new Integer(3));
        e[2].setAssunto("Festa");
        e[2].setMensagem("Prezados, A festa sera dia 20/06 ás 18:00");
        ge.adicionaEmail(e[2], "pedro@gmail.com", "carla@gmail.com");

        System.out.println(ge.listaEmailNomePara("pedro"));
        System.out.println(ge.listaEmailPara("carla@gmail.com"));
    }
}
