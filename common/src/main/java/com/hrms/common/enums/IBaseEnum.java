package com.hrms.common.enums;


import com.hrms.common.exception.InvalidOperationException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.function.Supplier;

public interface IBaseEnum<E extends Enum<E> & IBaseEnum<E>> {


    String getText();
    Class<? extends E> enumClass();


    default String convertToText(E enumName) {
        String description = enumName.getText();
        return new BaseEnum<String>(description)
                .orElseThrow(InvalidOperationException::new);
    }

    default <T extends E> T convertToName(String enumText) {
        E e1 = Arrays.stream(enumClass().getEnumConstants()).toList().stream()
                .filter(e -> e.name().equals(enumText))
                .findFirst()
                .orElseThrow(InvalidOperationException::new);
        return (T) e1;
    }

    @AllArgsConstructor
    class BaseEnum<T> {
        T value;
        private <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
            if (value != null) {
                return value;
            } else {
                throw exceptionSupplier.get();
            }
        }
    }
}
