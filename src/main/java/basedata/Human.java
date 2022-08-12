package basedata;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Human {
    /**
    记录每天工人的占用情况
     */
    int index;
    int numAssembers;
    int numWelders;
    int numGrinders;
    int numPainters;
    int platformNum;
    ArrayList<Boolean> occupancyOfplatform = new ArrayList<>();

    public void setNumAssembers(int numAssembers) {
        this.numAssembers = numAssembers;
    }

    public void setNumWelders(int numWelders) {
        this.numWelders = numWelders;
    }

    public void setNumGrinders(int numGrinders) {
        this.numGrinders = numGrinders;
    }

    public void setNumPainters(int numPainters) {
        this.numPainters = numPainters;
    }

    public void setPlatformNum(int platformNum) {
        this.platformNum = platformNum;
    }

    public void setOccupancyOfplatform(ArrayList<Boolean> occupancyOfplatform) {
        this.occupancyOfplatform = occupancyOfplatform;
    }

    public int getNumAssembers() {
        return numAssembers;
    }

    public int getNumWelders() {
        return numWelders;
    }

    public int getNumGrinders() {
        return numGrinders;
    }

    public int getNumPainters() {
        return numPainters;
    }

    public int getPlatformNum() {
        return platformNum;
    }

    public ArrayList<Boolean> getOccupancyOfplatform() {
        return occupancyOfplatform;
    }

    public Human(int i, int numAssembers, int numWelders, int numGrinders, int numPainters, int platformNum) {
        //相当于python中的初始化
        this.index = i;
        this.numAssembers = numAssembers;
        this.numWelders = numWelders;
        this.numGrinders = numGrinders;
        this.numPainters = numPainters;
        this.platformNum = platformNum;
        for(int k=0; k < this.platformNum; k++){
            this.occupancyOfplatform.add(false);
        }
    }

    public void decreaseHumanNumber(int assembers, int welders, int grinders, int painters, int onPlatform){
        this.numAssembers -= assembers;
        this.numWelders -= welders;
        this.numGrinders -= grinders;
        this.numPainters -= painters;
        this.occupancyOfplatform.set(onPlatform, true);
    }

    public void addHumanday(int assembers, int welders, int grinders, int painters, int onPlatform){
        this.numAssembers += assembers;
        this.numWelders += welders;
        this.numGrinders += grinders;
        this.numPainters += painters;
        this.occupancyOfplatform.set(onPlatform, false);
    }

//    public static void main(String[] args) {
//        Human a = new Human(1, 6, 7, 8, 9, 5);
//        System.out.println(a.occupancyOfplatform.get(3));
//    }
}
