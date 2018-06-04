package Projeto;
import java.util.Scanner;

public class Reserva {
	
	public static void main (String args[]){
		
		int identidade, flag = 0, docIdentidade, f, i=0, sair = 0, flag2 = 0, diferenca;
		int data_chegada=0, data_saida=0, horario_chegada=0, horario_saida=0, diaC, diaS, mesC, mesS;
		int perdeu, temp=0, achou, n;
		String nome, resp1, tipo_quarto; 
		Funcionário[] Funcionarios = new Funcionário[100];
		Hóspede[] Cadastrados = new Hóspede[100];
		Quarto[][] MatrizQuartos = new Quarto[10][10];
		ReserveHosp[] rh = new ReserveHosp[100];
		Scanner ler = new Scanner(System.in);
		
		
		Cadastrados[0] = new Hóspede("luiz", "federal", 123, "brasileiro", "nada", 0);
		Cadastrados[1] = new Hóspede("joao", "federal", 456, "brasileiro", "nada", 1);
		Funcionarios[i] = new Funcionário("caio", "casa", 789, 2);
		
		for (i=0; i<10; i++){
			for (int j=0; j<10; j++){
				MatrizQuartos[i][j] = new Quarto("nada", 0, 0, "nada", 0, 0);
			}
		}
		
		for (i=0; i<100; i++){
			rh[i] = new ReserveHosp("nada", 0, "nenhum", 0, 0, 0, 0, 0);
		}
		
		for (i=1; i<100; i++){
			Funcionarios[i] = new Funcionário("nada", "nada", 0, 0);
		}
		
		while (sair == 0){
			
			System.out.println("Você é um funcionário? e deseja realizar uma reserva? (s/n)");
			resp1 = ler.next();
			
			if (resp1.equals("s")){
				
				System.out.println("Digite seu numero de indentidade");
				identidade = ler.nextInt();
		
				flag = 0;
				for (int j = 0; j<100; j++){
					if (identidade  == Funcionarios[j].documento){
						flag  = 1;
					}
				}
				
				if (flag == 1){					
					
					System.out.println("Informe os seguintes dados para a reserva:");
					System.out.println();
					
					System.out.println("Nome do Hóspede: ");
					nome  = ler.next();
					
					System.out.println("Documento de indentidade: ");
					docIdentidade = ler.nextInt();
					
					System.out.println("Tipo do quarto: (solteiro/casal)");
					tipo_quarto = ler.next();
					
					System.out.println("Data de Chegada: ");
					data_chegada = ler.nextInt();
					
					System.out.println("Data de Saida: ");
					data_saida = ler.nextInt();
					
					System.out.println("Horario de Chegada: ");
					horario_chegada = ler.nextInt();
					
					System.out.println("Horario de saida: ");
					horario_saida = ler.nextInt();	

					System.out.println("Verificarei se existe alguma possível vaga para ele.");
					
					diaC = data_chegada / 100;
					diaS = data_saida / 100;
					mesC = data_chegada % 100;
					mesS = data_saida % 100;
					flag2 = 0;
					temp = diaC;
					
					if ((diaS - diaC + 1) > 0){
						diferenca = diaS - diaC + 1;
					}
					else {
						flag2 = 1;
						diferenca = diaS + 30 - diaC + 1;
					}
					
					perdeu = 0;
					achou = 0;
					
					for (f=0; f<10 & achou == 0; f++){
						for (i=0; i<10 & achou == 0; i++){
							for (int j=0; j<diferenca & perdeu == 0; j++){
								System.out.println("01");
								if (flag2 == 0){
									System.out.println("02");
									System.out.println(diaC);
									if (MatrizQuartos[f][i].ocupacao[mesC-1][diaC-1] == 1){
										perdeu = 1;
									}
									else {
										diaC++;
									}
								}
								else {
									System.out.println("03");
									if (diaC <= 30){
										if (MatrizQuartos[f][i].ocupacao[mesC-1][diaC-1] == 1){
											perdeu = 1;
										}
										else {
											diaC++;
										}
									}
									else {
										if (MatrizQuartos[f][i].ocupacao[mesS-1][diaC-1-30] == 1){
											perdeu = 1;
										}
										else {
											diaC++;
										}
									} 									
								}	
							}
							diaC = temp;
							if (perdeu == 0){
								achou = 1;
								MatrizQuartos[f][i].numeroHosp = docIdentidade;
								System.out.println("Achamos um quarto para você");
								for (int g=0; g<diferenca; g++){
									if(flag2 == 0){
										MatrizQuartos[f][i].ocupacao[mesC-1][diaC-1] = 1;
										diaC++;
									}
									else {
										if (diaC<=30){
											MatrizQuartos[f][i].ocupacao[mesC-1][diaC-1] = 1;
											diaC++;
										}
										else {
											MatrizQuartos[f][i].ocupacao[mesS-1][diaC-1-30] = 1;
											diaC++;
										}
									}
								}
								
								for (n=0; n<100; n++){
									if (rh[n].status == 0){
										rh[n].nome = nome;
										rh[n].documento = docIdentidade;
										rh[n].dataChegada = data_chegada;
										rh[n].dataSaida = data_saida;
										rh[n].status = 1;
									}
								}
								
								System.out.println("No quarto " +f);
								System.out.println("No quarto " +i);
							}
							perdeu = 0;
						}
					}
					
					if (perdeu == 1) {
						System.out.println("Não foi possivel fazer a reserva");
					}					
				}
			}
			else {
				
				System.out.println("Deseja realizar o cancelamento de uma reserva?");
				resp1 = ler.next();
					if (resp1.equals("s")){
						System.out.println("Digite o número de identidade do hóspede");
						docIdentidade = ler.nextInt();
						
						for (n=0; n<100; n++){
							if (rh[n].documento == docIdentidade){
								break;
							}
						}
						
						for (i=0; i<10; i++){
							for (int u=0; u<10; u++){
								if (MatrizQuartos[i][u].numeroHosp == docIdentidade){
									
									for (int a=0; a<100; a++){
										if (rh[a].documento == docIdentidade){
											data_chegada = rh[a].dataChegada;
											data_saida = rh[a].dataSaida;
											rh[a].status = 0;
										}
									}
									
									diaC = data_chegada / 100;
									diaS = data_saida / 100;
									mesC = data_chegada % 100;
									mesS = data_saida % 100;
									flag2 = 0;
									
									if ((diaS - diaC + 1) > 0){
										diferenca = diaS - diaC + 1;
									}
									else {
										flag2 = 1;
										diferenca = diaS + 30 - diaC + 1;
									}
									
									for (int g=0; g<diferenca; g++){
										if(flag2 == 0){
											MatrizQuartos[i][u].ocupacao[mesC-1][diaC-1] = 0;
											diaC++;
										}
										else {
											if (diaC<=30){
												MatrizQuartos[i][u].ocupacao[mesC-1][diaC-1] = 0;
												diaC++;
											}
											else {
												MatrizQuartos[i][u].ocupacao[mesS-1][diaC-1-30] = 0;
												diaC++;
											}
										}
									}
								}
							}
						}

						System.out.println("Reserva cancelada");
						System.out.println("O cancelamento foi feito antes de 12h?");
						resp1 = ler.next();
						if (resp1.equals("n")){
							System.out.println("O hóspede terá que paga uma multa");
						}
					}
					else {
						System.out.println("Muito obrigado por usar nosso sistema");
					}
			}
			System.out.println("Deseja sair do sistema ?");
			resp1 = ler.next();
			if (resp1.equals("s")){
				sair = 1;
			}
		}
	}
}
