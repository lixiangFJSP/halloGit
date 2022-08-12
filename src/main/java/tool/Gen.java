package tool;

import java.util.ArrayList;
import java.util.Collections;

public class Gen {
    /**
    记录每个基因的过程
     */
    int id;
    int makespan;
    int tardiness;
    double fitness;
    ArrayList<Integer> code = new ArrayList<>();

    public int getMakespan() {
        return makespan;
    }

    public int getTardiness() {
        return tardiness;
    }

    public double getFitness() {
        return fitness;
    }

    public ArrayList<Integer> getCode() {
        return code;
    }

    public void setMakespan(int makespan) {
        this.makespan = makespan;
    }

    public void setTardiness(int tardiness) {
        this.tardiness = tardiness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setCode(ArrayList<Integer> code) {
        this.code = code;
    }

    Gen(int i){
        this.id = i;
        this.makespan = 0;
        this.tardiness = 0;
        this.fitness = 0.0;
    }
    /**
     初始化进行，随机，如果按照订单的优先级，这里可以进行改进
     */
    public void randCode(int jobNum){
        for(int i =0; i < jobNum; i++){
            this.code.add(i);
        }
        Collections.shuffle(this.code);
    }

}
