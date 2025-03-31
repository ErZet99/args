package com.ErZet99;

import com.ErZet99.Args.Args;

public class Main {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l", args);
            boolean logging = arg.getBoolean('l');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}