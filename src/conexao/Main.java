package conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


public class Main {

	public static void main(String[] args)  throws SQLException {

		Conexao conexao = new Conexao();
		conexao.getConnection();
			System.out.println("Conexão bem sucedida!");
			
			String sql = "INSERT INTO contatos"+
			"(nome, email, endereco, nascimento)"+
					"values (?,?,?,?)";
					
			PreparedStatement smts = conexao.getConnection().prepareStatement(sql);
			
			smts.setString(1, "Marcelo");
			smts.setString(2, "marcelogmail.com");
			smts.setString(3, "Avenida de xotas, 1322");
			smts.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			
			smts.execute();
			
			conexao.getConnection().close();
			
			conexao.getConnection();
			
			System.out.println("Gravado!");
			
			String sql2 = "SELECT * FROM contatos";
					
			smts = conexao.getConnection().prepareStatement(sql2);
			
			ResultSet rs = smts.executeQuery();
			
			
			while(rs.next()) {
				
				String nome = rs.getString("nome");
				System.out.println(nome);
			}
			
			conexao.getConnection().close();
			
			//--------------------------------------------------
			
			conexao.getConnection();
			
			String sql3 = "DELETE FROM contatos WHERE nome=?";
			
			smts = conexao.getConnection().prepareStatement(sql3);
			
			smts.setString(1,"Felipes");
			
			smts.execute();
			
			conexao.getConnection().close();
			
			//--------------------------------------------------

			conexao.getConnection();
			
			String sql4 = "UPDATE contatos SET email=? WHERE nome=?";
			
			smts = conexao.getConnection().prepareStatement(sql4);
					
			smts.setString(1, "nicholas14@gmail.com");
			smts.setString(2, "Nicholas");
			
			smts.execute();
			
			conexao.getConnection().close();
			
		}
		
	}


  