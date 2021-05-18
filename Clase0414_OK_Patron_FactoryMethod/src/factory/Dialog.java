package factory;

import botones.IBoton;

/**
 * Base factory class. La clase creadora declara el metodo fábrica que debe
 * devolver un objeto de una clase de producto. Normalmente, las subclases de la
 * creadora proporcionan la implementación de este metodo.
 *
 * @author refactoring.guru
 */
public abstract class Dialog {

    /**
     * Observa que, a pesar de su nombre, la principal responsabilidad de la
     * creadora no es crear productos. Normalmente contiene cierta logica de
     * negocio que depende de los objetos de producto devueltos por el metodo
     * fabrica. Las subclases pueden cambiar indirectamente esa logica de
     * negocio sobrescribiendo el método fábrica y devolviendo desde él un tipo
     * diferente de producto.
     */
    public void renderWindow() {
        //...otro codigo...

        // Invoca el metodo fabrica para crear un objeto de producto.
        IBoton okBoton = crearBoton();
        
        // Ahora utiliza el producto.
        okBoton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects. La creadora también puede proporcionar cierta implementación por
     * defecto del metodo fabrica.
     *
     * @return
     */
    public abstract IBoton crearBoton();

}
