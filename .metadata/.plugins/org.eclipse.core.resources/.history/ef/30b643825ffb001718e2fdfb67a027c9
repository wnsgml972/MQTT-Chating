package kr.ac.hansung.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroundPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static GroundPanel instance;
	private JTextArea textArea = new JTextArea();
	
	private GroundPanel(){ 
		setLayout(new BorderLayout());
		setFocusable(false);
		add(textArea, BorderLayout.CENTER);
	}
	
	synchronized public static GroundPanel getInstance(){
		if(instance == null){
			Debuger.log(GroundPanel.class.toString(), "생성");
			instance = new GroundPanel();
		}
		return instance;
	}
	
	@Override
	public void paintComponent(Graphics g) // 한계선 설정
	{
		super.paintComponent(g);
		g.drawLine(0, getHeight() - 30, getWidth(), getHeight() - 30);
		g.setColor(Color.yellow);
		g.setFont(new Font("아이럽우유", Font.ITALIC, 25));
	}
}