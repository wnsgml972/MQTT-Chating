package kr.ac.hansung.main;

import java.awt.BorderLayout;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.panel.ChatPanel;
import kr.ac.hansung.panel.PanelManager;

public class MainFrame extends JFrame
{		
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
		PanelManager.getInstance().setContentPane(ChatPanel.getInstance());
	}
    public static void main( String[] args )
    {
    	new MainFrame();
    }
}