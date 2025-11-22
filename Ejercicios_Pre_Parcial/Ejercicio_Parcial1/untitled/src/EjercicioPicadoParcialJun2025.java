import java.util.Scanner;

/**
 * Para un sistema de registro de usuarios que verifica que la edad sea mayor o igual a
 * 18 y su nombre no sea nulo.
 * - Ventajas y desventajas de utilizar excepciones y mensaje VS system.exit en
 * términos de escalabilidad, visualización de código, manejo de
 * responsabilidades, etc.
 * - Implementar el código para ambos casos
 */

public class EjercicioPicadoParcialJun2025 {

    public static void main(String[] args) throws UsuarioInvalidoException {

        Scanner sc = new Scanner(System.in);
        Usuario user = new Usuario("Federico", 24);
        validar(user);
        Usuario user2 = new Usuario("Elian", 17);
        validar(user2);

    }









    public static void validar(Usuario usuario) throws UsuarioInvalidoException {
        if(usuario.getEdad() < 18){
            throw new UsuarioInvalidoException("Edad invalida");
        }
        if (usuario.getNombre() == null){
            throw new UsuarioInvalidoException("El nombre no debe estar vacio");
        }
    }


}

class UsuarioInvalidoException extends Exception{
    public UsuarioInvalidoException(String mensaje){
        super(mensaje);
    }
}


 class Usuario{
    private String nombre;
    private int edad;

    public Usuario (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }


}
