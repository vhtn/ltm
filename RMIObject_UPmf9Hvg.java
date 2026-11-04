import RMI.ObjectService;
import RMI.TicketSla;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIObject_UPmf9Hvg {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry res = LocateRegistry.getRegistry("36.50.135.242");
        ObjectService service = (ObjectService) res.lookup("RMIObjectService");
        TicketSla ticketSla = (TicketSla) service.requestObject("B23DCCN762", "UPmf9Hvg");
        int openedHoursAgo = ticketSla.getOpenedHoursAgo();
        String priority = ticketSla.getPriority();
        boolean breached = false;
        if(openedHoursAgo > 2 && priority.equals("CRITICAL")) {
            breached = true;
        } else if(openedHoursAgo > 8 && priority.equals("HIGH")){
            breached = true;
        } else if(openedHoursAgo > 24 && priority.equals("MEDIUM")){
            breached = true;
        } else if(openedHoursAgo > 72 && priority.equals("LOW")){
            breached = true;
        }
        String action = "";
        if(!breached){
            action = "MONITOR";
        } else {
            if(priority.equals("CRITICAL") || openedHoursAgo > 96){
                action = "ESCALATE_L2";
            }
            else
                action = "ESCALATE_L1";
        }
        ticketSla.setBreached(breached);
        ticketSla.setAction(action);
        service.submitObject("B23DCCN762", "UPmf9Hvg", ticketSla);
    }
}
