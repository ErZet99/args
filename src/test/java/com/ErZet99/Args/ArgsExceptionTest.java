package com.ErZet99.Args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgsExceptionTest{

    @Test
    public void testUnexpectedMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, 'x', null);
        assertEquals("Argument(s) -x unexpected.", argsException.errorMessage());
    }

    @Test
    public void testMissingStringMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.MISSING_STRING, 'x', null);
        assertEquals("Could not find string parameter for -x.", argsException.errorMessage());
    }

    @Test
    public void testMissingIntegerMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER, 'x', null);
        assertEquals("Could not find integer parameter for -x.", argsException.errorMessage());
    }

    @Test
    public void testInvalidIntegerMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, 'x', "123");
        assertEquals("Argument -x expects an integer but was '123'.", argsException.errorMessage());
    }

    @Test
    public void testInvalidDoubleMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, 'x', "123.45");
        assertEquals("Argument -x expects a double but was '123.45'.", argsException.errorMessage());
    }

    @Test
    public void testMissingDoubleMessage() throws Exception {
        ArgsException argsException = new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE, 'x', null);
        assertEquals("Could not find double parameter for -x.", argsException.errorMessage());
    }
}
