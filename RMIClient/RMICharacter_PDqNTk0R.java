package RMIClient;

import RMI.CharacterService;

import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMICharacter_PDqNTk0R {
     public static void main(String[] args) throws RemoteException, NotBoundException, URISyntaxException {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        CharacterService service = (CharacterService) reg.lookup("RMICharacterService");
        String s = service.requestCharacter("B23DCCN762", "PDqNTk0R");
        s = new java.net.URI(null, null, s, null).toASCIIString();
        service.submitCharacter("B23DCCN762", "PDqNTk0R", s);
    }
}
