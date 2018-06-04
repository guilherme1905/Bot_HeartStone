/**
 * Autores: C.M.F. Rubira, P.A. Guerra e L.P. Tizzei
 * 
 * Introdução à Programação Orientada a Objetos usando Java
 * 
 * Cap. 6 - Sistema de Caixa Automático
 * 
 * última modificação: 28 de março de 2013
 */



package sistemaCaixaAutomatico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

public class TrmCxAut {



	//Atributos
	private ControladorCaixa controladorCaixa; // associação entre terminal e controladorcaixa


	//Operacoes

	public TrmCxAut(int senhaCaixa) {
		controladorCaixa = new ControladorCaixa(senhaCaixa);

	}



	/**
	 * Solicita que o usuário digite dados na entrada padrão de acordo com o significado da string 
	 * passada como parâmetro.
	 * @param str define o que é solicitado para o usuário, e.g. "senha do caixa"
	 * @return um número (int) que foi digitado pelo usuário
	 */
	private int getInt(String str) {


		System.out.println("Entre com "+str);

		// lê os valores digitados na entrada padrão
		Reader r = new BufferedReader(new InputStreamReader (System.in));
		StreamTokenizer st = new StreamTokenizer(r);

		try {
			st.nextToken();
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do teclado");
			return(0);
		}

		return((int)st.nval);
	}




	private int getOp() {
		int op;

		int modoAtual = this.controladorCaixa.obterModoOperacaoAtual();

		do {
			if (modoAtual==Caixa.MODO_CLIENTE) {  // modo cliente 
				op=getInt
						("opcao: 1 = consulta saldo, 2 = saque, 8 = modo supervisor, 9 = sai");
				if (op!=1 && op!=2 && op!=8 && op!=9) op=0;
			}else {				// modo supervisor 
				op=getInt
						("opcao: 3 = recarrega, 8 = modo cliente, 9 = sai");
				if (op!=3 && op!=8 && op!=9) op=0;
			}
		} while (op==0);
		return(op);
	}

	public void iniciarOperacao (){
		int op;	// código da operação solicitada 
		op=getOp();
		while (op!=9) {
			switch (op) {
			case 1:
				float saldo = controladorCaixa.consultarSaldo(getInt("número da conta"), getInt("senha"));

				if (saldo==-1)  // testa se consulta foi rejeitada 
					System.out.println("conta/senha inválida ou conta inativa");
				else
					System.out.println("Saldo atual: "+saldo); 
				break;

			case 2:
				boolean saqueEfetuado = controladorCaixa.efetuarSaque(getInt("número da conta"), getInt("senha"), getInt("valor"));
				if (saqueEfetuado)		// testa se saque foi aceito 
					System.out.println("Pode retirar o dinheiro");
				else 
					System.out.println("Pedido de saque recusado");
				break;

			case 3:
				controladorCaixa.recarregar(getInt("senha")); 
				break;

			case 8:
				controladorCaixa.alternarModo(getInt("senha do caixa")); 
				break;
			}
			op=getOp();
		}
	}

}