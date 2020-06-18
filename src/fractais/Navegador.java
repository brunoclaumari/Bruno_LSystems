/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import javax.swing.JPanel;




/**
 *
 * @author BRUNOSILVA
 */
public class Navegador {
    

    static void telaDesenho(int larg, int alt) {
        //PrincipalTeste.tela = new JDesenho(larg,alt);
        PrincipalTeste.frame.setTitle("Desenhando");
        PrincipalTeste.frame.getContentPane().removeAll();
        //PrincipalTeste.tela.setVisible(true);
        PrincipalTeste.frame.add(PrincipalTeste.tela);

        PrincipalTeste.frame.setVisible(true);
        //Navegador.atualizarTela();
    }

    /*
    private static void atualizarTela() {
        PrincipalTeste.frame.getContentPane().removeAll();
        //PrincipalTeste.tela.setVisible(true);
        PrincipalTeste.frame.add(PrincipalTeste.tela);

        PrincipalTeste.frame.setVisible(true);
    }
    
    */

    

}
