package kr.ac.hansung.panel;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.main.MainFrame;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/* 게임 내 모든 패널을 관리한다. 화면 전환과 패널 관리가 가능하다. */
public class PanelManager 
{
	private static PanelManager insatnce;
	public MainFrame main;
	private ChatPanel chatPanel;
	private GroundPanel groundPanel;
	private InputPanel inputPanel;
	private IntroPanel introPanel;

	private PanelManager() { 
		groundPanel = GroundPanel.getInstance();
		inputPanel = InputPanel.getInstance();
		introPanel = IntroPanel.getInstance();
		chatPanel = ChatPanel.getInstance();
	}
	synchronized public static PanelManager getInstance(){
		if(insatnce == null){
			Debuger.log(PanelManager.class.toString(), "생성");
			insatnce = new PanelManager();
		}
		return insatnce;
	}
	
	// 화면을 전환
	public void setContentPane(JPanel panel) {
		main.setContentPane(panel);
		main.getContentPane().revalidate();
	}
}