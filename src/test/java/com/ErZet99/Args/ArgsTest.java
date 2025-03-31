package com.ErZet99.Args;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArgsTest {

    @Test
    public void testCreateWithNoSchemaAndArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    @Test
    public void testCreateWithNoSchemaButWithOneArgument() {
        Args args = new Args("", new String[]{"-x"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertEquals("Argument(s) -x unexpected.", args.errorMessage());
    }

    @Test
    public void testCreateWithNoSchemaButWithMultipleArguments() {
        Args args = new Args("", new String[]{"-x", "-y"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertEquals("Argument(s) -xy unexpected.", args.errorMessage());
    }

    @Test
    public void testCreateWithValidBooleanSchemaAndArguments() {
        Args args = new Args("x", new String[]{"-x"});
        assertTrue(args.isValid());
        assertEquals(1, args.cardinality());
        assertTrue(args.getBoolean('x'));
        assertEquals("", args.errorMessage());
    }
}
