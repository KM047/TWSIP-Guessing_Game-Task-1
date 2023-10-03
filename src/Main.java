
import com.ui.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kunal
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Heloo");
        
        SwingUtilities.invokeLater(() -> {
            GameUi frame = new GameUi();
            frame.setVisible(true);
        });
        
        
        
        
        
    }
    
}
