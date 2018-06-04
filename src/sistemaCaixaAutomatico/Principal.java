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

public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Instanciacao do caixa automatico com a senha do caixa
		TrmCxAut meuTrmCxAut = new TrmCxAut(123);
		
		//utilizacao do terminal do caixa
		meuTrmCxAut.iniciarOperacao();

	}

}