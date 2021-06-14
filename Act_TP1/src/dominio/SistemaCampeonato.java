package dominio;

/**
 *
 * @author Marce marcelorum@gmail.com
 */
public enum SistemaCampeonato {
    TODOSCTODOS("Sistema simple de liga por puntos"),
    ELIMINATORIAS("Sistema de eliminatoria simple");
    
    //Campo tipo constante
    
    private final String caracteristica;
    
    //Métodos de la clase tipo Enum
    
    private SistemaCampeonato(String car){
        this.caracteristica = car;
    }
    
    public String getCaracteristica(){
        return caracteristica;
    }
    
}
