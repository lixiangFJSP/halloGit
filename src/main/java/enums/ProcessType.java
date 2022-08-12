package enums;

public enum ProcessType {
    NORMAL("正常排程"),
    INSERT("插单任务作业"),
    FAULT("设备故障任务作业"),
    DELAY("延时任务作业"),
    REDO("返工返修作业"),
    ;

    private String name;

    ProcessType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
