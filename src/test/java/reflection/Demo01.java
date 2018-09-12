package reflection;

import annotation.TestAnnotation1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo01 {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("reflection.User");
//        Field[] fields = clazz.getDeclaredFields();
//        for(Field f : fields){
//            System.out.println(f);
//        }
        System.out.println(clazz.getSimpleName());

        User u = (User)clazz.newInstance();
        Field field = clazz.getDeclaredField("id");
        TestAnnotation1 a1 = field.getDeclaredAnnotation(TestAnnotation1.class);
        System.out.println(a1.columnName()+"--"+a1.type()+"--"+a1.length());

        Method method = clazz.getDeclaredMethod("setUname", String.class);
        Method method2 = clazz.getDeclaredMethod("getUname");
        method.invoke(u,"lifan");
        System.out.println(u.getUname());
        System.out.println(method2.invoke(u));

        Constructor constructor = clazz.getConstructor(int.class,int.class,String.class);
        System.out.println(constructor);
    }
}
