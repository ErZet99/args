package com.ErZet99.Args.Marshaler;

import com.ErZet99.Args.ArgsException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
    private double doubleValue = 0.0;

    public Object get() {
        return doubleValue;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;

        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE);
        } catch (NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, parameter);
        }
    }
}
