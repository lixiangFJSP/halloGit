package enums;

public enum ProcessState {
    UNPLAN("未排程"),
    PLANED("已排程"),
    UNSTART("未开工"),
    STARTED("已开工"),
    ;

    private String name;

    ProcessState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
