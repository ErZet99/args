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
    public void testWithNoSchemaButWithMultipleBooleanArguments() throws Exception{
        Args args = new Args("", new String[]{"-x", "-y"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertEquals("Argument(s) -x -y unexpected.", args.errorMessage());
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

    @Test
    public void testSimpleBooleanPresent() throws Exception {
        Args args = new Args("x", new String[]{"-x"});
        assertEquals(1, args.cardinality());
        assertTrue(args.isValid());
        assertEquals(true, args.getBoolean('x'));
    }

    @Test
    public void testSimpleStringPresent() throws Exception {
        Args args = new Args("x*", new String[]{"-x", "param"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals("param", args.getString('x'));
    }

    @Test
    public void testMissingStringArgument() throws Exception {
        Args args = new Args("x*", new String[]{"-x"});
        assertFalse(args.isValid());
        assertEquals("Could not find string parameter for -x.", args.errorMessage());
    }

    @Test
    public void testSpacesInFormat() throws Exception {
        Args args = new Args("x, y", new String[]{"-x", "-y"});
        assertEquals(2, args.cardinality());
        assertTrue(args.has('x'));
        assertTrue(args.has('y'));
    }


}
