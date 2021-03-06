package kr.ac.hansung.panel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kr.ac.hansung.client.SubClient;
import kr.ac.hansung.debuger.Debuger;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IntroPanel extends JPanel{
	private static IntroPanel instance;
	private JLabel roomLabel;
	private JTextField roomField;
	private JLabel titleLabel;
	
	private IntroPanel(){ 
		setLayout(new FlowLayout());
		roomLabel = new JLabel("방 만들기 ");		
		roomLabel.setFont(new Font("아이럽우유", Font.ITALIC, 20));
		
		roomField = new JTextField(15);		
		roomField.setMargin(new Insets(10, 10,10,10));
		
		titleLabel = new JLabel("모스키토 클라이언트 ");
		titleLabel.setFont(new Font("아이럽우유", Font.ITALIC, 20));		
		titleLabel.setForeground(Color.blue);
		
		add(roomLabel);
		add(roomField);
		add(titleLabel);
		
		roomField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = roomField.getText().toString();				
				SubClient subClient = new SubClient();
				subClient.subscribe(text);
				PanelManager.getInstance().getMain().setTopic(text);
				PanelManager.getInstance().setContentPane(ChatPanel.getInstance());
			}
		});
	}
	
	synchronized public static IntroPanel getInstance(){
		if(instance == null){
			Debuger.log(ChatPanel.class.toString(), "생성");
			instance = new IntroPanel();
		}
		return instance;
	}
	
}