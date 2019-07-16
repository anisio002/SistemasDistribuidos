
package aula.dao;

import aula.modelo.Pessoa;
import javax.persistence.EntityManager;

public class PessoaDAO {
    private EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }
    //salva uma pessoa
    public Pessoa salvar(Pessoa p) throws Exception{
        if (p.getId() == null) 
            em.persist(p);
        else{
            if (em.find(Pessoa.class, p.getId())== null)
                throw new Exception("Falha na inserção!!!");
            p = em.merge(p);
        }
        return p;
        
    }
    //consulta se existe uma pessoa
    public Pessoa consultarPorId(Long id){
        return em.find(Pessoa.class, id);
    }
    
    // remove uma pessoa
    public void remover (Long id){
        Pessoa p = consultarPorId(id);
        em.remove(p);
    }
    
    
    
}
