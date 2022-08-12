package basedata;


import com.sun.istack.internal.NotNull;
import enums.ScheduleStrategy;
import enums.ScheduleType;
import methon.Process1;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import tool.Platform;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Data {
    int maxDay = 1000;
    int platfromNum = 29;
    int orderNum;
    ArrayList<Object> taskList = new ArrayList<>();
    ArrayList<Object> platformdayList = new ArrayList<>();
    ArrayList<Object> humanDayList = new ArrayList<>();
    ArrayList<Object> platFormList = new ArrayList<>();
    //读取文件内容
    private static String content;
    //输入文件路径
    private static String path = "E:\\JavaItem\\APS2\\src\\main\\java\\basedata\\testData.json";
    static {
        //加载文件
        File file = new File(path);
        try {
            content = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1");
        }
        }
    {
        //读取jason文件
        JSONObject jsonObject;
        jsonObject = new JSONObject(content);
        orderNum = jsonObject.getInt("任务数量");
        for(int i =0; i < orderNum; i++){
            Task task = new Task(i);
            task.setOrderid(jsonObject.getJSONObject("task"+i).getString("订单编号"));
            task.setDue(jsonObject.getJSONObject("task"+i).getInt("交付期"));
            task.setProcessNum(jsonObject.getJSONObject("task"+i).getInt("工序总数"));
            task.setTypeName(jsonObject.getJSONObject("task"+i).getString("类别名称"));
            for(int j = 0; j<task.getProcessNum(); j++){
                Process1 p = new Process1(j);
                p.setNameProcess(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getString("name"));
                p.setPlatforms(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getJSONArray("加工平台"));
                p.setProcessTime(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("加工时间"));
                p.setNumAssember(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("装配工人"));
                p.setNumWelders(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("焊接工人"));
                p.setNumGrinders(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("打磨工人"));
                p.setNumPainters(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("油漆工人"));
                p.setServiceType(jsonObject.getJSONObject("task"+i).getJSONObject("process").getJSONObject("process"+j).getInt("加工平台类型"));
                task.setProcessList(p);
            }
            taskList.add(task);
        }
        System.out.println(taskList.get(0));
        //创建所需要的对象
        for (int k=0; k<this.platfromNum; k++){
            Platform platform = new Platform(k);
            platform.setEndTime(jsonObject.getJSONArray("ServiceAvaStime").getInt(k));
            platform.setStartTime(0);
            this.platFormList.add(platform);
        }
        //添加每天的人员信息
        for (int t = 0 ; t<this.maxDay; t++){
            int a = jsonObject.getJSONObject("初始每天人员数量").getInt("装配工人");
            int w = jsonObject.getJSONObject("初始每天人员数量").getInt("焊接工人");
            int g = jsonObject.getJSONObject("初始每天人员数量").getInt("打磨工人");
            int p = jsonObject.getJSONObject("初始每天人员数量").getInt("油漆工人");
            Human h = new Human(t, a, w, g, p, this.platfromNum);
            humanDayList.add(h);
        }

    }

    //    private Map<LocalDate,List<WkCalendar>> wkCalendars = new HashMap<Object, Object>();
    /**
     * 排程方式
     */
    //这里需要用0，1，2，3这类数字进行表示结果即可，分类完成
    private ScheduleType type;
    /**
     * 排程策略
     */
    private ScheduleStrategy strategy;


    public int getMaxDay() {
        return maxDay;
    }

    public int getPlatfromNum() {
        return platfromNum;
    }

    public ArrayList<Object> getTaskList() {
        return taskList;
    }

    public ArrayList<Object> getPlatformdayList() {
        return platformdayList;
    }

    public ArrayList<Object> getHumanDayList() {
        return humanDayList;
    }

    public ArrayList<Object> getPlatFormList() {
        return platFormList;
    }

    public void setMaxDay(int maxDay) {
        this.maxDay = maxDay;
    }

    public void setPlatfromNum(int platfromNum) {
        this.platfromNum = platfromNum;
    }

    public void setTaskList(ArrayList<Object> taskList) {
        this.taskList = taskList;
    }

    public void setPlatformdayList(ArrayList<Object> platformdayList) {
        this.platformdayList = platformdayList;
    }

    public void setHumanDayList(ArrayList<Object> humanDayList) {
        this.humanDayList = humanDayList;
    }

    public void setPlatFormList(ArrayList<Object> platFormList) {
        this.platFormList = platFormList;
    }

    public ScheduleType getType() {
        return type;
    }

    public ScheduleStrategy getStrategy() {
        return strategy;
    }

    public void setType(ScheduleType type) {
        this.type = type;
    }

    public void setStrategy(ScheduleStrategy strategy) {
        this.strategy = strategy;
    }

}
