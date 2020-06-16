/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import geradores.Metodos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BRUNOSILVA
 */
public class PrincipalTeste {
    
    public static JPanel tela;
    public static JFrame frame;   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        criarComponentes();        
        
       
         String caminho = "E:\\Users\\BRUNOSILVA\\Desktop\\FACULDADE\\"
                    + "COMPILADORES\\Fractais\\arquivoEntrada3.txt";
        try {
            ArrayList<String> lendoArquivo = Metodos.lendoArquivo(caminho);
            GramaticaLinguagem gramatica=Metodos.trataArquivo(lendoArquivo);
            Metodos.criaStringFinal(gramatica);
            System.out.println(gramatica);
            //System.out.println((575)%360);
             
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private static void criarComponentes() {
        frame = new JFrame("Sistema");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        int largura=frame.getWidth();
        int altura=frame.getHeight();
        
        Navegador.telaDesenho(largura,altura);

    }
    
}
