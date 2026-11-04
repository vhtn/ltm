package RMIClient;

import RMI.CharacterService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class RMICharacter_pPkhRPi8 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        CharacterService service = (CharacterService) reg.lookup("RMICharacterService");
        String s = service.requestCharacter("B23DCCN762", "pPkhRPi8");
        String res = "";
        int[] tp = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] lm = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int num = Integer.parseInt(String.valueOf(s));
        int i = tp.length-1;
        while(num > 0){
                if(num >= tp[i]){
                    num -= tp[i];
                    res += lm[i];
                }
                else i--;
        }
        service.submitCharacter("B23DCCN762", "pPkhRPi8", res);
    }
}
