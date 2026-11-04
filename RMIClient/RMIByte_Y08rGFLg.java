package RMIClient;

import RMI.ByteService;

import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class RMIByte_Y08rGFLg {
    public static void main(String[] args) throws Exception, NotBoundException, URISyntaxException {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        ByteService service = (ByteService) reg.lookup("RMIByteService");
        byte data[] = service.requestData("B23DCCN762", "Y08rGFLg");
        Map<Byte, Integer> mp = new HashMap<>();
        int ma = Integer.MIN_VALUE;
        byte res = 0;
        for(byte b : data){
            mp.put(b, mp.getOrDefault(b, 0) + 1);
        }
        for(byte b : data){
            if(mp.get(b) > ma){
                ma = mp.get(b);
                res = b;
            }
        }
        service.submitData("B23DCCN762", "Y08rGFLg", new byte[]{res, (byte) ma});
    }
}

