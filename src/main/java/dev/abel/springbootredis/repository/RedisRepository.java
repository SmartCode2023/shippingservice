package dev.abel.springbootredis.repository;

import dev.abel.springbootredis.domain.Envio;

import java.util.Map;

public interface RedisRepository {
    Map<String, Envio> findAll();
    Envio findById(String id);
    void save(Envio envio);
    void delete(String id);
}
