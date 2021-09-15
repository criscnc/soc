package action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import classes.Exame;
import dao.ExameDao;

public class ExameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String nomePaciente;
	private String nomeExame;
	private String dtExame;
	private String obs;
	private List<Exame> listarExames;	
	private String ret;
	
	public String adicionarExame() throws SQLException, ParseException {
		
		boolean dtObrigatoria = true;
		String retorno = null;
		
		if(getNomePaciente().isEmpty() || getNomeExame().isEmpty() || getDtExame().isEmpty()) {
			addActionError(getText("error.field"));
			retorno = "erro";
		}else {
			retorno = validaData(getDtExame(), dtObrigatoria);
		}
				
		if(retorno != "erro") {

			Exame exame = new Exame(getNomePaciente(), getNomeExame(), getDtExame(), getObs(), null);
			
			retorno = ExameDao.adicionarExame(exame);
			
			if(retorno.equals("erro")) {
				addActionError(getText("error.paciente"));
			}
			
		}
		
		return retorno;
	}
	
	public String buscarExame() throws SQLException, ParseException {
		
		boolean dtObrigatoria = false;
		String retorno = null;
		
		if(getNomePaciente().isEmpty() && getNomeExame().isEmpty() && getDtExame().isEmpty() && getObs().isEmpty()) {
			addActionError(getText("error.search"));
			retorno = "erro";
		}else {
			retorno = validaData(getDtExame(), dtObrigatoria);
		}	
		
		if(retorno != "erro") {
			
			Exame exame = new Exame(getNomePaciente(), getNomeExame(), getDtExame(), getObs(), null);
			
			Exame ex = ExameDao.buscarExame(exame);
			
			retorno = ex.getRetorno();
			setNomePaciente(ex.getNomePaciente());
			setNomeExame(ex.getNomeExame());
			setDtExame(ex.getDtExame());
			setObs(ex.getObs());
			
			if(ex.getRetorno().equals("erro")) {
				addActionError(getText("error.buscar"));
			}			
		}
		
		return retorno;
	}	
	
	public String alterarExame() throws SQLException, ParseException {
		
		boolean dtObrigatoria = true;
		String retorno = null;
		
		if(getNomePaciente().isEmpty() || getNomeExame().isEmpty() || getDtExame().isEmpty()) {
			addActionError(getText("error.field"));
			retorno = "erro";
		}else {		
			retorno = validaData(getDtExame(), dtObrigatoria);
		}
		
		if(retorno != "erro") {
			
			Exame exame = new Exame(getNomePaciente(), getNomeExame(), getDtExame(), getObs(), null);
			
			retorno = ExameDao.alterarExame(exame);
			
		}
		
		return retorno;
	}	
	
	public String excluirExame() throws SQLException {
	
		String retorno = null;
		
		Exame exame = new Exame(getNomePaciente());
		
		retorno = ExameDao.excluirExame(exame);	
		
		if(retorno.equals("erro")) {
			addActionError(getText("error.excluir"));
		}		
		
		return retorno;
	}	
	
	public String limparExame() {
		setNomePaciente(null);
		setNomeExame(null);
		setDtExame(null);
		setObs(null);
		
		return "limpa";
	}	
	
	
	public String listarExames() throws SQLException{
		
		Exame ex = ExameDao.listarExames();	
		
		String  retorno = ex.getRetorno();
		setListaExames(ex.getListarExames());
	
		return retorno;
	}
	
	
	public String validaData(String dtExame, boolean dtObrigatoria) throws ParseException {
		
		String retorno = null;
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dtAtual = new Date();

		if(!dtExame.isEmpty()){
			Date dataFormatada = formatar.parse(getDtExame());
			
			if(dataFormatada.before(dtAtual) && dtObrigatoria == true) {
				addActionError(getText("error.dtExameMenor"));
				retorno = "erro";
			}else {
				setDtExame(formatar.format(dataFormatada));
			}
			
		}else {
			if(dtObrigatoria == true) {
				addActionError(getText("error.dtExame"));
				retorno = "erro";
			}
	    }
		return retorno;
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

	public List<Exame> getListaExames() {
		return listarExames;
	}

	public void setListaExames(List<Exame> listaExames) {
		listarExames = listaExames;
	}

	public List<Exame> getListarExames() {
		return listarExames;
	}

	public void setListarExames(List<Exame> listarExames) {
		this.listarExames = listarExames;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}
		
}
