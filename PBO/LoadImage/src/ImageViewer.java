import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Viewer");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load Image");
        panel.add(loadButton, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setDialogTitle("Select an Image");

                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory()) return true;
                        String name = f.getName().toLowerCase();
                        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif");
                    }

                    @Override
                    public String getDescription() {
                        return "Image Files (*.jpg, *.png, *.gif)";
                    }
                });

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(resizedImage));
                }
            }
        });
        
        frame.setVisible(true);
    }
}
