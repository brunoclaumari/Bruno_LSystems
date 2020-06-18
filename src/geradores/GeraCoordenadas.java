/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author BRUNOSILVA
 */
public class GeraCoordenadas {

    public double angCorrente = 0;
    public int maiorX;
    public int menorX = Integer.MAX_VALUE;
    public int maiorY;
    public int menorY = Integer.MAX_VALUE;
    private double primeiroX;
    private double primeiroY;

    public String stringSvgFinal = "";

    public GeraCoordenadas() {

    }

    public GeraCoordenadas(double primeiroX, double primeiroY) {
        this.primeiroX = primeiroX;
        this.primeiroY = primeiroY;
    }

    public double getPrimeiroX() {
        return primeiroX;
    }

    public void setPrimeiroX(double primeiroX) {
        this.primeiroX = primeiroX;
    }

    public double getPrimeiroY() {
        return primeiroY;
    }

    public void setPrimeiroY(double primeiroY) {
        this.primeiroY = primeiroY;
    }

    //public HashMap<String, VetorLinha> listaDePontos = new HashMap<>();
    public List<VetorLinha> listaDePontos = new ArrayList<>();

    public void consumo(char letra, double comprLinha, double espesLinha, double anguloDaGramatica) {
        VetorLinha posAtual = new VetorLinha();
        if (listaDePontos.isEmpty()) {
            //Seta o primeiro ponto de partida das coordenadas do desenho
            posAtual.setxInicial(getPrimeiroX());
            posAtual.setyInicial(getPrimeiroY());

        } else {
            int posicao = listaDePontos.size() - 1;
            VetorLinha ultimo = listaDePontos.get(posicao);

            posAtual.setxInicial(ultimo.getxFinal());
            posAtual.setyInicial(ultimo.getyFinal());
        }

        //angCorrente = posAnterior.getAngulo();
        double angEspecifico;
        boolean temDesenho;
        double auxx;

        switch (letra) {
            case 'F':
                angEspecifico = 90;
                temDesenho = true;
                passaParametros(posAtual, temDesenho, angEspecifico, comprLinha);
                break;
            /*
                case 'R':
                angEspecifico = 0;
                temDesenho = true;
                passaParametros(posAtual, temDesenho, angEspecifico, tamanhoLinha);
                break;
            case 'L':
                angEspecifico = 180;
                temDesenho = true;
                passaParametros(posAtual, temDesenho, angEspecifico, tamanhoLinha);
                break;
             */
            case '+':
                //auxx=angCorrente;
                //angCorrente =(auxx+anguloDaGramatica)%360;
                angCorrente += anguloDaGramatica;
                break;
            case '-':
                //auxx=angCorrente;
                //angCorrente =(auxx+360-anguloDaGramatica)%360;
                angCorrente += anguloDaGramatica * -1;
                break;
            case 'f':
                angEspecifico = 90;
                temDesenho = false;
                passaParametros(posAtual, temDesenho, angEspecifico, comprLinha);
                break;

        }
        //return posAtual;
    }

    private void passaParametros(VetorLinha vetor, boolean desenhar,
            double anguloEspecif, double comprimentoLinha) {

        double radCorrente = anguloEspecif + angCorrente;

        vetor.setTemLinha(desenhar);
        double x = Math.cos(Math.toRadians(radCorrente)) * comprimentoLinha;
        double y = Math.sin(Math.toRadians(radCorrente)) * comprimentoLinha;
        DecimalFormat df = new DecimalFormat("#.###");
        x = Double.parseDouble(df.format(vetor.getxInicial())) + Double.parseDouble(df.format(x));
        y = Double.parseDouble(df.format(vetor.getyInicial())) + Double.parseDouble(df.format(y));

        vetor.setxFinal(x);
        vetor.setyFinal(y);

        adicionaCoordenada(vetor, GeraDesenho.espessuraDaLinha);

        listaDePontos.add(vetor);
    }

    public String stringSVG() {
        String arquivoSvg = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        arquivoSvg += stringSvgFinal;

        arquivoSvg += "</svg>";

        return arquivoSvg;
    }

    void adicionaCoordenada(VetorLinha linha, double espLinha) {

        String addPonto = "<line ";
        addPonto += String.format("x1=\"%1$.3f\" y1=\"%2$.3f\" x2=\"%3$.3f\" y2=\"%4$.3f\"",
                linha.getxInicial(),
                linha.getyInicial(),
                linha.getxFinal(),
                linha.getyFinal());
        addPonto += String.format(" style=\"stroke:black;stroke-width:%s\" />\n", espLinha);

        stringSvgFinal += addPonto;
    }

    public void escreveArquivoSvg(String svg) throws IOException {

        String path = ".\\zArquivoSVG\\lsystems.svg";
        //try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))//Adiciona item ao arquivo existente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {//Sustitui o arquivo existente
            bw.append(svg);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


/*

public void testaMaiorX(int comp) {
        if (comp > maiorX) {
            maiorX = comp;
        }

    }

    public void testaMenorX(int comp) {
        if (comp < menorX) {
            menorX = comp;
        }
    }

    public void testaMaiorY(int comp) {
        if (comp > maiorY) {
            maiorY = comp;
        }

    }

    public void testaMenorY(int comp) {
        if (comp < menorY) {
            menorY = comp;
        }
    }

 */
