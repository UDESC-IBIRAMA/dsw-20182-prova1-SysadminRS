
package br.com.udesc.prova01robson.dao;

import br.com.udesc.prova01robson.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SYSADMIN
 */
public class ClienteDao extends GenericDao{


    public List<Cliente> buscarTodos() {
        EntityManager em = getEntityManager();
        Query buscar = em.createNamedQuery("Cliente.todosCli");
        return buscar.getResultList();
    }

    public Cliente getClienteById(long id) {
        return (Cliente) ler(Cliente.class, id);
    }
    
    public void modifyClienteById(Cliente oCliente){
        
        Cliente valida = getClienteById(oCliente.getId());
        if (valida != null) {
            atualizar(oCliente);
        }
    }
    
    


    
}
