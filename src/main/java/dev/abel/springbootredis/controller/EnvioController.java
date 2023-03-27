package dev.abel.springbootredis.controller;

import dev.abel.springbootredis.domain.Envio;
import dev.abel.springbootredis.repository.EnvioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EnvioController {
    private EnvioRepository envioRepository;

    public EnvioController(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @GetMapping("/shipping")
    public Map<String, Envio> findAll() {
        return envioRepository.findAll();
    }

    @GetMapping("/shipping/{id}")
    public Envio findById(@PathVariable String id) {
        return envioRepository.findById(id);
    }

    @PostMapping("/shipping")
    public void createEnvio(@RequestBody Envio envio) {
        envioRepository.save(envio);
    }

    @DeleteMapping("/shipping/{id}")
    public void deleteEnvio(@PathVariable String id) {
        envioRepository.delete(id);
    }
}
