package botones;

/**
 * Common interface for all buttons. La interfaz de producto declara las
 * operaciones que todos los productos concretos deben implementar.
 *
 * @author refactoring.guru
 */
public interface IBoton {

    void render();

    void onClick();

}
