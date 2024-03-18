package application;

import db.Db;
import db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        PreparedStatement ps = null;

        try {
            conn = Db.getConnection();

            //Criar departamento
            System.out.println("\n=== CREATING DEPARTMENT ===");
            ps = conn.prepareStatement("INSERT INTO department "
                    + "(id, name) "
                    + "VALUES "
                    + "(?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, 4);
            ps.setString(2, "Financeiro");
            ps.executeUpdate();

            //Criar funcionario
            System.out.println("\n=== CREATING EMPLOYEE ===");
            ps = conn.prepareStatement("INSERT INTO employee "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, 4);
            ps.setString(2, "Isabel");
            ps.setString(3, "isabel@gmail.com");
            ps.setString(4, "F");
            ps.setInt(5, 2);
            ps.executeUpdate();

            System.out.println("\n=== LIST OF DEPARTMENTS ===");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM department");
            while(rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            System.out.println("\n=== LIST OF EMPLOYEES ===");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email")  + ", Gender: " + rs.getString("gender")   + ", DepartmentId: " + rs.getInt("department_id") );
            }

            System.out.println("\n=== UPDATING DEPARTMENT ===");
            ps = conn.prepareStatement("UPDATE department SET name = ? WHERE id = ?");
            ps.setString(1, "Operacional");
            ps.setInt(2, 2);
            ps.executeUpdate();

            System.out.println("\n=== UPDATING EMPLOYEE ===");
            ps = conn.prepareStatement("UPDATE employee SET name = ?, email = ?, gender = ?, department_id = ? WHERE id = ?");
            ps.setString(1, "Vitor");
            ps.setString(2, "vitor@gmail.com");
            ps.setString(3, "M");
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.executeUpdate();

            System.out.println("\n=== DELETING DEPARTMENT ===");
            ps = conn.prepareStatement("DELETE FROM department WHERE id = ?");
            ps.setInt(1, 4);
            ps.executeUpdate();

            System.out.println("\n=== DELETING EMPLOYEE ===");
            ps = conn.prepareStatement("DELETE FROM employee WHERE id = ?");
            ps.setInt(1, 2);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closePreparedStatement(ps);
            Db.closeStatement(st);
            Db.closeConnection();
        }
    }
}