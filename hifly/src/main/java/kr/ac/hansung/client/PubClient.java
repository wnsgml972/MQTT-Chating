package kr.ac.hansung.client;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PubClient {

	private final String MQTT_BROKET_IP = "tcp://192.168.0.8:1883";
	private String topic = "/topic/sample";
	private String content = "Message from MqttPublishSample";
	private int qos = 2;
	
	public PubClient() {
		
	}
	
	public void publish(String topic, String content){
		
		topic = this.topic;
		content = this.content;
		
		try {
			MqttClient client = new MqttClient(MQTT_BROKET_IP, MqttClient.generateClientId(), new MemoryPersistence());
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + MQTT_BROKET_IP);
			// init

			
			client.connect(connOpts);
			System.out.println("Connected");
			// connect

			
			System.out.println("Publishing message: " + content);
			MqttMessage message = new MqttMessage(content.getBytes());
			//set message
			
			
			message.setQos(qos);
			// set qos

			
			client.publish(topic, message);
			System.out.println("Message published");
			// publish
			
			
			client.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
			// disconnect
			

		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}
}