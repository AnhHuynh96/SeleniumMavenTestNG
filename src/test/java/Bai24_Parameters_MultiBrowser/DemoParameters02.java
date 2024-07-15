package Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters02 {
    @Test
    @Parameters({"number1","number2"})
    public void tinhTong2So(int a, int b){
        System.out.println("Tong 2 so:" + (a+b));


    }





}
