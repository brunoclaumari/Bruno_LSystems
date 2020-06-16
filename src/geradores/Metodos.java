/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradores;

import fractais.GramaticaLinguagem;
import fractais.RegraProducao;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author BRUNOSILVA
 */
public class Metodos {

    public static ArrayList<String> lendoArquivo(String caminho) throws IOException {

        Charset coding = Charset.forName("ISO-8859-1");

        String[] msg = null;
        String linha = "";
        ArrayList<String> aux = new ArrayList<>();
        try (DataInputStream buffRead = new DataInputStream(new FileInputStream(caminho))) {

            byte[] tt = new byte[buffRead.available()];
            buffRead.read(tt);

            linha = new String(tt, coding);
            msg = linha.split(":");

            String[] testa = null;
            for (String b : msg) {

                testa = b.split("\n");
                for (String str : testa) {
                    aux.add(str.trim());
                }
            }
            /*imprime para conferir
            for (String ss : aux) {
                System.out.println(ss);
            }
             */

        }
        return aux;
    }

    public static GramaticaLinguagem trataArquivo(ArrayList<String> msg) {
        GramaticaLinguagem gramar = new GramaticaLinguagem();
        if (msg.size() >= 10) {

            gramar.setAlfabeto(msg.get(1));
            gramar.setEtapas(Integer.parseInt(msg.get(3).trim()));
            gramar.setCondicaoInicial(msg.get(5).trim());

            String aux = msg.get(7).replace("º", "");
            gramar.setAngulo(Double.parseDouble(aux.trim()));
            for (int n = 8; n < msg.size(); n += 2) {
                RegraProducao rp = new RegraProducao();
                rp.setOrdem(msg.get(n));
                String[] aux2 = msg.get(n + 1).split("=");
                rp.setLetra(aux2[0].trim());
                String regra = "";
                for (int i = 0; i < aux2[1].length(); i++) {
                    if (aux2[1].charAt(i) != ' ') {
                        regra += aux2[1].charAt(i);
                    }
                }
                rp.setRegraParaLetra(regra);
                gramar.adicionarProducao(rp);
            }

        } else {
            System.out.println("Gramática incompleta, faltando parametros");
        }

        return gramar;
    }

    public static void criaStringFinal(GramaticaLinguagem gramat) {
        String strFinal = "";
        int iteracoes = gramat.getEtapas();
        strFinal = replaces(iteracoes, gramat, gramat.getCondicaoInicial());

        gramat.setStringFinal(strFinal);

    }

    public static String replaces(int it, GramaticaLinguagem gr, String partida) {

        if (it == 0) {
            return partida;
        } else {
            ArrayList<RegraProducao> lista = gr.getListaProducao();
            String aux = "";
            for (char carac : partida.toCharArray()) {
                boolean tem=false;
                String atual="";
                for (RegraProducao p : lista) {
                    if (p.getLetra().equals(Character.toString(carac))) {
                        atual = Character.toString(carac);
                        char[] prox = p.getRegraParaLetra().toCharArray();
                        atual = String.copyValueOf(prox);
                        aux += atual;
                        tem=true;
                        break;
                    }
                    else{
                        tem=false; 
                        //break;
                    }
                }
                if(!tem){
                    aux+=Character.toString(carac);
                }
            }
            partida = aux;
            double linha=gr.getTamanhoLinha()*0.5;
            gr.setTamanhoLinha(linha);

            return replaces(it - 1, gr, partida);
        }
    }
    
    
    
}

/*
 lista.forEach((RegraProducao p) -> {
                String aux = "";
                for (int i = 0; i < partida.length(); i++) {
                    if (p.getLetra().equals(teste.charAt(i))) {
                        
                    }
                }
            });
 */
