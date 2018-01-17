package kr.ac.hansung.client;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.values.UnChangableValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PubClient {
	//private String topic = "/topic/sample";
	//private String content = "Message from MqttPublishSample";
	private int qos = 2;
	
	public PubClient() {
		Debuger.log(PubClient.class.toString(), "시작");
	}
	
	public void publish(String topic, String content){
		
		try {
			MqttClient client = new MqttClient(UnChangableValues.MQTT_BROKET_IP, MqttClient.generateClientId(), new MemoryPersistence());
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			Debuger.log(SubClient.class.toString(), "Connecting to broker: " + UnChangableValues.MQTT_BROKET_IP);
			// init

			
			client.connect(connOpts);
			Debuger.log(SubClient.class.toString(), "Connected");
			// connect

			
			MqttMessage message = new MqttMessage(content.getBytes());
			Debuger.log(SubClient.class.toString(), "Publishing message: " + content);
			//set message
			
			
			message.setQos(qos);
			// set qos

			
			client.publish(topic, message);
			Debuger.log(SubClient.class.toString(), "Message published");
			// publish
			
			
			client.disconnect();
			Debuger.log(SubClient.class.toString(), "Disconnected");
			// disconnect			

			
		} catch (MqttException me) {
			Debuger.log(SubClient.class.toString(), "reason "+me.getReasonCode());
			Debuger.log(SubClient.class.toString(), "msg "+me.getMessage());
			Debuger.log(SubClient.class.toString(), "loc "+me.getLocalizedMessage());
			Debuger.log(SubClient.class.toString(), "cause "+me.getCause());
			Debuger.log(SubClient.class.toString(), "excep "+me);
			Debuger.printError(me);
		}
	}
}
