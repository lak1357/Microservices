package com.mitra.orderses;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.mitra.orderses.event.CoffeeEvent;

@Configuration
public class KafkaConfiguration {

	@Value("${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public Map<String, Object> jsonProducerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return props;
	}

	@Bean
	public Map<String, Object> stringProducerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return props;
	}

	@Bean
	public ProducerFactory<String, CoffeeEvent> jsonProducerFactory() {

		return new DefaultKafkaProducerFactory<>(jsonProducerConfigs());
	}

	@Bean
	public ProducerFactory<String, String> stringProducerFactory() {

		return new DefaultKafkaProducerFactory<>(stringProducerConfigs());
	}

	@Bean
	public KafkaTemplate<String, CoffeeEvent> eventKafkaTemplate() {
		return new KafkaTemplate<>(jsonProducerFactory());
	}

	@Bean
	public KafkaTemplate<String, String> stringKafkaTemplate() {
		return new KafkaTemplate<>(stringProducerFactory());
	}

}
