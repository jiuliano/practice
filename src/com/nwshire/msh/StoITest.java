package com.nwshire.msh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/13/2017.
 */
public class StoITest {
    @Test
    public void stringToInteger() throws Exception {
        Assert.assertEquals(StoI.stringToInteger(null), 0);
        Assert.assertEquals(StoI.stringToInteger(""), 0);
        Assert.assertEquals(StoI.stringToInteger("-"), 0);
        Assert.assertEquals(StoI.stringToInteger("-100"), -100);
        Assert.assertEquals(StoI.stringToInteger("-000123"), -123);
        Assert.assertEquals(StoI.stringToInteger("+333"), 333);
        Assert.assertEquals(StoI.stringToInteger("  345 "), 345);
        Assert.assertEquals(StoI.stringToInteger("100,000"), 0);
    }
}