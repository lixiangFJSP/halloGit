package result;

public class PrintOut {
    /**
     * id：表示每道工序的信息
     * job：输出排程结果类
     * startTime：工件的开始时间
     * endTime：工件的结束时间
     * orderId：订单编号
     * machine：所需要的加工平台
     * typeName：服务平台名称
     */
    int id;
    int job;
    int startTime;
    int endTime;
    String orderId;
    int machine;
    String typeName;

    PrintOut(int i){
        this.id = i;
    }

    public int getJob() {
        return job;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getMachine() {
        return machine;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
