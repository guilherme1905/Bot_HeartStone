package Projeto;

public class Quarto {
	
	protected String tipo;
	protected int PreçoDaDiária;
	protected int NumeroDePessoas;
	protected String descrição;
	protected int status;
	protected int numeroHosp;
	protected int[][] ocupacao;

	public Quarto(String tipo1, int PreçoDaDiária1, int NumeroDePessoas1, String descrição1, int s, int n){
		tipo = tipo1;
		PreçoDaDiária = PreçoDaDiária1;
		NumeroDePessoas = NumeroDePessoas1;
		descrição = descrição1;
		status = s;
		numeroHosp = n;
		ocupacao =  new int[12][30];
		zerar();
	}
	
	public void zerar() {
		for (int i=0; i<12 ; i++){
			for (int j=0; j<30; j++)
				this.ocupacao[i][j] = 0;
		}	
	}
}
