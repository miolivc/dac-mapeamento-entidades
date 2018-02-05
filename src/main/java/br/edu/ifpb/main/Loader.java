/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.main;

import br.edu.ifpb.domain.Contato;
import br.edu.ifpb.domain.ContatoPK;
import br.edu.ifpb.domain.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ifpb
 */
public class Loader {

    public static void main(String[] args) {

        EntityManager manager
                = Persistence.createEntityManagerFactory("jpa-mapeamento")
                        .createEntityManager();

        Telefone tel = new Telefone("Residencial", "3531-4657");
        Contato contato = new Contato("Dona", "Florinda", "florinda", "Sei lá man");
        contato.getEmails().add("florinda@gmail.com");
        contato.getEmails().add("d.florinda@gmail.com");
        contato.getTelefones().add(tel);

        manager.getTransaction().begin();
        manager.persist(contato);
        manager.getTransaction().commit();

        ContatoPK pk = new ContatoPK("Dona", "Florinda");
        Contato find = manager.find(Contato.class, pk);
        System.out.println("O contato achado foi: " + find);
    }

}
