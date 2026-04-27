import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Jared González 202500177
 */
public class Ejercicio1 {
    
    //Validar carnet
    public static boolean validarCarnet(String carnet) {
        //Expresión regular 
        String regex = "^[0-9]{4}[0-9]{5}$"; 
        //interprete
        Pattern pattern = Pattern.compile(regex);
        //objeto matcher 
        Matcher matcher = pattern.matcher(carnet);
        //Retorna true si coincide exactamente
        return matcher.matches();
    }
    
    // Método 2: Validar Correo Institucional USAC
    public static boolean validarCorreo(String correo) {
        // El primer caracter debe ser alfanumérico, seguido de alfanuméricos, puntos o guiones bajos
        String regex = "^[a-zA-Z0-9][a-zA-Z0-9._]*@usac\\.edu\\.gt$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
    // Método 3: Validar Número de Teléfono
    public static boolean validarTelefono(String telefono) {
        // Empieza con 3, 4, 5 o 6, seguido de 3 dígitos, un guión opcional y 4 dígitos finales
        String regex = "^[3-6][0-9]{3}-?[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        // Metodo carnet
        System.out.println("--- Pruebas Metodo 1: Carnet ---");
        System.out.println("202300123: " + (validarCarnet("202300123")));
        System.out.println("202512345: " + (validarCarnet("202512345")));
        System.out.println("20230012: " + (validarCarnet("20230012")));
        System.out.println("2023ABC12: " + (validarCarnet("2023ABC12")));
        // metodo correo
        System.out.println("\n--- Pruebas Metodo 2: Correo ---");
        System.out.println("juan.perez@usac.edu.gt: " + (validarCorreo("juan.perez@usac.edu.gt")));
        System.out.println("carla_001@usac.edu.gt: " + (validarCorreo("carla_001@usac.edu.gt")));
        System.out.println("juan@gmail.com: " + (validarCorreo("juan@gmail.com")));
        System.out.println(".juan@usac.edu.gt: " + (validarCorreo(".juan@usac.edu.gt")));
        // metodo telefono
        System.out.println("\n--- Pruebas Metodo 3 : Telefono ---");
        System.out.println("5555-1234: " + (validarTelefono("5555-1234")));
        System.out.println("30001234: " + (validarTelefono("30001234")));
        System.out.println("1234-5678: " + (validarTelefono("1234-5678")));
        System.out.println("555-1234: " + (validarTelefono("555-1234")));
    }
}