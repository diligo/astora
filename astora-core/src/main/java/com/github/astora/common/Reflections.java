package com.github.astora.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;

public final class Reflections {

    private Reflections() {
    }

    /**
     * Generate method descriptor.
     *
     * @param method method information
     * @return method descriptor
     */
    public static String generateMethodDescriptor(Method method) {
        StringBuilder builder = new StringBuilder(32);
        builder.append('(');

        for (Class<?> parameterType : method.getParameterTypes()) {
            generateMethodDescriptor(builder, parameterType);
        }

        builder.append(')');
        generateMethodDescriptor(builder, method.getReturnType());
        return builder.toString();
    }

    private static void generateMethodDescriptor(StringBuilder builder, Class<?> parameterType) {
        if (parameterType.isArray()) {
            builder.append('[');
            generateMethodDescriptor(builder, parameterType.getComponentType());
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
    public static String generateMethodDescriptorWithName(Method method) {
        return method.getName() + generateMethodDescriptor(method);
    }

    /**
     * Get declared field and remove its "final" modifier.
     *
     * @param type      type of the class
     * @param fieldName name of the field
     * @return declared field with changed "final" modifier
     */
    public static Optional<Field> tryGetDeclaredFieldAndMakeModifiable(Class<?> type, String fieldName) {
        try {
            Field field = type.getDeclaredField(fieldName);
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            return Optional.of(field);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            return Optional.empty();
        }
    }
}
