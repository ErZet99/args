package com.ErZet99.Args.Marshaler;

import com.ErZet99.Args.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";

    public Object get() {
        return stringValue;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
        }
    }
}