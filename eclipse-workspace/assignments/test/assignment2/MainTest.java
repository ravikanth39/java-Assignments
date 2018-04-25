package assignment2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testCheckAllAlphaFalseCase(){
        Assert.assertEquals(false,Main.checkAllAlpha("FAIL TEST STRING"));
    }
    @Test
    public void testCheckAllAlphaTrueCase(){
        Assert.assertEquals(true,Main.checkAllAlpha("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
    }
    @Test
    public void testCheckAllAlphaEmptyString(){
        Assert.assertEquals(false,Main.checkAllAlpha(""));
    }

}
