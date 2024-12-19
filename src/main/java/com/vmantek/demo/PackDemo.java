package com.vmantek.demo;

import org.jpos.iso.ISOBasePackager;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

public class PackDemo
{
    public static void main(String[] args) throws ISOException
    {
        Logger.getLogger("Q2").addListener(new SimpleLogListener(System.out));
        ISOBasePackager packager = new GenericPackager("gcspos.xml");
        final Logger logger = Logger.getLogger("Q2");
        packager.setLogger(logger, "main");

        ISOMsg m =new ISOMsg();
        m.setPackager(packager);
        m.setMTI("0100");
        m.set(2,"6394370000007942");
        m.set(3,"000000");
        m.set(4,"000000020000");
        m.set(11,"000012");
        m.set(14,"4912");
        m.set(18,"5812");
        m.set(25,"08");
        m.set(41,"12345678");
        m.set(42,"123456789012345");
        m.set(49,"214");
        byte[] t1= m.pack();
        //System.out.println(ISOUtil.hexdump(t1));

        ISOMsg m2 =new ISOMsg();
        m2.setPackager(packager);
        m.unpack(t1);
    }
}
