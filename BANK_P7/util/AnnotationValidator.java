package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import model.annotation.MaxLength;
import model.annotation.Positive;

public class AnnotationValidator {

    public static String[] validate(Object obj) {
        List<String> errors = new ArrayList<>();

        if (obj == null) {
            errors.add("Object must not be null");
            return errors.toArray(new String[0]);
        }

        // Walk through the class and its parent classes so Account fields are checked
        // even when obj is a SavingsAccount, CurrentAccount, or FixedDepositAccount.
        for (Class<?> type = obj.getClass(); type != null; type = type.getSuperclass()) {
            Field[] fields = type.getDeclaredFields();

            for (Field field : fields) {
                try {
                if (field.isAnnotationPresent(Positive.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    Positive rule = field.getAnnotation(Positive.class);

                    if (value instanceof Number && ((Number) value).doubleValue() <= 0) {
                        errors.add(field.getName() + " " + rule.message());
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    MaxLength rule = field.getAnnotation(MaxLength.class);

                    if (value instanceof String && ((String) value).length() > rule.value()) {
                        errors.add(field.getName() + " must be at most " + rule.value() + " characters");
                    }
                }
                } catch (IllegalAccessException e) {
                    errors.add("Could not validate field " + field.getName());
                }
            }
        }

        return errors.toArray(new String[0]);
    }
}
