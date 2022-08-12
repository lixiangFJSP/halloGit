package basedata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
    /**
     记录工件平台的开始结束时间，等
     */
    int id;
    int due;
    int processNum;
    int referenceCycle;
    String typeName;
    //订单编号
    String orderid;
    int startTimeJob;
    int endTimeJob;
    ArrayList<Object> processList = new ArrayList<>();

    // 查找时间，算法中需要的参数
    List<Integer> startTime = new ArrayList<>();
    List<Integer> endTime= new ArrayList<>();
    List<Integer> assignFor= new ArrayList<>();

    public Task(int i){
        this.id = i;
    }

    public void update(int startTime, int endTime, int obs){
        this.startTime.add(startTime);
        this.endTime.add(endTime);
        //按升序排列
        this.startTime.sort(Comparator.naturalOrder());
        this.endTime.sort(Comparator.naturalOrder());
        this.assignFor.add(this.endTime.indexOf(endTime), obs);
    }

    public void remove(int startTime, int endTime){
        this.startTime.remove(startTime);
        this.endTime.remove(endTime);
        this.startTime.sort(Comparator.naturalOrder());
        this.endTime.sort(Comparator.naturalOrder());
    }

    public int getId() {
        return id;
    }

    public int getDue() {
        return due;
    }

    public int getProcessNum() {
        return processNum;
    }

    public int getReferenceCycle() {
        return referenceCycle;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getOrderid() {
        return orderid;
    }

    public int getStartTimeJob() {
        return startTimeJob;
    }

    public int getEndTimeJob() {
        return endTimeJob;
    }

    public ArrayList<Object> getProcessList() {
        return processList;
    }

    public List<Integer> getStartTime() {
        return startTime;
    }

    public List<Integer> getEndTime() {
        return endTime;
    }

    public List<Integer> getAssignFor() {
        return assignFor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDue(int due) {
        this.due = due;
    }

    public void setProcessNum(int processNum) {
        this.processNum = processNum;
    }

    public void setReferenceCycle(int referenceCycle) {
        this.referenceCycle = referenceCycle;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setStartTimeJob(int startTimeJob) {
        this.startTimeJob = startTimeJob;
    }

    public void setEndTimeJob(int endTimeJob) {
        this.endTimeJob = endTimeJob;
    }

    public void setProcessList(Object process) {
        this.processList.add(process);
    }

    public void setStartTime(List<Integer> startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(List<Integer> endTime) {
        this.endTime = endTime;
    }

    public void setAssignFor(List<Integer> assignFor) {
        this.assignFor = assignFor;
    }
}
