import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Jared González 202500177
 */
public class Ejercicio2 {
    //Texto
    public static final String TEXTO_BOLETIN = 
        "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA\n" +
        "Facultad de Ingeniería - Boletín Informativo 2024-04-25\n" +
        "Actividades programadas:\n" +
        "Conferencia el 2024-05-01 a las 10:30 en el Edificio T3\n" +
        "Examen parcial el 2024-05-15 a las 08:00 en el Edificio S11\n" +
        "Defensa de proyecto el 2024-06-10 a las 14:30 en el Edificio T7\n" +
        "Contactos del departamento:\n" +
        "Coordinador: coord.ipc1@ingenieria.usac.edu.gt Tel: 2418-8000\n" +
        "Auxiliar 1: aux01_ipc1@ingenieria.usac.edu.gt Tel: 5555-1234\n" +
        "Auxiliar 2: aux02.ipc1@gmail.com Tel: 4321-9876";
    //Extraer fechas
    public static void extraerFechas() {
        //formato de feca
        String regex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TEXTO_BOLETIN);

        System.out.println("--- Fechas Encontradas ---");
        //Mientras el matcher encuentre coincidencais
        while (matcher.find()) {
            String anio = matcher.group(1); // Extrae parte 1
            String mes = matcher.group(2);  // Extrae parte 2
            String dia = matcher.group(3);  // Extrae parte 3
            //Impresión de resultados
            System.out.println("Anio: " + anio + " | Mes: " + mes + " | Dia: " + dia);
        }
    }
    // Método 2 - Extraer correos electrónicos
    public static void extraerCorreos() {
        String regex = "[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TEXTO_BOLETIN);

        System.out.println("\n--- Correos Encontrados ---");
        while (matcher.find()) {
            //Devolver toda la coincidencia
            System.out.println(matcher.group()); 
        }
    }
    // Método 3 - Censurar datos sensibles en orden
    public static String censurarDatos(String entrada) {
        //regex
        String regexCorreo = "[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+";
        Pattern patternCorreo = Pattern.compile(regexCorreo);
        //definir la entrada
        Matcher matcherCorreo = patternCorreo.matcher(entrada);
        //Usar replace all 
        String textoSinCorreos = matcherCorreo.replaceAll("[CORREO]");
        //Censura del telefono
        String regexTelefono = "[0-9]{4}-[0-9]{4}";
        Pattern patternTelefono = Pattern.compile(regexTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(textoSinCorreos);
        String textoCensuradoFinal = matcherTelefono.replaceAll("[TEL]");

        return textoCensuradoFinal;
    }
    public static void main(String[] args) {
        //Llamada a métodos
        extraerFechas();
        extraerCorreos();

        //Prueba de censura
        System.out.println("\n--- Prueba de Censura ---");
        String casoPrueba = "Llama a 5555-1234 o escribe a juan@usac.edu.gt para mas info.";
        System.out.println("Entrada: " + casoPrueba);
        System.out.println("Salida:  " + censurarDatos(casoPrueba));
    }
}