package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class teste {

	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql="insert into contato (nome,sobrenome,idade,telefone) values('maria','silva',27,'996766060')";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
			
			System.out.println("Contato salvo com sucesso!");
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
	}

}
