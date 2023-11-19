import java.lang.reflect.*;
import java.util.Arrays;

public class MethodCaller
{
    public static void callAnnotatedMethods(AnnotatedMethods obj)
    {
        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods)
        {
            int modifiers = method.getModifiers();
            if (method.isAnnotationPresent(MyAnnotation.class) && (Modifier.isPrivate(modifiers) || Modifier.isProtected(modifiers)))
            {
                MyAnnotation repeatAnnotation = method.getAnnotation(MyAnnotation.class);
                int times = repeatAnnotation.numberOfCalls();

                method.setAccessible(true);

                Parameter[] parameters = method.getParameters();
                Object[] args = new Object[parameters.length];

                for (int i = 0; i < parameters.length; i++)
                {
                    args[i] = getDefault(parameters[i].getType());
                }

                System.out.println("-----------------------------------------------");
                for (int i = 0; i < times; i++) {

                    try
                    {
                        System.out.println(method.getName() + ' ' + Arrays.toString(method.getAnnotations()));
                        method.invoke(obj, args);
                    }
                    catch(InvocationTargetException | IllegalAccessException e)
                    {
                        System.err.println(e.getMessage());
                    }
                }
                System.out.println("-----------------------------------------------");
            }
        }
    }

    private static Object getDefault(Class<?> clazz)
    {
        if (clazz == int.class) return 0;
        if (clazz == double.class) return 0.0;
        if (clazz == float.class) return 0.0f;
        if (clazz == long.class) return 0L;
        if (clazz == char.class) return '\u0000';
        if (clazz == boolean.class) return false;
        if (clazz == String.class) return "";

        Constructor<?> constructor = null;
        int constructorArgsCount = 0;

        try
        {
            constructor = clazz.getConstructors()[0];

        } catch (SecurityException e)
        {
            System.err.println(e.getMessage());
        }

        try
        {
            constructorArgsCount = constructor.getParameterCount();
        }
        catch(NullPointerException e)
        {
            System.err.println(e.getMessage());
        }

        if (constructorArgsCount > 0)
        {
            Object[] constructorArgs = new Object[constructorArgsCount];
            Class<?>[] types = constructor.getParameterTypes();
            for (int i = 0; i < constructorArgsCount; i++)
            {
                constructorArgs[i] = getDefault(types[i]);
            }

            try
            {
                return constructor.newInstance(constructorArgs);
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
            {
                System.err.println(e.getMessage());
            }

        }
        else
        {
            try
            {
                return constructor.newInstance();
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
            {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
