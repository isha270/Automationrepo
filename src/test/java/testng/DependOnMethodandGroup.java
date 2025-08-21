package testng;

import org.testng.annotations.Test;

public class DependOnMethodandGroup {
    @Test
    public void a(){
        System.out.println("a");
    }
    @Test(dependsOnMethods="a")
    public void a1(){
        System.out.println("a1");
    }
    @Test(groups={"a"})
    public void a2(){
        System.out.println("a");
    }
    @Test(dependsOnGroups="a")
    public void a3(){
        System.out.println("a1");
    }
}
