package ru.job4j.pseudo;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class ShapeFactory {
    private static ShapeAbstractFactory factory;

    public ShapeFactory(ShapeAbstractFactory factory) {
        this.factory = factory;
    }

    public Shape create(String name) {
        Shape shape = factory.createEmpty();
        if ("triangle".equals(name)) {
            shape = factory.createTriangle();
        } else if ("square".equals(name)) {
            shape = factory.creatSquare();
        }
        return shape;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory(factory);
        shapeFactory.create("triangle").draw();
    }
}
