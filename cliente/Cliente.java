
package cliente;

import EJB.ejb.PessoaRemote;
import EJB.modelo.Pessoa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
    




import javax.naming.InitialContext;


public class Cliente {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws  Exception {
        InitialContext ctx;
        ctx = new InitialContext();
        PessoaRemote ejb = (PessoaRemote) ctx.lookup("EJB.ejb.PessoaRemote");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Pessoa p = new Pessoa();
        p.setNome("Paulo");
        p.setDatNasc(df.parse("04/12/1987"));
        p.setEmail("ca1@ufmt.br.com");
        
        Pessoa salvar = ejb.salvar(p);
        
        System.out.println("Pessoa salva com o id: "+salvar.getId());
        
        
        
    }
    
}
