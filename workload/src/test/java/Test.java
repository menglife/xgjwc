import com.xzit.ssm.excel.StringUtils;

/**
 * create by hjx on 2018/11/15 0015
 */
public class Test {
    @org.junit.Test
    public void test(){
        String str = "校外集中实训1233332   （校企合作）";
        str = StringUtils.chinese(str);
        System.out.println("str=" + str);
        System.out.println("-----------------------");
        System.out.println("计算机公共基础课".contains(""));
    }

}
