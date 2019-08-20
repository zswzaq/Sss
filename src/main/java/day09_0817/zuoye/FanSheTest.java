package day09_0817.zuoye;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FanSheTest {

    public static void main(String[] args) throws Exception {
        // 反射：获取类的反射（字节码对象）
        // 1.注册方式：Class.forName();2.类.class;;;; 3.new一个类对象,对象.getClass()方法
        Class<FanShe> class1 = FanShe.class;
        Class<?> class2 = Class.forName("day09_0817.zuoye.FanShe");
        FanShe fanShe = new FanShe();
        Class<? extends FanShe> class3 = fanShe.getClass();

        // System.out.print((class1 == class2) + " ");
        // System.out.println(class3 == class2);
        // 获取当前类的类名，包括了路径
        String name = class1.getName();
        // System.out.println(name);
        // 判断是否为接口
        boolean interface1 = class1.isInterface();
        // 获取当前类的包名
        String name1 = class1.getPackage().getName();
        // 获取父类的类名
        String name2 = class1.getSuperclass().getName();
        // 二：获取本类的字段
        // 获取当前类的所有public字段
        Field[] fields = class1.getFields();
        /*
         * for (Field field : fields) { System.out.println(field.getName()); }
         */
        // 获取当前类的所有字段
        Field[] declaredFields = class1.getDeclaredFields();
        for (Field field : declaredFields) {
            // System.out.println(field.getName());
        }
        // 根据字段名获取字段
        // Field field = class1.getField(name);
        // 获取字段的修饰符
        // field.getModifiers();
        // 获取字段类型
        // field.getType();
        // 获取字段名
        // field.getName();

        // 三：方法
        // class1.getMethods()：获取当前类的所有public方法
        // 获取当前类的所有方法
        // class1.getDeclaredMethod("方法名", 参数类型.class。。。);
        // class1.getMethod(name, parameterTypes)：根据方法名和参数类型获取对应的方法
        Method addMethod = class1.getMethod("add", Integer.class, Integer.class);
        int c = (Integer) addMethod.invoke(fanShe, 1, 2);
        // System.out.println(c);

        // 静态方法的调用
        Method method = class1.getMethod("addc");
        // method.invoke(null);

        // 四：获取类的构造函数
        // 获取当前类的所有public构造函数
        // class1.getConstructors(参数类型。。。)
        // 获取当前类的所有构造函数
        // class1.getDeclaredConstructors()
        Constructor<FanShe> constructor = class1.getConstructor(String.class, String.class);
        // 用构造器创建对象
        Object object = constructor.newInstance("zcv", "zs");
        System.out.println(object);

        // method.getModifiers()：获取方法修饰符
        // method.getReturnType()：获取返回值类型
        // method.getName()：获取方法名
        // method.getParameterCount()：获取方法的参数个数
        // method.getParameterTypes()：获取方法的参数类型

        // 五：反射调用方法：
        // 可能会抛出的异常：NoSuchMethodException
        // Method method2 = class1.getDeclaredMethod("方法名", 参数类型.class。。。);
        // 可能会抛出的异常：IllegalAccessException,IllegalArgumentException
        // method1.invoke(obj, initargs);

        // 六： 创建对象
        // class1.newInstance()；1.用类
        // Constructor c=class3.getConstructor(parameterTypes);
        // 2.用构造器创建对象
        // c.newInstance(initargs);

        // 根据对应的参数类型获取构造函数
        // constructor.getParameterTypes()
        // 构造函数的参数类型列表
        // constructor.getName()
        // 构造器的函数名
        // constructor.getParameterTypes().length
        // 构造函数的参数个数
        // constructor.getModifiers()
        // 构造函数的修饰符

    }

}
