import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class RMIData_ir8ymx9H {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        DataService service = (DataService) reg.lookup("RMIDataService");
        int[] num = (int[]) service.requestData("B23DCCN762", "ir8ymx9H");
        List<Integer> res = new ArrayList<>();
        if(num[0] > num[1])
            res.add(1);
        for(int i = 1; i < num.length-1; i++){
            if(num[i] > num[i-1] && num[i] > num[i+1])
                res.add(i+1);
        }
        if(num[num.length-1] > num[num.length-2])
            res.add(num.length);
        service.submitData("B23DCCN762", "ir8ymx9H", res);
    }
}
