/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import geradores.GeraDesenho;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author BRUNOSILVA
 */
public class JDesenho extends JPanel {

    int largFolha;
    int alturaFolha;
    String arquivo;
    double compLinha;

    public JDesenho(int largFolha, int alturaFolha, String arquivo, double compLinha) {
        this.largFolha = largFolha;
        this.alturaFolha = alturaFolha;
        this.arquivo = arquivo;
        this.compLinha = compLinha;
        
        //criarComponentes();
    }  
    

    

    private void criarComponentes() {
        setLayout(null);

        setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        GeraDesenho.graficosNaTela(g, arquivo, compLinha);
    }
    
    

    /*
    @Override
    protected void paintComponent(Graphics g) {
        
        
        g.setColor(Color.white);
        g.fillRect(0, 0, largFolha, alturaFolha);
        

        double compLinha = 40;

        try {
            
            String caminho = "E:\\Users\\BRUNOSILVA\\Desktop\\FACULDADE\\"
                + "COMPILADORES\\Fractais\\arquivoEntrada3.txt";
            
            ArrayList<String> lendoArquivo = Metodos.lendoArquivo(caminho);
            GramaticaLinguagem gramatica = Metodos.trataArquivo(lendoArquivo);
            gramatica.setTamanhoLinha(compLinha);

            Metodos.criaStringFinal(gramatica);
            //System.out.println(gramatica.toString());

            char[] strFinal = gramatica.getStringFinal().toCharArray();
            double anguloGramatica = gramatica.getAngulo();
            double tamanhoLinha = gramatica.getTamanhoLinha();

            GeraCoordenadas gera = new GeraCoordenadas();

            for (char letra : strFinal) {

                gera.consumo(letra, tamanhoLinha, anguloGramatica);

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

        } catch (IOException ex) {
            //Logger.getLogger(PrincipalTeste.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ocorreu um erro, arquivo não encontrado");
        }
        
        
        

        
    }
     */
    

}
