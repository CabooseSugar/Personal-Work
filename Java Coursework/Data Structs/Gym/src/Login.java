import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {

	public JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public Login() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("H&B Gym");
		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel singinLabel = new JLabel("SIGN IN");
		singinLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		singinLabel.setBounds(24, 11, 157, 60);
		frame.getContentPane().add(singinLabel);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		usernameLabel.setBounds(84, 82, 126, 60);
		frame.getContentPane().add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordLabel.setBounds(84, 153, 126, 60);
		frame.getContentPane().add(passwordLabel);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		usernameField.setBounds(249, 97, 217, 32);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordField.setEchoChar('*');
		passwordField.setBounds(249, 168, 217, 32);
		frame.getContentPane().add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginButton.setBounds(193, 232, 126, 42);
		frame.getContentPane().add(loginButton);
		
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
				}
			}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = usernameField.getText();
				String pass = passwordField.getText();
				if (name.equals("hnbgym") && pass.equals("password")) {
					FlashScreen fs = new FlashScreen();
					fs.frame.setVisible(true);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
					usernameField.setText("");
					passwordField.setText("");
					usernameField.requestFocus();
					
				}
			}
		});
	}
}
