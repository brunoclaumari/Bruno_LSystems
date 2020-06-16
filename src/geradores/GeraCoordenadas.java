/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradores;

import java.util.HashMap;

/**
 *
 * @author BRUNOSILVA
 */
public class GeraCoordenadas {

    public double angCorrente = 0;

    public HashMap<String, VetorLinha> listaDePontos = new HashMap<>();

    private VetorLinha consumo(char letra, VetorLinha posAnterior, double tamanhoLinha, double anguloDaGramatica) {
        VetorLinha posAtual = new VetorLinha();
        posAtual.setxInicial(posAnterior.getxFinal());
        posAtual.setyInicial(posAnterior.getyFinal());

        //angCorrente = posAnterior.getAngulo();
        double angEspecifico;
        boolean temDesenho;

        switch (letra) {
            case 'F':
                /*
                posAtual.setTemLinha(true);
                double x = Math.cos(Math.toRadians(90 + angCorrente)) * tamanhoLinha;
                double y = Math.sin(Math.toRadians(90 + angCorrente)) * tamanhoLinha;
                posAtual.setxFinal(x);
                posAtual.setyFinal(y);
                 */
                angEspecifico = 90;
                temDesenho = true;
                passaParametros(posAnterior, temDesenho, angEspecifico, tamanhoLinha);
                break;
            case 'R':
                angEspecifico = 0;
                temDesenho = true;
                passaParametros(posAnterior, temDesenho, angEspecifico, tamanhoLinha);
                break;
            case 'L':
                angEspecifico = 180;
                temDesenho = true;
                passaParametros(posAnterior, temDesenho, angEspecifico, tamanhoLinha);
                break;
            case '+':
                angCorrente = anguloDaGramatica;
                break;
            case '-':
                angCorrente = anguloDaGramatica * -1;
                break;
            case 'f':
                angEspecifico = 90;
                temDesenho = false;
                passaParametros(posAnterior, temDesenho, angEspecifico, tamanhoLinha);
                break;

        }
        return posAtual;
    }

    private void passaParametros(VetorLinha vetor, boolean desenhar, double anguloEspecif, double tamLinha) {
        vetor.setTemLinha(desenhar);
        double x = Math.cos(Math.toRadians(anguloEspecif + angCorrente)) * tamLinha;
        double y = Math.sin(Math.toRadians(anguloEspecif + angCorrente)) * tamLinha;
        
        vetor.setxFinal(x);
        vetor.setyFinal(y);
    }
}
