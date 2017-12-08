import com.medicineCenter.model.dataObject.Experts;

import java.lang.reflect.Field;

/**
 * Created by huang on 2017/3/2.
 */
public class test {
    public static void main(String[] args) throws Exception {
        Experts experts = new Experts();
        experts.setCategoryTwo("1");
        experts.setAge("2");
        testReflect(experts);

   }

    public static <T> void testReflect(T model) throws Exception{
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(model) );
        }
    }
}
