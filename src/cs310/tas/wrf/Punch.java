package cs310.tas.wrf;

import java.sql.Timestamp;
import java.util.*;
import java.text.*;

/**
 *
 * @author Matt Denman and William Penwell, Adam Stith
 */
public class Punch {
    
    private String badgeID;
    private int terminalID;
    private int punchTypeID;
    private int id;
    private Timestamp originalTimeStamp;
    
public Punch(int id, int terminalID, String badgeID, Timestamp originalTimeStamp, int punchTypeID) {
        
        this.id = id;
        this.terminalID = terminalID;
        this.badgeID = badgeID;
        this.originalTimeStamp = originalTimeStamp;
        this.punchTypeID = punchTypeID;
}
//Punch(db.getBadge("021890C0"), 101, 1)

public Punch(Badge b, int terminalID, int punchTypeID){
        GregorianCalendar cal = new GregorianCalendar();
        //Punch(0, terminalID, b.getID(), new Timestamp(cal.getTimeInMillis()), punchTypeID);
        this.terminalID = terminalID;
        this.badgeID = b.getBadgeid();
        this.originalTimeStamp = new Timestamp(cal.getTimeInMillis());
        this.punchTypeID = punchTypeID;
    }
    
    public String printOriginalTimestamp() {
        
        String punchResults = "";
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(originalTimeStamp.getTime());
        //Date date = cal.getTime();
        
        switch(this.punchTypeID){
            case 0:
                punchResults = "CLOCKED OUT:";
                break;
            case 1:
                punchResults = "CLOCKED IN:";
                break;
            case 2:
                punchResults = "TIMED OUT:";
                break;
            default:
                System.out.println("ERROR");
        }
        
        //String originalTimestamptoString = "#" + getBadgeID() + punchResults + " " + date;
        
        /*
        A pattern is created for the format according to the documentation on SimpleDateFormat. 
        Then an output string is constructed using the cal.getTime(). Then the output string is built,
        .toUppercase() is used to ensure the day of the week is capitalized.
        */
        String pattern = "EEE MM/dd/yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String formattedDate = sdf.format(cal.getTime()).toUpperCase();
        
        String originalTimestamptoString = "#" + getBadgeid() + " " + punchResults + " " + formattedDate;
            
        return originalTimestamptoString;
         
    }
    
    public String printAdjustedTimeStamp() {
        return "";
    }

    // Getter Methods
    
    public String getBadgeid() {
        return badgeID;
    }

    public int getTerminalid() {
        return terminalID;
    }

    public int getPunchtypeid() {
        return punchTypeID;
    }

    public int getId() {
        return id;
    }

    public long getOriginaltimestamp() {
        return originalTimeStamp.getTime() / 1000;
    }
    
    public Timestamp getOriginaltimestamp2() {
        return originalTimeStamp;
    }
    
    // Setter Methods

    public void setBadgeID(String badgeID) {
        this.badgeID = badgeID;
    }

    public void setTerminalID(int terminalID) {
        this.terminalID = terminalID;
    }

    public void setPunchTypeID(int punchTypeID) {
        this.punchTypeID = punchTypeID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOriginalTimeStamp(Timestamp originalTimeStamp) {
        this.originalTimeStamp = originalTimeStamp;
    }
    
      
}

