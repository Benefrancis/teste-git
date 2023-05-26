#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Random;

class Desafio {
    private static String gerarEtiqueta() {

        String numero;

        numero = String.valueOf(new Random().nextInt(999999999));

        // numero = "123";

        var valor = Integer.valueOf(numero.substring(numero.length() - 2));
        String digito = (valor >> 2) > 10 ? String.valueOf(valor >> 2) : "0" + (valor >> 2);
        return numero + "-" + digito;
    }

    private static boolean isValid(String etiqueta) {
        etiqueta = etiqueta.replace("-", "");
        String x = etiqueta.substring(etiqueta.length() - 2);
        var z = Integer.valueOf(etiqueta.substring(etiqueta.length() - 4, etiqueta.length() - 2));
        z >>= 2;
        String digito = (z > 10) ? String.valueOf(z) : "0" + z;
        return x.equals(digito);
    }

    public static void main(String[] args) {
        String etiqueta = gerarEtiqueta();
        var resultado = String.format("%n%nA etiqueta %s %s!%n%n", etiqueta, isValid(etiqueta) ? "é válida" : "não é válida");
        System.out.println(resultado);
    }
}