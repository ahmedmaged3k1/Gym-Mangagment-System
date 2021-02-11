package mainClasses.Membership;

import mainClasses.Trainee;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class   Membership  extends Trainee  {



    private int membership_id;
    private String type;
    private float price;
    private String start_date;
    private String end_date;
    private String m_description;

    protected SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");

    public Membership() throws SQLException {
    super();
     };
    // overrididen in other classes.      //abstract methods cant have a body but a definition
    public abstract void Display_Trainees_in_membership();
    public abstract void Display_membership_information();

                                                               // setters and getters
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    public String getM_description() {
        return m_description;
    }

    public void setM_description(String m_description) {
        this.m_description = m_description;
    }


    public String S_date_toString(Date d){

        SimpleDateFormat date_format = new SimpleDateFormat("dd MMM yy");
        String s_dateToString=date_format.format(d);  //s means start date

        return s_dateToString;
    }
    public String E_Date_toString(Date d){

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, +1);

        Date new_date=new Date();
        new_date =cal.getTime();

        String e_dateToString=date_format.format(new_date);
        return e_dateToString;
    }

}

