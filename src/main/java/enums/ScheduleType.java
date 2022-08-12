package enums;

public enum ScheduleType {
    SCHEDULE("正常排程"),
    INSERT("插单调度"),
    FAULT("设备故障调度"),
    Revoke("工序延时调度"),
    ;
    private String name;

    ScheduleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
