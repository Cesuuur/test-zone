package com.company;

import java.lang.reflect.*;

public class getMethod {

    public static void main(String[] args) {

        getMethod cls = new getMethod();
        Class c = cls.getClass();

        try {
            // parameter type is null
            Method m = c.getMethod("show", null);
            System.out.println("method = " + m.toString());
        } catch(NoSuchMethodException e) {
            System.out.println(e.toString());
        }

        try {
            // method Long
            Class[] cArg = new Class[1];
            cArg[0] = Long.class;
            Method lMethod = c.getMethod("showLong", cArg);
            System.out.println("method = " + lMethod.toString());
            long numero = 234;
            lMethod.invoke(cls, numero);
        } catch(NoSuchMethodException e) {
            System.out.println(e.toString());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Integer show() {
        return 1;
    }

    public void showLong(Long l) {
        this.l = l;
        System.out.println(l.toString());
    }
    long l = 78655;
}