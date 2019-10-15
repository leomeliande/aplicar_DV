package projeto_b2w;

import java.io.*;  
import java.util.*;  
import javax.swing.*;

/**
 *
 * @author Meliande
 * 
 * Atualizado em 18/08/2018 às 16:57
 */
public class menuPrincipal {

    public static void main(String[] args) throws IOException {
        
        String opcao = "s";
        
        OUTER:
        do {
            Scanner reader = new Scanner(System.in);
            Scanner opc = new Scanner(System.in);
            System.out.println("\nControle de matrículas");
            System.out.println("\n1 - Aplicar digito verificador");
            System.out.println("2 - Validar matrículas existentes");
            System.out.println("3 - Sair");
            System.out.print("\nOpção: ");
            int lido = reader.nextInt();
            
            switch (lido) {
                case 1:
                    aplicarDV iniciarDV = new aplicarDV(); //construtor da classe aplicarDV
                    iniciarDV.lerArquivo(); //chamando o método lerArquivo
                    System.out.println("\nDigitos verificadores aplicados com sucesso.");
                    System.out.println("Arquivo 'matriculas_com_dv.txt' criado!");
                    break;
                case 2:
                    validarMatriculas iniciarValidacao = new validarMatriculas(); //construtor da classe validarMatriculas
                    iniciarValidacao.lerArquivo(); //chamando o método lerArquivo
                    System.out.println("\nMatrículas validadas com sucesso.");
                    System.out.println("Arquivo 'matriculas_validadas.txt' criado!");
                    break;
                case 3:
                    System.out.println("\nObrigado por utilizar o programa!");
                    break OUTER;
                default:
                    break;
            }
            
            System.out.println(" ");
            System.out.print("Deseja realizar outra operação? (s = sim/n = nao): ");
            opcao = opc.nextLine();  
            
            try {
                if (opcao.equals("n")) {
                    System.out.println("\nObrigado por utilizar o programa!");
                    break;
                }
                else if (!opcao.equals("s"))
                {
                    System.out.println("\nInsira uma opção válida!");
                    break;
                }
                
            } catch (Exception e) {
                
            }
        } while (opcao.equals("s"));
    }
}
    