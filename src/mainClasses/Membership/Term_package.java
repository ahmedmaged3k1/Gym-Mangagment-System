package mainClasses.Membership;

import java.sql.SQLException;
import java.util.Date;

public class Term_package extends  Membership{


    public Term_package() throws SQLException {
        super();
        setType("TERM_PACKAGE");
        setPrice(4000);
        Date currentDate=new Date();
        setStart_date(S_date_toString(currentDate));
        setEnd_date(E_Date_toString(currentDate));
        setM_description("This package fees is paid year by year ");

    }

    @Override
    public void Display_Trainees_in_membership() {
        System.out.println("Members have open package membership"                   );   //  dont forget to write code to access memb ers in table open package in data base
    }

    @Override
    public void Display_membership_information() {

    }
}
