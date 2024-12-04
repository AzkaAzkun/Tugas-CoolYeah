import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center frame

        // Membuat panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Menampilkan frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Text field username
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Label password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Password field
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Tombol login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Tombol keluar
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(180, 80, 80, 25);
        panel.add(exitButton);

        // Event Listener untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Validasi sederhana
                if ("admin".equals(username) && "password123".equals(password)) {
                    JOptionPane.showMessageDialog(panel, "Login Berhasil!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Event Listener untuk tombol exit
        exitButton.addActionListener(e -> System.exit(0));
    }
}
