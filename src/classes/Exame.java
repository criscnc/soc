package classes;

import java.util.List;

public class Exame {
	
	private String nomePaciente;
	private String nomeExame;
	private String dtExame;
	private String obs;
	private List<Exame> listarExames;
	private String retorno;

	public Exame() {		
	}

	public Exame(String nomePaciente, String nomeExame, String dtExame, String obs, String retorno) {
		super();
		this.nomePaciente = nomePaciente;
		this.nomeExame = nomeExame;
		this.dtExame = dtExame;
		this.obs = obs;
		this.retorno = retorno;
	}
	
	public Exame(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}	

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getDtExame() {
		return dtExame;
	}

	public void setDtExame(String dtExame) {
		this.dtExame = dtExame;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}	
	
	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public List<Exame> getListarExames() {
		return listarExames;
	}

	public void setListarExames(List<Exame> listarExames) {
		this.listarExames = listarExames;
	}

}
