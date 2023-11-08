package com.anhtester.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters01 {

    @Test
    @Parameters({"number1", "number2"})
    public void tinhTong2So(int a, int b) {
        System.out.println("Tổng 2 số: " + (a + b));
    }

    @Test
    @Parameters({"number1", "number2", "number3"})
    public void tinhTong3So(int a, int b, int c) {
        System.out.println("Tổng 3 số: " + (a + b + c));
    }

    @Test
    @Parameters({"email", "password"})
    public void login(@Optional("projectmanager@email.com") String email, @Optional("56789") String password) {
        System.out.println(email + " - " + password);
    }

}
