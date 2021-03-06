package kr.ac.hansung.client;

import java.awt.Font;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.panel.GroundPanel;
import kr.ac.hansung.values.UnChangableValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubClient {
	
    //private String topic = "/topic/sample";    
    private MqttClient client;
    
    public SubClient(){
		Debuger.log(SubClient.class.toString(), "시작");
    }
    
	public void subscribe(String topic) {
        
		try {
			client = new MqttClient(UnChangableValues.MQTT_BROKET_IP, MqttClient.generateClientId(), new MemoryPersistence());		
			// init
			
			client.connect();
			// connect			
			
			client.setCallback(new MqttCallback() {
				public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
					Debuger.log(SubClient.class.toString(), arg0 + ": " + arg1.toString());
					int len = GroundPanel.getInstance().getTextArea().getText().toString().length();
					GroundPanel.getInstance().getTextArea().append(arg1.toString() + "\n");
					GroundPanel.getInstance().getTextArea().setCaretPosition(len);
					GroundPanel.getInstance().getTextArea().setFont(new Font("아이럽우유", Font.ITALIC, 25));					
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
			Debuger.log(SubClient.class.toString(), "reason "+me.getReasonCode());
			Debuger.log(SubClient.class.toString(), "msg "+me.getMessage());
			Debuger.log(SubClient.class.toString(), "loc "+me.getLocalizedMessage());
			Debuger.log(SubClient.class.toString(), "cause "+me.getCause());
			Debuger.log(SubClient.class.toString(), "excep "+me);
			Debuger.printError(me);
        }
	}
	
	public void clientDisConnect(){
		try {
			client.disconnect();
			client.close();
		} catch (MqttException e) {
			Debuger.printError(e);
		}
	}
}
