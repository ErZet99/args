package com.ErZet99.Args.Marshaler;

import com.ErZet99.Args.ArgsException;
import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public Object get() {
        return booleanValue;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }
}
