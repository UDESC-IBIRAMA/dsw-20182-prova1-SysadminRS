/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.udesc.prova01robson.controller;

import br.com.udesc.prova01robson.dao.ClienteDao;
import br.com.udesc.prova01robson.model.Cliente;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author SYSADMIN
 */
@Path("cliente")
public class GenericResource {

    private ClienteDao persistencia = new ClienteDao();

    public GenericResource() {
    }

    @GET
    @Path("/teste")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getJson() {
        Cliente oCliente = new Cliente();
        oCliente.setId(1L);
        oCliente.setNome("robson");
        oCliente.setDataCadastro(new Date("20181008"));
        return oCliente;
    }
    
    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarTodos() {
        ClienteDao busca = new ClienteDao();
        List<Cliente> todos = busca.buscarTodos();
        return todos;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addCliente(Cliente oCliente) {
        String feedback = "";
        try {
            persistencia.salvar(oCliente);
            feedback = "Os seguintes dados foram inseridos:\n" + oCliente.toString();
        } catch (Exception e) {
            e.printStackTrace();
            feedback = "Erro ao inserir dados!\n" + e.getMessage();
        }
        return feedback;
    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCliente(Cliente oCliente) {
        try {
            persistencia.modifyClienteById(oCliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
