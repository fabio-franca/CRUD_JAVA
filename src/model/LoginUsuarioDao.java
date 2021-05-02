package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginUsuarioDao {

private Connection con;
	
	@SuppressWarnings("static-access")
	public LoginUsuarioDao() {
		con = new ConnectionFactory().getConnection();
	}
	
	public void salvarUsuario(LoginUsuario loginUsuario) {
		
		String sql = "insert into login (login, senha) values(? , ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, loginUsuario.getLogin());
			ps.setString(2, loginUsuario.getSenha());
			
			ps.execute();
			ps.close();
			
			System.out.println("Login salvo com sucesso");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void excluirUsuario(long id) {
	
		String sql = "delete from login  where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ps.execute();
			ps.close();
			
			System.out.println("Login excluído com sucesso");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
