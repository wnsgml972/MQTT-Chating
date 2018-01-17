package kr.ac.hansung.panel;

import java.awt.BorderLayout;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatPanel extends JPanel{
	private static ChatPanel instance;
	
	private ChatPanel(){ 
		setLayout(new BorderLayout());
		add(GroundPanel.getInstance(), BorderLayout.CENTER);
		add(InputPanel.getInstance(), BorderLayout.SOUTH);
	}
	
	synchronized public static ChatPanel getInstance(){
		if(instance == null){
			Debuger.log(ChatPanel.class.toString(), "생성");
			instance = new ChatPanel();
		}
		return instance;
	}
	
}
