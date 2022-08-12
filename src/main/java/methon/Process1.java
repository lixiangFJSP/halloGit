package methon;

import org.json.JSONArray;
import tool.Platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static sun.swing.MenuItemLayoutHelper.max;

public class Process1 {
    /**
    对每道工序进行调度
     */
    int id;
    int numAssember;
    int numGrinders;
    int numPainters;
    ArrayList<Integer> platforms = new ArrayList<>();
    int startTimePt;
    int endTimePt;
    int onPlatform;
    String nameProcess;
    int processTime;
    int serviceType;
    int numWelders;

    public Process1(int i){
        this.id = i;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public void setPlatforms(JSONArray platforms) {

        for(int i = 0; i < platforms.length(); i++){
            int a = platforms.getInt(i);
            this.platforms.add(a);
        }
    }

    public void setStartTimePt(int startTimePt) {
        this.startTimePt = startTimePt;
    }

    public int getProcessTime() {
        return processTime;
    }

    public int getServiceType() {
        return serviceType;
    }

    public ArrayList<Integer> getPlatforms() {
        return platforms;
    }

    public int getStartTimePt() {
        return startTimePt;
    }

    public void setNumWelders(int numWelders) {
        this.numWelders = numWelders;
    }

    public int getNumWelders() {
        return numWelders;
    }

    public void setNumGrinders(int numGrinders) {
        this.numGrinders = numGrinders;
    }

    public int getNumGrinders() {
        return numGrinders;
    }

    public void setNumPainters(int numPainters) {
        this.numPainters = numPainters;
    }

    public int getNumPainters() {
        return numPainters;
    }

    public void setEndTimePt(int endTimePt) {
        this.endTimePt = endTimePt;
    }

    public int getEndTimePt() {
        return endTimePt;
    }

    public void setNameProcess(String nameProcess) {
        this.nameProcess = nameProcess;
    }

    public String getNameProcess() {
        return nameProcess;
    }

    public int getNumAssember() {
        return numAssember;
    }

    public void setNumAssember(int numAssember) {
        this.numAssember = numAssember;
    }

    public void setOnPlatform(int onPlatform) {
        this.onPlatform = onPlatform;
    }

    public int getOnPlatform() {
        return onPlatform;
    }


    public ArrayList<Integer> schedulProcess(ArrayList<Object> humanDayList, Objects jobObject, Objects machineObject, ArrayList<Object> processList, int st){
        int canchooseplatform = this.platforms.size();
        int sTemp = st;
        if (canchooseplatform ==1){
            this.onPlatform = this.platforms.get(0)-1;
        }

        return null;
    }

    private void getEndTime(Platform machineObject, Platform jobObject){
        ArrayList<List> idleTime = machineObject.idleTime();
        int lastOt;
        int lastMt;
        int startTime;
        try{
            lastOt = Collections.max(jobObject.getEndTime());
        } catch (Exception e) {
            lastOt = 0 ;
        }
        try{
            lastMt = Collections.max(machineObject.getEndTime());
        } catch (Exception e) {
            lastMt = 0 ;
        }
        startTime = max(lastOt, lastMt);

    }

//    public static void main(String[] args) {
//        Platform a = new Platform(1);
//        Process1 p = new Process1(1);
//        p.getEndTime(a, a);
//    }

}
