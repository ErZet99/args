package com.ErZet99;

import com.ErZet99.Args.Args;

public class Main {
    public static void main(String[] args) {
        Args arg = new Args("l", args);
        boolean logging = arg.getBoolean('l');
    }
}