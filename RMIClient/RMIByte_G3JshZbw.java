package RMIClient;

import RMI.ByteService;

import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class RMIByte_G3JshZbw {
    public static void main(String[] args) throws Exception, NotBoundException, URISyntaxException {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        ByteService service = (ByteService) reg.lookup("RMIByteService");
        byte data[] = service.requestData("B23DCCN762", "G3JshZbw");
        Map<Byte, Integer> mp = new HashMap<>();
        int mi = Integer.MAX_VALUE;
        byte res = 0;
        for(byte b : data){
            mp.put(b, mp.getOrDefault(b, 0) + 1);
        }
        for(byte b : data){
            if(mp.get(b) > mi){
                mi = mp.get(b);
                res = b;
            }
        }
        service.submitData("B23DCCN762", "G3JshZbw", new byte[]{res, (byte) mi});
    }
}

