/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author BRUNOSILVA
 */
public class JDesenho extends JPanel  {
    int largFolha;
    int alturaFolha;
    

    public JDesenho(int larg, int alt) {
        this.largFolha=larg;
        this.alturaFolha=alt;
        criarComponentes();
        
    }
    
    private void criarComponentes(){
        setLayout(null); 
        
                
        setVisible(true);        
    }  
    
   
     @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        //g.;
        g.fillRect(0, 0, largFolha, alturaFolha);
 
        //Image img = Toolkit.getDefaultToolkit().getImage("/tmp/silveira.jpg");
        //g.drawImage(img, 50, 55, this);
 
        g.setColor(Color.black);
        g.drawLine(75, 100, 75, 150);
        g.drawLine(75, 100, 25, 70);
        g.drawLine(75, 100, 125, 70);
        g.drawLine(75, 150, 100, 200);
        g.drawLine(75, 150, 50, 200);
        g.drawLine(75, 150, 100, 200);
 
        //g.setColor(Color.yellow);
        //g.fillArc(200, 50, 150, 150, 140, -270);
        
        
    }
    
    
    
    
    
}
