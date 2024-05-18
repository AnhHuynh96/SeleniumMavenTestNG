package com.anhtester.Bai10_Annotations;

import org.testng.annotations.Test;

public class DemoAnnotation {
    @Test(priority = 1)
    public void method1() {
        System.out.println("Run method 1");
    }

    @Test(priority = 0)  //độ ưu tiên đầu tiên -> chạy method2() đầu tiên
    public void method2() {
        System.out.println("Run method 2");
    }

    @Test(priority = 2)
    public void method3() {
        System.out.println("Run method 3");
    }
}
