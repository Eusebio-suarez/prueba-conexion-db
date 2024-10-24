import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRes = null;
        Scanner sc = new Scanner(System.in);
        try {
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project",
                    "root",
                    ""
            );
            System.out.println("Genial, nos conectamos");
            int opcion;
            System.out.println("1. insertar empleado");
            System.out.println("2. consultar empleado");
            System.out.println("3. actualizar empleado");
            System.out.println("4. eliminar empleado");
            System.out.println("Ingrese la opcion:");

            opcion= sc.nextInt();
            int id;
            String nombre;
            String cargo;
            double salario;
            switch (opcion){
                case 1:
                    System.out.println("ingresee el nombre:");
                        nombre = sc.nextLine();
                    System.out.println("ingrese el cargo:");
                        cargo = sc.nextLine();
                    System.out.println("ingrese el salario:");
                        salario = sc.nextDouble();
                   ConexionMySQL.insertarEmpleado(myConn,nombre,cargo,salario);
                break;

                case 2:
                    ConexionMySQL.consultarEmpleados(myConn);
                break;

                case 3:
                    System.out.println("ingresee el ID del emlpleado a actualizar:");
                    id = sc.nextInt();
                    System.out.println("ingresee el nueve nombre:");
                    nombre = sc.nextLine();
                    System.out.println("ingrese el  nuevo cargo");
                    cargo = sc.nextLine();
                    System.out.println("ingrese el  nuevo salario:");
                    salario = sc.nextDouble();
                    ConexionMySQL.actualizarEmpleado(myConn,id,nombre,cargo,salario);
                break;

                case 4:
                    System.out.println("ingresee el ID del emlpleado a eliminar:");
                    id = sc.nextInt();
                    ConexionMySQL.eliminarEmpleado(myConn,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal :(");
        }
    }
}
