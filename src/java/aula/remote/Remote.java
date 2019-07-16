
package aula.remote;

import aula.modelo.Pessoa;

@javax.ejb.Remote
public interface Remote {
    public Pessoa salvar(Pessoa p) throws Exception;
    
    public Pessoa consultarPorId(Long id);
    
    public void remover (Long id);
}
