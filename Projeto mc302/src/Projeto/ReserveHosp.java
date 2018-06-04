package Projeto;

public class ReserveHosp {
	
	public String nome;
	public int documento;
	public String tipo;
	public int dataChegada;
	public int horaChegada;
	public int dataSaida;
	public int horaSaida;
	public int status;
	
	public ReserveHosp (String n, int t, String e, int dc, int hc, int ds, int hs, int s){
		nome  = n;
		documento = t;
		tipo = e;
		dataChegada = dc;
		horaChegada = hc;
		dataSaida = ds;
		horaSaida = hs; 
		status = s;
	}

}
