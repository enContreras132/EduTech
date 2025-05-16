package DAO;

public class BD {
    public static void main(String[] args) {
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("❌ No se pudo conectar.");
        }
    }
}
