package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class oneClass {
    public void myFunc() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        unknownedClass bla = new unknownedClass(this);
    }

    public void prueba1(int uno)
    {
        System.out.println("Callback" + uno);
    }

    public void prueba2(int dos)
    {
        System.out.println("Callback" + dos);
    }
}

public class unknownedClass {
    public unknownedClass(Object obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // Clase del "objeto" desconocido
        Class<?> clazz = obj.getClass();

        Class[] cArg = new Class[1];
        cArg[0] = int.class;
        // Obtenemos el método con los parámetros deseados
        Method method1 = clazz.getMethod("prueba1", cArg);
        method1.invoke(obj,1);
        // Obtenemos el método con los parámetros deseados
        Method method2 = clazz.getMethod("prueba2", cArg);
        method2.invoke(obj,2);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            unknownedClass nolose = new unknownedClass(new oneClass());
    }
}