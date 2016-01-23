package trabalho1;
//importando as bibliotecas io, scanner e URL
import java.io.*;
import java.util.Scanner;
import java.net.URL;

public class leitorPalindromo {
	
	public static void main(String[] args) {
		//Vari�veis Globais
		Scanner leitor1 = null;
		FileWriter escritor1 = null;
		URL fonte = null;
		try {
			//Inicializando as vari�veis
			fonte = new URL("http://alcor.concordia.ca/~vjorge/Palavras-Cruzadas/Lista-de-Palavras.txt"); 	//fonte das palavras utilizadas
			leitor1 = new Scanner(fonte.openStream());														//abre um scanner da fonte
			escritor1 = new FileWriter("resultado.txt", true);												//inicializa escritor do arquivo de texto
			while (leitor1.hasNextLine()) { //Loop principal, enquanto existir linhas no arquivo fonte
				String palavra = leitor1.nextLine(); //Atribui o valor da primeira linha do arquivo fonte � vari�vel palavra
				boolean pldrm = false; //Flag que sinaliza se a palavra � ou n�o um pal�ndromo
				int n = palavra.length(); //inteiro que indica o tamanho da palavra atribu�da � vari�vel
				
				for (int i=0; i<(n/2)+1; i++) { // Loop secund�rio
					if (palavra.charAt(i) != palavra.charAt(n - i - 1)) {
						pldrm = false;
						break;
					}
					else if (palavra.charAt(i) == palavra.charAt(n - i - 1)) {
						pldrm = true;
						break;
					}
				}
				if (pldrm == true) { //Se a flag est� em TRUE, a palavra � pal�ndromo.
					escritor1.write(palavra+" Sim");
					escritor1.write(System.getProperty("line.separator"));
				}
				else { //caso contr�rio, n�o �.
					escritor1.write(palavra+" N�o");
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
