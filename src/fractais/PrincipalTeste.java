/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import geradores.GeraDesenho;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BRUNOSILVA
 */
public class PrincipalTeste {

    public static JPanel tela;
    static JFrame frame;
    //Graphics gr;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);

        try {
            String arquivo = "E:\\Users\\BRUNOSILVA\\Desktop\\FACULDADE"
                    + "\\COMPILADORES\\Fractais\\src\\arquivostexto\\arquivoEntrada3.txt";
            
            
            System.out.println("Olá Bem vindo(a)");
            System.out.println("Digite a espessura da linha");
            double espessLinha = sc.nextDouble();
            System.out.println("Digite o comprimento da linha");
            double comprimLinha = sc.nextDouble();
            System.out.println("Digite o X inicial de sua preferencia");
            double parteX = sc.nextDouble();
            System.out.println("Digite o Y inicial de sua preferencia");
            double parteY = sc.nextDouble();
            
            GeraDesenho.partidaX=parteX;
            GeraDesenho.partidaY=parteY;
            GeraDesenho.espessuraDaLinha=espessLinha;
            

            //tamLinha=40; 
            GeraDesenho.imprimeCoordenadas(arquivo, comprimLinha);

            //criarComponentes(arquivo,tamLinha); 
            //Graphics g = null;
            //GeraDesenho.graficosNaTela(arquivo, tamLinha);
        } catch (Exception e) {

            System.out.println("Ocorreu um erro!");
        }

    }

    private static synchronized void criarComponentes(String arquivo, double comprimentoLinha) {

        frame = new JFrame("Sistema");
        frame.setSize(1200, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        int largura = frame.getWidth();
        int altura = frame.getHeight();

        tela = new JDesenho(largura, altura, arquivo, comprimentoLinha);
        tela.setVisible(true);
        frame.add(tela);
        frame.setVisible(true);

        //Navegador.telaDesenho(largura,altura);
    }

    private static void criaJanela() {

    }

    /*
    frame.setName("Sistema");
        frame = new JFrame("Sistema");
        frame.setSize(1200, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        int largura=frame.getWidth();
        int altura=frame.getHeight();
        
        tela=new JDesenho(largura, altura,arquivo,linha);
        tela.setVisible(true);
    
     */
}
