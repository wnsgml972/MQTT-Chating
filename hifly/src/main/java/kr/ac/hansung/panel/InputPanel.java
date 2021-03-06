package kr.ac.hansung.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import kr.ac.hansung.debuger.Debuger;
import kr.ac.hansung.main.MainFrame;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static InputPanel instance;
	private JTextField textField = new JTextField();
	
	synchronized public static InputPanel getInstance(){
		if(instance == null){
			Debuger.log(InputPanel.class.toString(), "생성");
			instance = new InputPanel();
		}
		return instance;
	}
	
	private InputPanel() {
		setLayout(null);
		this.setPreferredSize(new Dimension(1100, 60));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(new Font("아이럽우유", Font.ITALIC, 20));
		textField.setBounds(70, 0, 250, 40);

		add(textField);

		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)// 입력한게 esc키이면
				{
					Debuger.log(InputPanel.class.toString(), "key esc");
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) // 엔터누르면
				{
					Debuger.log(InputPanel.class.toString(), "key enter");
					JTextField textfield = (JTextField) e.getSource();
					String text = textfield.getText().toString();
					textfield.setText("");
					
/*					int len = GroundPanel.getInstance().getTextArea().getText().toString().length();
					GroundPanel.getInstance().getTextArea().append(text + "\n");					
					GroundPanel.getInstance().getTextArea().setCaretPosition(len);					
					GroundPanel.getInstance().getTextArea().setFont(new Font("아이럽우유", Font.ITALIC, 25));*/
					
					//여기있는 서버 코드에서 자동으로 다 뿌려줌 뿌려주는데서 testArea append
					ChatPanel.getInstance().getPubClient().publish(PanelManager.getInstance().getMain().getTopic(), text);
					
				}
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.setFont(new Font("아이럽우유", Font.ITALIC, 25));
	}
}