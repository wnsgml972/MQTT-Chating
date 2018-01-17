package kr.ac.hansung.client;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import kr.ac.hansung.values.UnChangableValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubClient {
	
    private String topic = "/topic/sample";    
	
	public void subscribe(String topic) {
        
		topic = this.topic;
		
		try {
			MqttClient client = new MqttClient(UnChangableValues.MQTT_BROKET_IP, MqttClient.generateClientId(), new MemoryPersistence());		
			// init
			
			client.connect();
			// connect
			
			client.setCallback(new MqttCallback() {
				public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
					System.out.println(arg0 + ": " + arg1.toString());
				}
				public void deliveryComplete(IMqttDeliveryToken arg0) {
					// TODO Auto-generated method stub
				}
				public void connectionLost(Throwable arg0) {
					// TODO Auto-generated method stub
				}
			});
			// set callback
			
			client.subscribe(topic, 1);
			// subscribe
			
		}  catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
	}
}
