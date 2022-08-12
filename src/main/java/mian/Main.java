package mian;

import tool.Platform;

public class Main {
    public static void main(String[] args) {
        NormalSchedule ap = new NormalSchedule();
        //读取PlatFormList里面的Platform对象中的属性
        Platform a = (Platform) ap.getPlatFormList().get(1);
        System.out.println(a.getStartTime());
        System.out.println(a.getEndTime());

    }
}
