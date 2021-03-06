package kr.ac.hansung.main;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.panel.IntroPanel;
import kr.ac.hansung.panel.PanelManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainFrame extends JFrame
{		
	private String topic;
	
	public MainFrame(){
		setSize(400, 500);
		setTitle("MQTT 채팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		PanelManager.getInstance().setMain(this);
		start();
	}
	public void start() {
		Debuger.log(MainFrame.class.toString(), "시작");
		PanelManager.getInstance().setContentPane(IntroPanel.getInstance());
	}
    public static void main( String[] args )
    {
    	new MainFrame();
    }
}
