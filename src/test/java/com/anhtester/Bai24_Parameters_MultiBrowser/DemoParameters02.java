package com.anhtester.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters02 {
    @Test
    @Parameters({"number1", "number2"})
    public void tinhTong2So(int a, int b) {
        System.out.println("Tổng 2 số: " + (a + b));
    }
}
