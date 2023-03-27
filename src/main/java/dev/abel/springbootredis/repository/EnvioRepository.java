package dev.abel.springbootredis.repository;

import dev.abel.springbootredis.domain.Envio;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class EnvioRepository implements RedisRepository{
    private static final String KEY = "Envio";

    private RedisTemplate<String, Envio> redisTemplate;
    private HashOperations hashOperations;

    public EnvioRepository(RedisTemplate<String, Envio> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Envio> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Envio findById(String id) {
        return (Envio) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Envio envio) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), envio);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
