package org.lepro.storeprojet;

import org.lepro.storeprojet.dao.ClientRepository;
import org.lepro.storeprojet.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreProjetApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 Client c = new Client("HAMED YOUSOUF", "Bangui", "hamded@gmail.com",
//		 "9665545454");
//		 clientRepository.save(new Client("NANA TANKWA ALDOF", "Quartier 2 Bgte", "nana@gmail.com", "63325458"));
//		 clientRepository.save(new Client("MADEFO NOELA", "Bonabeire 4",
//		 "noela@gmail.com", "6335585445"));
//
//		 clientRepository.findAll().forEach(cc -> {
//		 logger.info("Id:" + cc.getIdClient());
//		 });
	}
}
