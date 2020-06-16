/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractais;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
 * @author BRUNOSILVA
 */
public class Navegador {

    

    public static void telaDesenho(int larg, int alt) {
        PrincipalTeste.tela = new JDesenho(larg,alt);
        PrincipalTeste.frame.setTitle("Desenhando");
        Navegador.atualizarTela();
    }

    private static void atualizarTela() {
        PrincipalTeste.frame.getContentPane().removeAll();
        PrincipalTeste.tela.setVisible(true);
        PrincipalTeste.frame.add(PrincipalTeste.tela);

        PrincipalTeste.frame.setVisible(true);
    }

    

}
