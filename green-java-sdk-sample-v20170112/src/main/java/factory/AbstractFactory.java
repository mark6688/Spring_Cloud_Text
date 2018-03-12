package factory;

/**
 * Created by mk on 2018/1/2.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
}
