package com.example.restApplication.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.example.restApplication.entity.OrderEntity;

import tools.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {
	@Bean
	public RedisCacheConfiguration cacheConfiguration(ObjectMapper objectMapper) {

		JacksonJsonRedisSerializer<OrderEntity> serializer = new JacksonJsonRedisSerializer<>(objectMapper,
				OrderEntity.class);

		return RedisCacheConfiguration.defaultCacheConfig()
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
	}

}
