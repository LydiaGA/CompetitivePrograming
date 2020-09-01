package sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeesMap = new HashMap<>();
        for (Employee employee : employees) {
            employeesMap.put(employee.id, employee);
        }
        int result = getImportanceOfEmployee(employees, id, employeesMap);
        return result;
    }

    int getImportanceOfEmployee(List<Employee> employees, int id, Map<Integer, Employee> employeesMap){
        Employee current = employeesMap.get(id);

        int importance = current.importance;

        for (int subId : current.subordinates){
            importance += getImportanceOfEmployee(employees, subId, employeesMap);
        }

        return importance;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
