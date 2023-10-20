package ch.cristiano.vehicle.server;

import java.util.List;
import java.util.stream.IntStream;

import org.openapitools.abstraction.model.VehicleColor;
import org.openapitools.abstraction.model.VehicleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import ch.cristiano.vehicle.server.persistence.BmwEntity;
import ch.cristiano.vehicle.server.persistence.CarEntity;
import ch.cristiano.vehicle.server.persistence.CicleEntity;
import ch.cristiano.vehicle.server.persistence.FerrariEntity;
import ch.cristiano.vehicle.server.persistence.TruckEntity;
import ch.cristiano.vehicle.server.persistence.VehicleEntity;
import ch.cristiano.vehicle.server.persistence.VehicleRepository;

@SpringBootApplication
public class VehicleServerApplication {

	private static final Logger logger = LoggerFactory.getLogger(VehicleServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VehicleServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(VehicleRepository vehicleRepository) {
		return (args) -> {

			Faker faker = new Faker();

			List<BmwEntity> bmws = IntStream.rangeClosed(1, 50)
					.mapToObj(i -> new BmwEntity(VehicleType.CAR.name(),
							VehicleColor.values()[faker.random().nextInt(VehicleColor.values().length)].name(),
							faker.lorem().fixedString(5),
							"dummy1"))
					.toList();

			List<FerrariEntity> ferraris = IntStream.rangeClosed(1, 50)
					.mapToObj(i -> new FerrariEntity(VehicleType.CAR.name(),
							VehicleColor.values()[faker.random().nextInt(VehicleColor.values().length)].name(),
							faker.lorem().fixedString(5),
							"dummy2"))
					.toList();

			List<TruckEntity> trucks = IntStream.rangeClosed(1, 50)
					.mapToObj(i -> new TruckEntity(VehicleType.TRUCK.name(),
							VehicleColor.values()[faker.random().nextInt(VehicleColor.values().length)].name(),
							faker.lorem().fixedString(5),
							8))
					.toList();

			List<CicleEntity> cicles = IntStream.rangeClosed(1, 50)
					.mapToObj(i -> new CicleEntity(VehicleType.CICLE.name(),
							VehicleColor.values()[faker.random().nextInt(VehicleColor.values().length)].name(),
							faker.lorem().fixedString(5),
							faker.random().nextBoolean()))
					.toList();

			vehicleRepository.saveAll(bmws);
			vehicleRepository.saveAll(ferraris);
			vehicleRepository.saveAll(trucks);
			vehicleRepository.saveAll(cicles);

			logger.info("Vehicles found in the database findAll()");
			for (VehicleEntity vehicle : vehicleRepository.findAll()) {
				logger.info(vehicle.toString());
			}
		};
	}

}
