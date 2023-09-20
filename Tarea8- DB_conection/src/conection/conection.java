package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conection {
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/fes_aragon"; // Direccion, puerto y nombre de la Base
																				// de Datos
	public static final String USERNAME = "root"; // Usuario de Acceso a MySQL, para la configuracion por defecto se
													// mantienen en blanco
	public static final String PASSWORD = "Elmadrid24"; // Password del usuario, para la configuracion por defecto se
															// mantienen en blanco
	// Varables de consulta
	PreparedStatement ps;
	ResultSet rs;

	public static void main(String[] args) {
		conection conection = new conection();
		conection.ActionPerformed();
	}

	// Conexion a la base de datos
	public static Connection getConection() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");// ruta de driver
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);// se realiza la conexion y se
																					// mandan los datos
			JOptionPane.showMessageDialog(null, "Conexion exitosa");

		} catch (Exception e) {

			System.out.println("fallo");
		}
		return con;
	}

	private void ActionPerformed() {// GEN-FIRST:event_btnBuscarActionPerformed

		Connection con = null;

		try {

			con = getConection();
			ps = con.prepareStatement("SELECT * FROM persona WHERE telefono = 5623387");
			// ps.setString(1, txtClave.getText());
			rs = ps.executeQuery();// trae los resultados de la consulta
			while (rs.next()) {
				System.out.println("Nombre de usuario: " + rs.getString(1) + ", Carrera: " + rs.getString(2)
						+ ", Numero de cuenta: " + rs.getInt(3) + ", Direccion: " + rs.getString(4) + ", Telefono: "
						+ rs.getString(5) + ", Email: " + rs.getString(6) + ", Password: " + rs.getString(7)
						+ ", Fecha de registro " + rs.getDate(8) + ", Permisos: " + rs.getInt(9));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// GEN-LAST:event_btnBuscarActionPerformed

}