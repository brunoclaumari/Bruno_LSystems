/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradores;

import fractais.GramaticaLinguagem;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author BRUNOSILVA
 */
public class GeraDesenho {
    
    public static double partidaX;
    public static double partidaY;
    public static double espessuraDaLinha;
    //public static double comprimLinha;
    
    

    public static void graficosNaTela(Graphics g, String arquivo, double compLinha) {

        //compLinha = 40;

        try {
            /*
            String caminho = "E:\\Users\\BRUNOSILVA\\Desktop\\FACULDADE\\"
                + "COMPILADORES\\Fractais\\arquivoEntrada3.txt";
             */

            String caminho = arquivo;

            ArrayList<String> lendoArquivo = Metodos.lendoArquivo(caminho);
            GramaticaLinguagem gramatica = Metodos.trataArquivo(lendoArquivo);
            gramatica.setTamanhoLinha(compLinha);
            
            Metodos.criaStringFinal(gramatica);
            

            char[] strFinal = gramatica.getStringFinal().toCharArray();
            double anguloGramatica = gramatica.getAngulo();
            double compLinhaGram=gramatica.getTamanhoLinha();
           

            GeraCoordenadas gera = new GeraCoordenadas(partidaX, partidaY); 

            for (char letra : strFinal) {

                gera.consumo(letra, compLinhaGram,espessuraDaLinha, anguloGramatica);

            }

            for (VetorLinha vet : gera.listaDePontos) {
                g.setColor(Color.black);

                if (vet.isTemLinha()) {
                    g.drawLine((int) vet.getxInicial(),
                            (int) vet.getyInicial(),
                            (int) vet.getxFinal(),
                            (int) vet.getyFinal());

                    System.out.println(vet.getxInicial() + ":"
                            + vet.getyInicial() + " | "
                            + vet.getxFinal() + ":"
                            + vet.getyFinal());

                }

            }
            Thread.sleep(500);

        } catch (IOException ex) {
            //Logger.getLogger(PrincipalTeste.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocorreu um erro, arquivo não encontrado");
        } catch (InterruptedException ex) {
            Logger.getLogger(GeraDesenho.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void imprimeCoordenadas(String arquivo, double compLinha) throws IOException {
        //compLinha = 40;

        try {
            /*
            String caminho = "E:\\Users\\BRUNOSILVA\\Desktop\\FACULDADE\\"
                + "COMPILADORES\\Fractais\\arquivoEntrada3.txt";
             */

            String caminho = arquivo;

            ArrayList<String> lendoArquivo = Metodos.lendoArquivo(caminho);
            GramaticaLinguagem gramatica = Metodos.trataArquivo(lendoArquivo);
            gramatica.setTamanhoLinha(compLinha);
            
            Metodos.criaStringFinal(gramatica);
            

            char[] strFinal = gramatica.getStringFinal().toCharArray();
            double anguloGramatica = gramatica.getAngulo();
            double compLinhaGram=gramatica.getTamanhoLinha();
           

            GeraCoordenadas gera = new GeraCoordenadas(partidaX, partidaY); 

            for (char letra : strFinal) {

                gera.consumo(letra, compLinhaGram,espessuraDaLinha, anguloGramatica);

            }
            
            String stringSvg=gera.stringSVG();
            
            gera.escreveArquivoSvg(stringSvg);
            
            System.out.println(stringSvg);

            /*
            for (VetorLinha vet : gera.listaDePontos) {

                System.out.println(vet.getxInicial() + ":"
                        + vet.getyInicial() + " | "
                        + vet.getxFinal() + ":"
                        + vet.getyFinal());

            }
            */

        } catch (IOException ex) {
            //Logger.getLogger(PrincipalTeste.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocorreu um erro, arquivo não encontrado");
        }

    }

}
