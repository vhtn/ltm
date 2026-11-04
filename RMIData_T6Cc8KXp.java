import RMI.DataService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class RMIData_T6Cc8KXp {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        DataService service = (DataService) reg.lookup("RMIDataService");
        String data = service.requestData("B23DCCN762", "T6Cc8KXp").toString();
        String[] n = data.split(",\\s*");
        double[] real = new double[n.length];
        double sum = 0;
        for(int i = 0; i < n.length; i++){
            real[i] = Double.parseDouble(n[i]);
            sum += real[i];
        }
        double avg = sum/real.length;
        double tmp = 0;
        for(int i = 0; i < real.length; i++){
            tmp += (real[i] - avg)*(real[i] - avg);
        }
        double stddev = Math.sqrt(tmp/real.length);
        Arrays.sort(real);
        int index = (int) Math.ceil(0.95 * real.length) - 1;
        double p95 = real[index];
        service.submitData("B23DCCN762", "T6Cc8KXp", "average=" + String.format("%.2f", avg) + ";stddev=" + String.format("%.2f", stddev) + ";p95=" + String.format("%.2f", p95));
    }
}
