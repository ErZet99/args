package com.ErZet99.Args.Marshaler;

import com.ErZet99.Args.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int integerValue = 0;

    public Object get() {
        return integerValue;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;

        try {
            parameter = currentArgument.next();
            integerValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, parameter);
        }
    }
}