package presentacion;

import dominio.SistemaCampeonato;
import static dominio.SistemaCampeonato.*;
import dominio.TipoCampeonato;
import static dominio.TipoCampeonato.*;
import java.time.LocalDate;
import java.util.Scanner;
import negocio.GestorCampeonatoImp;
import negocio.IGestorCampeonato;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuOpciones();
    }

    public static void menuOpciones() {
        IGestorCampeonato campeonato = new GestorCampeonatoImp();
        // Dummy Test
        campeonato.regCamp("Primera", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 03, 30), ELIMINATORIAS, APERTURA, 16);
        campeonato.regCamp("Copa Messi", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 05, 30), ELIMINATORIAS, CLAUSURA, 32);
        campeonato.regCamp("Copa Verano", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 04, 30), TODOSCTODOS, CLAUSURA, 20);
        campeonato.regCamp("Nacional X", LocalDate.of(2022, 6, 1), LocalDate.of(2022, 10, 30), TODOSCTODOS, APERTURA, 40);
        Scanner teclado = new Scanner(System.in);

        int opciones;
        do {
            System.out.printf("%nMENU"
                    + "%n1 - %-20s"
                    + "%n2 - %-20s"
                    + "%n3 - %-20s"
                    + "%n4 - %-20s"
                    + "%n5 - %-20s"
                    + "%n6 - %-20s"
                    + "%n0 - %-20s"
                    + "%nIngrese una opcion: ",
                    "Registrar campeonato",
                    "Modificar campeonato",
                    "Consultar campeonato",
                    "Eliminar campeonato",
                    "Listar campeonatos por fecha",
                    "Filtrar campeonatos",
                    "Salir");
            opciones = Integer.parseInt(teclado.nextLine());

            switch (opciones) {
                case 1: // Registrar
                    // Nombre
                    System.out.println("Ingrese el nombre del campeonato: ");
                    String nombre = teclado.nextLine();
                    // Ingreso de fechas
                    LocalDate fechaIni = null;
                    int control = 1;
                    while(control == 1){
                        System.out.println("Ingrese fecha de inicio del campeonato: ");
                        fechaIni = setDate();
                        control = campeonato.checkDate(fechaIni);
                    }
                    LocalDate fechaFin = null;
                    int control2 = 1;
                    while(control2 == 1){
                        System.out.println("Ingrese fecha de fin del campeonato: ");
                        fechaFin = setDate();
                        control2 = campeonato.checkDate(fechaFin);
                    }
                    // Sistema
                    SistemaCampeonato sistemaCampeonato = setSistema();
                    // Tipo
                    TipoCampeonato tipoCampeonato = setTipo();
                    // Equipos
                    System.out.println("Ingrese cantidad de equipos: ");
                    int cantidadEquipos = Integer.parseInt(teclado.nextLine());
                    // Registro
                    campeonato.regCamp(nombre, fechaIni, fechaFin, sistemaCampeonato, tipoCampeonato, cantidadEquipos);
                    break;
                case 2: // Modificar
                    System.out.println("Nombre Camp a Modificar: ");
                    String nom = teclado.nextLine();
                    int mod = selMod();
                    if(mod == 1){
                        LocalDate fechaIn = setDate();
                        campeonato.modFecha(nom, fechaIn);
                    }else{
                        System.out.println("Ingrese cantidad de equipos: ");
                        int eq = Integer.parseInt(teclado.nextLine());
                        campeonato.modEq(nom, eq);
                    }
                    break;
                case 3: // Consultar
                    System.out.println("Nombre a buscar: ");
                    String nomCamp = teclado.nextLine();
                    System.out.println(campeonato.consuCamp(nomCamp));
                    break;
                case 4: // Eliminar
                    System.out.println("Camponato a borrar: ");
                    String campDel = teclado.nextLine();
                    campeonato.delCamp(campDel);
                    break;
                case 5: // Listar por fecha
                    System.out.println(campeonato.listCamp());
                    break;
                case 6: // Filtrar
                    System.out.println("Ingrese letras a filtrar: ");
                    String patron = teclado.nextLine();
                    System.out.println(campeonato.filtrarCamp(patron));
                    break;
                case 0:
                    System.out.println("Chau, gracias!");
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }

        } while (opciones != 0);

    }

    public static LocalDate setDate() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Año: ");
        int anio = Integer.parseInt(teclado.nextLine());

        System.out.println("Mes [1 a 12]: ");
        int mes = Integer.parseInt(teclado.nextLine());

        System.out.println("Día:");
        int dia = Integer.parseInt(teclado.nextLine());

        return LocalDate.of(anio, mes, dia);

    }

    public static SistemaCampeonato setSistema() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Sistema de Campeonato: "
                + "\n1 - Todos contra todos"
                + "\n2 - Eliminatorias");
        int nroTipo = Integer.parseInt(teclado.nextLine());

        switch (nroTipo) {
            case 1:
                return SistemaCampeonato.TODOSCTODOS;
            case 2:
                return SistemaCampeonato.ELIMINATORIAS;
            default:
                return null;
        }
    }

    public static TipoCampeonato setTipo() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Tipo de Campeonato: "
                + "\n1 - Apertura"
                + "\n2 - Clausura");
        int nroTipo = Integer.parseInt(teclado.nextLine());

        switch (nroTipo) {
            case 1:
                return TipoCampeonato.APERTURA;
            case 2:
                return TipoCampeonato.CLAUSURA;
            default:
                return null;
        }
    }
    
    public static int selMod(){
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 1 && opcion != 2){
            System.out.println("Modificar Fecha de Inicio o Cantidad de Equipos"
                    + "\nIngrese (1) para modificar fecha"
                    + "\nIngrese (2) para modificar equipos"
                    + "\nOpcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
        }
        return opcion;
    }
    
    
    
}
