import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class MathService {

    @CacheResult
    public int slowSquare(int n) {
        System.out.println("Computing square for " + n);
        return n * n;
    }
}

class CacheExecutor {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object obj, Method method, Object... args) throws Exception {

        String key = method.getName() + args[0]; 

       
        if (cache.containsKey(key)) {
            System.out.println("Returning cached result");
            return cache.get(key);
        }

        Object result = method.invoke(obj, args);
        cache.put(key, result);

        return result;
    }
}

public class CacheResultDemo {
    public static void main(String[] args) throws Exception {

        MathService service = new MathService();
        Method method = MathService.class.getMethod("slowSquare", int.class);

        System.out.println(CacheExecutor.execute(service, method, 5));
        System.out.println(CacheExecutor.execute(service, method, 5)); // cached
        System.out.println(CacheExecutor.execute(service, method, 6));
        System.out.println(CacheExecutor.execute(service, method, 6)); // cached
    }
}
