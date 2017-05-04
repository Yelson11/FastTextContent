package FastTextContent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JScrollBar;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Fast Text Content");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblTitle.setBounds(66, 11, 302, 33);
		panel.add(lblTitle);
		
		JLabel lblnstruction = new JLabel("Introduzca su criterio de b\u00FAsqueda:");
		lblnstruction.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnstruction.setBounds(108, 43, 226, 24);
		panel.add(lblnstruction);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(108, 76, 226, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(108, 132, 89, 23);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent action){
				setText();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(128, 0, 0));
		btnSalir.setBounds(245, 132, 89, 23);
		panel.add(btnSalir);
	}
	//----------------------------------------------------------------
	public void setText(){
		String userText;
		userText = this.textField.getText();
		WordManager wordMan = new WordManager();
		wordMan.setText(userText);
		wordMan.setArrayList();
	}
	//----------------------------------------------------------------
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
