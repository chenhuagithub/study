package com.maoyan.canalproject.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.22.50.254:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "canal");
 
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p);
        kafkaConsumer.subscribe(Collections.singletonList("canal"));// 订阅消息
 
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                String value = record.value();
                JSONObject obj = JSON.parseObject(value);
                if ("INSERT".equalsIgnoreCase(obj.getString("type"))
                        && "hhy_test".equalsIgnoreCase(obj.getString("database"))
                        && "canal_test".equalsIgnoreCase(obj.getString("table"))) {
                    JSONArray dataArry = obj.getJSONArray("data");
                    if (dataArry != null && dataArry.size() > 0) {
                        for (int i = 0; i < dataArry.size(); i++) {
                            System.out.println(dataArry.getJSONObject(i).toJSONString());
                        }
                    }
                }
            }
        }
    }
}
