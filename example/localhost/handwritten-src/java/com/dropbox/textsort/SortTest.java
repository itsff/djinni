package com.dropbox.textsort;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dropbox.djinni.NativeLibLoader;

public class SortTest {

    private static SecureRandom random = new SecureRandom();

    private static final Logger log =
        Logger.getLogger(SortTest.class.getName());

    public static String randomString() {
        return new BigInteger(130, random).toString(10).substring(0, 5);
    }

    public static void main(String[] args) throws Exception {
        NativeLibLoader.loadLibs();

        // Create some random strings to sort below
        ArrayList<String> strs = new ArrayList<String>();
        for (int i = 0; i < 5; ++i) {
            String s = randomString();
            strs.add(s);
            log.log(Level.INFO, "input string: " + s);
        }
        
        // Sort them!
        ItemList sorted = SortItems.runSort(new ItemList(strs));
        for (String s: sorted.getItems())
            {
                log.log(Level.INFO, "sorted: " + s);
            }
    }

}

