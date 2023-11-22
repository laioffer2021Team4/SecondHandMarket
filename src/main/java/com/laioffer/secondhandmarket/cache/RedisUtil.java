package com.laioffer.secondhandmarket.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.StandardCharsets;

public enum RedisUtil {
  INSTANCE;

  private final JedisPool pool;

  RedisUtil() {
    pool = new JedisPool(new JedisPoolConfig(), "localhost");
  }

  public void addToSetCache(String key, String value) {
    try (Jedis jedis = pool.getResource()) {
      jedis.sadd(key, value);
    }
  }

  public void removeFromSetCache(String key, String value) {
    try (Jedis jedis = pool.getResource()) {
      jedis.srem(key, value);
    }
  }

  public boolean isInSetCache(String key, String value) {
    try (Jedis jedis = pool.getResource()) {
      return jedis.sismember(key, value);
    }
  }

  public boolean hasKey(String key) {
    try (Jedis jedis = pool.getResource()) {
      return jedis.exists(key);
    }
  }

  public byte[] getValue(String key) {
    try (Jedis jedis = pool.getResource()) {
      return jedis.get(key.getBytes(StandardCharsets.UTF_8));
    }
  }

  public void putValue(String key, byte[] value) {
    try (Jedis jedis = pool.getResource()) {
      jedis.set(key.getBytes(StandardCharsets.UTF_8), value);
    }
  }

}
