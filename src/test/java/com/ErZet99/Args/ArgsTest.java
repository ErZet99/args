package com.ErZet99.Args;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class ArgsTest {

    @Test
    public void testCreateWithNoSchemaAndNoArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    @Test
    public void testWithNoSchemaButWithOneArgument() throws Exception {
        Args args = new Args("", new String[]{"-x"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertEquals("Argument(s) -x unexpected.", args.errorMessage());
    }

    @Test
    public void testWithNoSchemaButWithMultipleArguments() throws Exception{
        Args args = new Args("", new String[]{"-x", "-y"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertEquals("Argument(s) -xy unexpected.", args.errorMessage());
    }

    @Test
    public void testNonLetterSchema() throws Exception {
        try {
            Args args = new Args("*", new String[]{});
            fail("Args constructor should have thrown exception");
        } catch (ParseException e) {
            assertEquals("Bad character: * in Args format: *", e.getMessage());
        }
    }

    @Test
    public void testInvalidArgumentFormat() throws Exception {
        try {
            Args args = new Args("f~", new String[]{});
            fail("Args constructor should have thrown exception");
        } catch (ParseException e) {
            assertEquals("Argument: f has invalid format: ~", e.getMessage());
        }
    }
}
