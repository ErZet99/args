package com.ErZet99.Args.Marshaler;

import com.ErZet99.Args.ArgsException;
import java.util.Iterator;

public interface ArgumentMarshaler {
    Object get();
    void set(Iterator<String> currentArgument) throws ArgsException;
}
