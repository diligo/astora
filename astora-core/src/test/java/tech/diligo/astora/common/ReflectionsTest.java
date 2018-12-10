package tech.diligo.astora.common;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ReflectionsTest {

    @Test
    public void shouldReturnAccessibleField() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<?> list = new ArrayList<>();
        Field field = Reflections.getDeclaredFieldAndSetAccessible(ArrayList.class, "size");

        assertEquals(0, field.get(list));
    }

    @Test
    public void shouldReturnModifiableField() throws IllegalAccessException {
        String str = new String("aaa");
        Field field = Reflections.getDeclaredFieldAndSetModifiable(String.class, "value");
        field.set(str, "zzzaaabbb123".toCharArray());

        assertEquals("zzzaaabbb123", str);
    }
}
