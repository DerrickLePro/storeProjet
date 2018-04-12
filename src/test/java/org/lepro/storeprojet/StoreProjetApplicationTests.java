package org.lepro.storeprojet;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.metier.IAdminMetier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreProjetApplicationTests {
	Logger logger = Logger.getLogger(StoreProjetApplicationTests.class);

	@Test
	public void contextLoads() {
		try {

			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });

			IAdminMetier metier = (IAdminMetier) app.getBean("metier");
			Client c = new Client("ZEBAZE ANDMI", "NGUI", "ZEABA@gmail.com", "56232344");

			List<Client> lstCl = metier.listClient();

			metier.ajouterClient(c);

			List<Client> lstCl2 = metier.listClient();

			assertTrue(lstCl.size() + 1 == lstCl2.size());

		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
