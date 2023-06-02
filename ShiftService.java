import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShiftService {

    private static class ShiftDuration {
        int startTime;
        int endTime;
        public ShiftDuration(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    Map<Integer, List<ShiftDuration>> employeesList;
    public List<ShiftDuration> getShiftTimingsOfEmployee(int employeeId) {
        List<ShiftDuration> shifts = employeesList.get(employeeId);
        List<ShiftDuration> resultShift = new ArrayList<>();
        shifts.sort(Comparator.comparingInt(a -> a.startTime));
        resultShift.add(new ShiftDuration(shifts.get(0).startTime,shifts.get(0).endTime ));
        for(int i=1;i<shifts.size();i++) {
            int startTime = shifts.get(i).startTime;
            if(resultShift.get(resultShift.size()-1).endTime == startTime) {
                ShiftDuration currentShift = resultShift.get(resultShift.size()-1);
                currentShift.endTime =  shifts.get(i).endTime;
           } else {
                resultShift.add(new ShiftDuration(shifts.get(i).startTime, shifts.get(i).endTime));
            }
        }
        return resultShift;
    }

    public static void main(String args[]) {
        EmployeeInformation info1 = new EmployeeInformation();
        info1.employeeid = 123;
        info1.employeeName = "vig";

        List<ShiftDuration> departmentList = new ArrayList<>();
        departmentList.add(new ShiftDuration (50,80));
        departmentList.add(new ShiftDuration (19,25));
        departmentList.add(new ShiftDuration (30,50));
        departmentList.add(new ShiftDuration (8,10));
        departmentList.add(new ShiftDuration (10,12));
        departmentList.add(new ShiftDuration (14,19));


        Map<Integer, List<ShiftDuration>> employeesList = new HashMap<>();
        employeesList.put(info1.employeeid, departmentList);
        ShiftService service = new ShiftService();
        service.employeesList = employeesList;
        service.getShiftTimingsOfEmployee(123).forEach(a -> System.out.println(a.startTime+","+a.endTime));
    }


}
