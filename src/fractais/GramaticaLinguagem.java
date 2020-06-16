/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import java.util.ArrayList;

/**
 *
 * @author BRUNOSILVA
 */
public class GramaticaLinguagem {

    private String alfabeto;
    private int etapas;
    private String condicaoInicial;
    private double angulo;
    ArrayList<RegraProducao> listaProducao = new ArrayList<>();
    private String stringFinal;
    private double tamanhoLinha;   

    

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        this.etapas = etapas;
    }

    public String getCondicaoInicial() {
        return condicaoInicial;
    }

    public void setCondicaoInicial(String condicaoInicial) {
        this.condicaoInicial = condicaoInicial;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
    public String getStringFinal() {
        return stringFinal;
    }

    public void setStringFinal(String stringFinal) {
        this.stringFinal = stringFinal;
    } 
    
    public double getTamanhoLinha() {
        return tamanhoLinha;
    }

    public void setTamanhoLinha(double tamanhoLinha) {
        this.tamanhoLinha = tamanhoLinha;
    }
    

    public void adicionarProducao(RegraProducao rg) {
        listaProducao.add(rg);
    }

    public void removeProducao(RegraProducao rg) {
        listaProducao.remove(rg);
    }

    public String imprimeRegras() {
        String ha = "";

        for (RegraProducao rp : listaProducao) {
            ha += rp.toString()+"\n";
        }

        return ha;
    }

    public ArrayList<RegraProducao> getListaProducao() {
        return listaProducao;
    }

    public void setListaProducao(ArrayList<RegraProducao> listaProducao) {
        this.listaProducao = listaProducao;
    }
    
    

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Alfabeto: ").append(getAlfabeto()).append("\n");
        str.append("Etapas: ").append(getEtapas()).append("\n");
        str.append("Angulo: ").append(getAngulo()).append("\n");
        str.append("Cond. Inicial: ").append(getCondicaoInicial()).append("\n");
        str.append(imprimeRegras());
        str.append("\n");
        str.append("String final: ");
        str.append(getStringFinal());

        return str.toString();

    }
}
