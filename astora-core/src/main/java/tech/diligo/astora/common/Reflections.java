package tech.diligo.astora.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class Reflections {

    private static final int DEFAULT_METHOD_DESCRIPTOR_BUFFER_SIZE = 32;
    private static final String MODIFIERS_FIELD_NAME = "modifiers";

    private Reflections() {
    }

    /**
     * Generate method descriptor.
     *
     * @param method method information
     * @return method descriptor
     */
    public static String methodDescriptor(Method method) {
        StringBuilder builder = new StringBuilder(DEFAULT_METHOD_DESCRIPTOR_BUFFER_SIZE);
        builder.append('(');

        for (Class<?> parameterType : method.getParameterTypes()) {
            methodDescriptor(builder, parameterType);
        }

        builder.append(')');
        methodDescriptor(builder, method.getReturnType());
        return builder.toString();
    }

    private static void methodDescriptor(StringBuilder builder, Class<?> parameterType) {
        if (parameterType.isArray()) {
            builder.append('[');
            methodDescriptor(builder, parameterType.getComponentType());
        } else if (parameterType.isPrimitive()) {
            if (parameterType == byte.class) {
                builder.append('B');
            } else if (parameterType == char.class) {
                builder.append('C');
            } else if (parameterType == double.class) {
                builder.append('D');
            } else if (parameterType == float.class) {
                builder.append('F');
            } else if (parameterType == int.class) {
                builder.append('I');
            } else if (parameterType == long.class) {
                builder.append('J');
            } else if (parameterType == short.class) {
                builder.append('S');
            } else if (parameterType == boolean.class) {
                builder.append('Z');
            } else if (parameterType == void.class) {
                builder.append('V');
            }
        } else {
            builder.append('L').append(parameterType.getName().replace('.', '/')).append(';');
        }
    }

    /**
     * Generate method descriptor with method name prefix.
     *
     * @param method method information
     * @return method descriptor with method name
     */
    public static String methodDescriptorWithName(Method method) {
        return method.getName() + methodDescriptor(method);
    }

    /**
     * Get declared field and make it accessible.
     *
     * @param type      type of the class
     * @param fieldName name of the field
     * @return declared field
     */
    public static Field declaredFieldAccessible(
            Class<?> type, String fieldName) {
        try {
            Field field = type.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Unable to get field: " + fieldName + " from class: " + type, e);
        }
    }

    /**
     * Get declared field and remove its "final" modifier.
     *
     * @param type      type of the class
     * @param fieldName name of the field
     * @return declared field with changed "final" modifier
     */
    public static Field declaredFieldModifiable(Class<?> type, String fieldName) {
        try {
            Field field = type.getDeclaredField(fieldName);
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField(MODIFIERS_FIELD_NAME);
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            return field;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Unable to get field: " + fieldName + " from class: " + type, e);
        }
    }
}
