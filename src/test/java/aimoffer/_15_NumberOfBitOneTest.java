package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _15_NumberOfBitOneTest {
    @Test
    public void test_case_1() {
        final _15_NumberOfBitOne numberOfBitOne = new _15_NumberOfBitOne();
        Assert.assertEquals(Integer.bitCount(1), numberOfBitOne.numberOf1(1));
        Assert.assertEquals(Integer.bitCount(0), numberOfBitOne.numberOf1(0));
        Assert.assertEquals(Integer.bitCount(0x7FFFFFFF), numberOfBitOne.numberOf1(0x7FFFFFFF));
        Assert.assertEquals(Integer.bitCount(0xFFFFFFFF), numberOfBitOne.numberOf1(0xFFFFFFFF));
        Assert.assertEquals(Integer.bitCount(0x80000000), numberOfBitOne.numberOf1(0x80000000));
    }

    @Test
    public void test_case_2() {
        final _15_NumberOfBitOne numberOfBitOne = new _15_NumberOfBitOne();
        Assert.assertEquals(Integer.bitCount(1), numberOfBitOne.numberOf1V2(1));
        Assert.assertEquals(Integer.bitCount(0), numberOfBitOne.numberOf1V2(0));
        Assert.assertEquals(Integer.bitCount(0x7FFFFFFF), numberOfBitOne.numberOf1V2(0x7FFFFFFF));
        Assert.assertEquals(Integer.bitCount(0xFFFFFFFF), numberOfBitOne.numberOf1V2(0xFFFFFFFF));
        Assert.assertEquals(Integer.bitCount(0x80000000), numberOfBitOne.numberOf1V2(0x80000000));
    }

    @Test
    public void test_case_3() {
        final _15_NumberOfBitOne numberOfBitOne = new _15_NumberOfBitOne();
        Assert.assertEquals(Integer.bitCount(1), numberOfBitOne.numberOf1V3(1));
        Assert.assertEquals(Integer.bitCount(0), numberOfBitOne.numberOf1V3(0));
        Assert.assertEquals(Integer.bitCount(0x7FFFFFFF), numberOfBitOne.numberOf1V3(0x7FFFFFFF));
        Assert.assertEquals(Integer.bitCount(0xFFFFFFFF), numberOfBitOne.numberOf1V3(0xFFFFFFFF));
        Assert.assertEquals(Integer.bitCount(0x80000000), numberOfBitOne.numberOf1V3(0x80000000));
    }
}
