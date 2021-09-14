package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import classes.Login;
import dao.LoginDao;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String senha;

	public String execute() throws SQLException {
		
		Login login = new Login(getUsuario(), getSenha());

		String retorno = LoginDao.getLogar(login);
		
		if(retorno.equals("erro")) {
			addActionError(getText("error.login"));
		}
		
		return retorno;

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	


}
