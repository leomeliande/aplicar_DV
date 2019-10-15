package projeto_b2w;

import java.io.*;  
import java.util.*;  

/**
 *
 * @author Meliande
 */
public class aplicarDV {
    
    public void lerArquivo() throws IOException {
        String linha = new String();
        
        String arquivo1 = "matriculas_sem_dv.txt";
        FileWriter arquivo2 = new FileWriter("matriculas_com_dv.txt");

        File arq = new File(arquivo1);

        if (arq.exists()) {

            try {
                FileReader reader = new FileReader(arquivo1);
                BufferedReader leitor = new BufferedReader(reader); //prepara o primeiro arquivo para leitura
                BufferedWriter fr = new BufferedWriter(arquivo2); //prepara o segundo arquivo para escrita
                
                while(true) {
                    linha = leitor.readLine(); //lê a linha inteira do arquivo txt
                    
                    if (linha == null) {
                        break; //caso o conteúdo do arquivo acabe, encerra a leitura
                    }
                    
                    fr.write(linha + "-" + calculaDV(linha)); // escreve a linha no segundo arquivo
                    fr.newLine(); //passa para a proxima linha no arquivo
                    fr.flush(); //atualiza o buffer
                }
                
            fr.close(); //fecha o txt de saída
            leitor.close(); //fecha o txt de entrada
                
            } catch(Exception e) {

            } 
        }
    }
    
    public String calculaDV(String matricula) {
        String digitoVerificador;
        int soma = 0;
        String a[] = matricula.split(""); //array para armazenar cada caracter separadamente

        for (int i = 0; i < a.length; i++) {       
            soma = soma + Integer.parseInt(a[i], 16); //loop para ver o resultado da soma de todos os caracteres
        }
        
        soma = soma % 16; //divide o resultado por 16 para saber seu valor em hexadecimal
        digitoVerificador = Integer.toHexString(soma); //converte para hexadecimal

        return digitoVerificador;
    }
} 
