package modelo;

import java.io.Serializable;

public class Medicamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeMedicamento;
	private String dosagemML;
	private String horaParaAplicarRemedio;
	
	public Medicamento(String nomeMedicamento, String dosagemML, String horaParaAplicarRemedio){
		this.nomeMedicamento = nomeMedicamento;
		this.dosagemML = dosagemML;
		this.horaParaAplicarRemedio = horaParaAplicarRemedio;
	}
	
	
	
	public String getNomeMedicamento(){
		return this.nomeMedicamento;
	}
	
	public String getDosagemMedicamento(){
		return this.dosagemML;
	}
	
	public String getHoraDoRemedio(){
		return this.horaParaAplicarRemedio;
	}
}
