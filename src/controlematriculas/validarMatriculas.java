package projeto_b2w;

import java.io.*;
import java.util.*;

/**
 *
 * @author Meliande
 */
public class validarMatriculas {

    public void lerArquivo() throws IOException {
        String linha = new String();

        String arquivo1 = "matriculas_para_validar.txt";
        FileWriter arquivo2 = new FileWriter("matriculas_validadas.txt");

        File arq = new File(arquivo1);

        if (arq.exists()) {

            try {
                FileReader reader = new FileReader(arquivo1);
                BufferedReader leitor = new BufferedReader(reader); //prepara o primeiro arquivo para leitura
                BufferedWriter fr = new BufferedWriter(arquivo2); //prepara o segundo arquivo para escrita

                while(true) {
                    linha = leitor.readLine();

                    if (linha == null) {
                        break; //caso o conteúdo do arquivo acabe, encerra a leitura
                    }

                    fr.write(linha + " " + validarMatr(linha)); // escreve a linha no segundo arquivo
                    fr.newLine(); //passa para a proxima linha no arquivo
                    fr.flush(); //atualiza o buffer
                }
                
            fr.close(); //fecha o txt de saída
            leitor.close(); //fecha o txt de entrada
                
            } catch(Exception e) {

            }
        }
    }

    public String validarMatr(String matricula) {
        String digitoVerificador;
        String DVatual;
        String matriculaSemDV;
        int soma = 0;
        
        matriculaSemDV = matricula.substring(0, 10); //pega a matricula atual e retira o DV para realizar o calculo do mesmo
        DVatual = matricula.substring(11); //separa o DV da matricula atual em uma variável separada para realizar a comparação depois
        
        String a[] = matriculaSemDV.split(""); //array para armazenar cada caracter separadamente

        for (int i = 0; i < a.length; i++) {
            soma = soma + Integer.parseInt(a[i], 16); //loop para ver o resultado da soma de todos os caracteres
        }

        soma = soma % 16; //divide o resultado por 16 para saber seu valor em hexadecimal
        digitoVerificador = Integer.toHexString(soma); //converte para hexadecimal
        
        if (DVatual.equals(digitoVerificador)) {
            return "True";
        } else
            return "False";
    }
}

        
