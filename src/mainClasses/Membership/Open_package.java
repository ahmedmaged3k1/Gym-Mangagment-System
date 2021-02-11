package mainClasses.Membership;

import java.sql.SQLException;
import java.util.Date;

// month by month
public class Open_package extends Membership {

    public Open_package() throws SQLException {
        super();

        setType("Open_Package");
        setPrice(1500);
        Date currentDate=new Date();
        setStart_date(S_date_toString(currentDate));
        setEnd_date(E_Date_toString(currentDate));
        setM_description("This package fees is paid month by month ");


    }

    @Override
    public void Display_Trainees_in_membership() {
        System.out.println("Members have open package membership"                   );   //  dont forget to write code to access memb ers in table open package in data base
    }

    @Override
    public void Display_membership_information() {

    }






}
