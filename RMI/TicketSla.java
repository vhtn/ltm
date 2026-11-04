package RMI;

public class TicketSla implements java.io.Serializable {
    private static final long serialVersionUID = 20260517L;

    private String ticketId;
    private String priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private int openedHoursAgo;
    private boolean breached;
    private String action;

    public TicketSla() { }
    public TicketSla(String ticketId, String priority, int openedHoursAgo) { /* gán 3 thuộc tính */ }

    public int getOpenedHoursAgo() {
        return openedHoursAgo;
    }

    public String getPriority() {
        return priority;
    }

    public void setBreached(boolean breached) {
        this.breached = breached;
    }

    public void setAction(String action) {
        this.action = action;
    }
}