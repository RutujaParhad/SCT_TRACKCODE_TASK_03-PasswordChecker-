import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PasswordStrengthCheckerGUI extends JFrame {

    private JPasswordField passwordField;
    private JTextArea resultArea;

    public PasswordStrengthCheckerGUI() {
        setTitle("Password Strength Checker");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        inputPanel.add(new JLabel("Enter Password: "), BorderLayout.WEST);

        passwordField = new JPasswordField();
        inputPanel.add(passwordField, BorderLayout.CENTER);

        JButton checkButton = new JButton("Check Strength");
        inputPanel.add(checkButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(scrollPane, BorderLayout.CENTER);

        // Button Action
        checkButton.addActionListener(this::handleCheckPassword);
    }

    private void handleCheckPassword(ActionEvent e) {
        String password = new String(passwordField.getPassword());
        String result = checkPasswordStrength(password);
        resultArea.setText(result);
    }

    // Strength checking logic
    public static String checkPasswordStrength(String password) {
        int strength = 0;
        StringBuilder feedback = new StringBuilder();

        if (password.length() >= 8) {
            strength++;
        } else {
            feedback.append("- Password should be at least 8 characters long.\n");
        }

        if (password.matches(".*[A-Z].*")) {
            strength++;
        } else {
            feedback.append("- Add at least one uppercase letter.\n");
        }

        if (password.matches(".*[a-z].*")) {
            strength++;
        } else {
            feedback.append("- Add at least one lowercase letter.\n");
        }

        if (password.matches(".*[0-9].*")) {
            strength++;
        } else {
            feedback.append("- Add at least one number.\n");
        }

        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            strength++;
        } else {
            feedback.append("- Add at least one special character.\n");
        }

        if (strength == 5) {
            return "✅ Strong password!";
        } else if (strength >= 3) {
            return "⚠ Moderate password\nSuggestions:\n" + feedback.toString();
        } else {
            return "❌ Weak password\nSuggestions:\n" + feedback.toString();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordStrengthCheckerGUI().setVisible(true));
    }
}



        