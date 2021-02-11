package mainClasses.Membership;

import java.sql.SQLException;
import java.util.Date;

public class Pay_as_you_go_package extends Membership {


    public Pay_as_you_go_package() throws SQLException {
        super();


        setType("Pay_as_you_go");
        setPrice(100);
        Date currentDate=new Date();
        setStart_date(S_date_toString(currentDate));
        setEnd_date(E_Date_toString(currentDate));
        setM_description("This package fees is every time the Trainee enter the gym  ");


    }


    @Override
    public void Display_Trainees_in_membership() {
        System.out.println("Members have open package membership"                   );   //  dont forget to write code to access memb ers in table open package in data base
    }

    @Override
    public void Display_membership_information() {

    }
}
