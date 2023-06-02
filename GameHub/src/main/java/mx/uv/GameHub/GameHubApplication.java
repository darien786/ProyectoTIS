package mx.uv.GameHub;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.uv.GameHub.Entitys.Categoria;
import mx.uv.GameHub.Entitys.Equipo;
import mx.uv.GameHub.Repositorys.CategoriaRepository;
import mx.uv.GameHub.Repositorys.EquipoRepository;

@SpringBootApplication
public class GameHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameHubApplication.class, args);
	}
	
	@Bean
CommandLineRunner commandLineRunner(CategoriaRepository categoriaRepository, EquipoRepository equipoRepository) {
    Random random = new Random();
    return args -> {
        List.of("Computadora", "Consola").forEach(cat -> {
            Categoria categoria = Categoria.builder().nombre(cat).build();
            categoriaRepository.save(categoria);
        });
        categoriaRepository.findAll().forEach(categoria -> {
            for (int i = 0; i < 5; i++) {
                if (categoria.getNombre().equals("Computadora")) {
                    Equipo equipo = Equipo.builder()
                            .dispositivo((long) i)
                            .nombre("NovaGamer")
                            .marca("Dell G Series")
                            .estado("Disponible")
                            .condicion("En funcionamiento")
                            .categoria(categoria)
                            .build();
                    equipoRepository.save(equipo);
                } else if (categoria.getNombre().equals("Consola")) {
                    Equipo equipo = Equipo.builder()
                            .dispositivo((long)i+5)
                            .nombre("Series S")
                            .marca("Xbox")
                            .estado("Disponible")
                            .condicion("En funcionamiento")
                            .categoria(categoria)
                            .build();
                    equipoRepository.save(equipo);
                }
            }
        });
    };
}
}