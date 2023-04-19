package test;

import org.junit.Assert;
import org.junit.Test;

public class TesterApp {
	private Tester tst = new Tester();
	
	@Test
    public void testTwoPairPoints() {
		
        int[] test = { 1, 2, 3, 5, 6 };
        tst.setValues(test);
        int result = tst.twoPairPoints();
        Assert.assertEquals(0, result);
        
        int[] tst1 = { 4, 2, 3, 4, 2 };
        tst.setValues(tst1);
        int result1 = tst.twoPairPoints();
        Assert.assertEquals(12, result1);
        
        int[] tst2 = { 5, 5, 6, 6, 5 };
        tst.setValues(tst2);
        int result2 = tst.twoPairPoints();
        Assert.assertEquals(22, result2);
        
        int[] tst3 = { 5, 5, 6, 5, 5 };
        tst.setValues(tst3);
        int result3 = tst.twoPairPoints();
        Assert.assertEquals(0, result3);
    }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Test tst = new Test();
//		
//		int[] values = { 1, 2, 3, 5, 6 };
//        tst.setValues(values);
//        int result = tst.twoPairPoints();
//        System.out.println(result);
//        
//        
//        int[] values1 = { 4, 2, 3, 4, 2 };
//        tst.setValues(values1);
//        int result1 = tst.twoPairPoints();
//        System.out.println(result1);
//        
//        int[] values2 = { 5, 5, 6, 6, 5 };
//        tst.setValues(values2);
//        int result2 = tst.twoPairPoints();
//        System.out.println(result2);
//        
//        int[] values3 = { 5, 5, 6, 5, 5 };
//        tst.setValues(values3);
//        int result3 = tst.twoPairPoints();
//        System.out.println(result3);
//        
//        
//        
//	}

}
