package com.example.demo;


import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.Commande;
import com.example.demo.repos.CommandeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entities.Client;


@SpringBootTest
class ClientsApplicationTests {
	
	
@Autowired
private CommandeRepository commandeRepository;




@Test
public void testCreateCommande() {
	Commande commande = new Commande(1000.0, LocalDate.now());
	commandeRepository.save(commande);
}


@Test
public void testFindCommande()
{
       Commande c = commandeRepository.findById(2L).get();
        System.out.println(c);
}


@Test
public void testUpdateCommande()
{
Commande c = commandeRepository.findById(2L).get();
c.setTotal(2000.0);
commandeRepository.save(c);
}




@Test
public void testDeleteCommande()
{
	commandeRepository.deleteById(1L);;
}


@Test
public void testListerTousCommandes()
{
List<Commande> clt = commandeRepository.findAll();
for (Commande c : clt)
{
System.out.println(c);
}
}

@Test
public void testFindCommandeByTotal()
{
	List<Commande> commandes = commandeRepository.findCommandeByTotal(1000.0);
	for (Commande c : commandes)
	System.out.println(c);
}


@Test
public void testFindCommandeByClient_NomClient()
{
	List<Commande> commandes = commandeRepository.findCommandeByClient_NomClient("riahi");
	for (Commande c : commandes)
	System.out.println(c);
}

@Test
public void testFindByTotalAndDateCreation()
{
	List<Commande> commandes = commandeRepository.findByTotalAndDateCreation(1000.0, LocalDate.now());
	for (Commande p : commandes)
	{
		System.out.println(p);
	}
}

	@Test
	public void testfindByClient()
	{
		Client client = new Client();
		client.setIdClient(1L);
		List<Commande> commandes = commandeRepository.findByClient(client);
		for (Commande p : commandes)
		{
			System.out.println(p);
		}
	}


	@Test
	public void testfindByClientIdClient()
	{
		List<Commande> commandes = commandeRepository.findByClientIdClient(2L);
		for (Commande p : commandes)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testfindByOrderByTotalAsc()
	{
		List<Commande> commandes =
				commandeRepository.findByOrderByTotalAsc();
		for (Commande p : commandes)
		{
			System.out.println(p);
		}
	}
	@Test
	public void testTrierCommandesTotalDateCreation()
	{
		List<Commande> prods = commandeRepository.trierCommandesTotalDateCreation();
		for (Commande p : prods)
		{
			System.out.println(p);
		}
	}
}




