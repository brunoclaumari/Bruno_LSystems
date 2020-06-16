/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

/**
 *
 * @author BRUNOSILVA
 */
public class RegraProducao {
    private String ordem;
    private String letra;
    private String regraParaLetra;

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getRegraParaLetra() {
        return regraParaLetra;
    }

    public void setRegraParaLetra(String regra) {
        this.regraParaLetra = regra;
    }
    
    @Override
    public String toString(){        
        
        return ordem + " : "+
                letra+ " = "+
                regraParaLetra;        
        
    }
    
}
