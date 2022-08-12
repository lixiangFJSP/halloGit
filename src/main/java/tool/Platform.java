package tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Platform {
    /**
     记录工件平台的开始结束时间，等
     */
    int id;
    List<Integer> startTime = new ArrayList<>();
    List<Integer> endTime= new ArrayList<>();
    List<Integer> assignFor= new ArrayList<>();

    public void setStartTime(Integer startTime) {
        this.startTime.add(startTime);
    }

    public void setEndTime(int endTime) {
        this.endTime.add(endTime);
    }

    public void setAssignFor(List<Integer> assignFor) {
        this.assignFor = assignFor;
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

    public Platform(int i){
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

    /**
     * //计算空闲时间段
     * @return 空闲时间的list[[1,3],[2,3]]
     */
    public ArrayList<List> idleTime(){
        ArrayList<List> idle = new ArrayList<>();
        try {
            if (this.startTime.get(0) != 0) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(0);
                a.add(this.startTime.get(0));
                idle.add(a);
            }
            for(int i = 0; i< this.endTime.size(); i++){
                if (this.startTime.get(i+1) - this.endTime.get(i) > 0){
                    ArrayList<Integer> b = new ArrayList<>();
                    b.add(this.endTime.get(i));
                    b.add(this.startTime.get(i+1));
                    idle.add(b);
                }
            }
        } catch (Exception ignored) {
        }
        return idle;
    }
    /**
     * 移除操作
     */
    public void remove(int startTime, int endTime){
        this.startTime.remove(startTime);
        this.endTime.remove(endTime);
        this.startTime.sort(Comparator.naturalOrder());
        this.endTime.sort(Comparator.naturalOrder());
    }

//    public static void main(String[] args) {
//        Platform j = new Platform(1);
//        j.update(10, 14, 1);
//        System.out.println(j.startTime);
//        System.out.println(j.assignFor);
//        j.update(15, 25, 1);
//        System.out.println(j.startTime);
//        System.out.println(j.endTime);
//        System.out.println(j.assignFor);
//        System.out.println(j.idleTime());
//    }

}
