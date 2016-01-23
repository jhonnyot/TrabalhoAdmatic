package trabalho1;
//importando as bibliotecas io, scanner e URL
import java.io.*;
import java.util.Scanner;
import java.net.URL;

public class leitorPalindromo {
	
	public static void main(String[] args) {
		//Variáveis Globais
		Scanner leitor1 = null;
		FileWriter escritor1 = null;
		URL fonte = null;
		try {
			//Inicializando as variáveis
			fonte = new URL("http://alcor.concordia.ca/~vjorge/Palavras-Cruzadas/Lista-de-Palavras.txt"); 	//fonte das palavras utilizadas
			leitor1 = new Scanner(fonte.openStream());														//abre um scanner da fonte
			escritor1 = new FileWriter("resultado.txt", true);												//inicializa escritor do arquivo de texto
			while (leitor1.hasNextLine()) { //Loop principal, enquanto existir linhas no arquivo fonte
				String palavra = leitor1.nextLine(); //Atribui o valor da primeira linha do arquivo fonte à variável palavra
				boolean pldrm = true; //Flag que sinaliza se a palavra é ou não um palíndromo
				int n = palavra.length() - 1; //inteiro que indica o tamanho da palavra atribuída à variável
				int i = 0;
				while (n > i) { //Loop secundário
					if (n==0) {
						break;
					}
					if (palavra.charAt(i) != palavra.charAt(n)){
						pldrm = false;
						n--;
						i++;
						break;
					}
					else 
						pldrm = true;
					i++;
					n--;
				}
				if (pldrm == true) { //Se a flag está em TRUE, a palavra é palíndromo.
					escritor1.write(palavra+" Sim");
					escritor1.write(System.getProperty("line.separator"));
				}
				else { //caso contrário, não é.
					escritor1.write(palavra+" Não");
					escritor1.write(System.getProperty("line.separator"));
				}
			}
			//encerra o scanner e o escritor
			leitor1.close();
			escritor1.close();
		}
		
		catch (Exception erro2) {
			erro2.printStackTrace();
		}
		System.out.println("Feito.");
	}
}
