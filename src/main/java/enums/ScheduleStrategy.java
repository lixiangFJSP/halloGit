package enums;

public enum ScheduleStrategy {
    PRIORITY("优先级最高"),
    OPERATIONTIME("最短工时"),
    DEADLINE("交付期"),
    ;

    private String name;

    ScheduleStrategy(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
