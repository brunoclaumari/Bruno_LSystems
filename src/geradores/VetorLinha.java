/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradores;

/**
 *
 * @author BRUNOSILVA
 */
public class VetorLinha {

    private double xInicial;
    private double yInicial;
    private double xFinal;
    private double yFinal;
    
    private int angulo;
    private boolean temLinha;
    

    public VetorLinha() {
        
    }   

    public VetorLinha(double xInicial, double yInicial, double xFinal, double yFinal, int angulo, boolean temLinha) {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.xFinal = xFinal;
        this.yFinal = yFinal;
        this.angulo = angulo;
        this.temLinha = temLinha;
    }

    public double getxInicial() {
        return xInicial;
    }

    public void setxInicial(double xInicial) {
        this.xInicial = xInicial;
    }

    public double getyInicial() {
        return yInicial;
    }

    public void setyInicial(double yInicial) {
        this.yInicial = yInicial;
    }

    public double getxFinal() {
        return xFinal;
    }

    public void setxFinal(double xFinal) {
        this.xFinal = xFinal;
    }

    public double getyFinal() {
        return yFinal;
    }

    public void setyFinal(double yFinal) {
        this.yFinal = yFinal;
    }

    public boolean isTemLinha() {
        return temLinha;
    }

    public void setTemLinha(boolean temLinha) {
        this.temLinha = temLinha;
    }
    
    
    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) throws IllegalArgumentException{
        if (angulo < 0 || angulo >= 360) {
            throw new IllegalArgumentException("Informe um angulo entre 0 e 360");
        }
        this.angulo = angulo;
    }

}
