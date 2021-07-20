package consumer.resume;


import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Experience implements Comparable<Experience> {
    private Date startDate;
    private Date endDate;

    private java.lang.String position;
    private java.lang.String companyName;

    public Experience(java.lang.String company, java.lang.String position, Date start_date, Date end_date) throws InvalidDatesException {
        try {
            if (end_date != null && start_date.compareTo(end_date) > 0) {
                throw new InvalidDatesException();
            }

            this.startDate = start_date;
            this.endDate = end_date;
            this.position = position;
            this.companyName = company;
        }
        catch(InvalidDatesException e){
            e.printStackTrace();
        }
    }
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public int compareTo(Experience o) {
        // Daca datele de final sunt nule compar dupa cele de start
        if (endDate == null && o.endDate == null) {
            return companyName.compareTo(o.companyName);
        }
        // Data de final a obiectului e nula e mai mic
        if (endDate == null) {
            return -1;
        }
        // Data de final a lui other e nula e mai mic
        if (o.endDate == null) {
            return 1;
        }
        // Comparatorul default
        return o.endDate.compareTo(endDate);
    }

    // Un format pentru data
    private static final SimpleDateFormat format =new SimpleDateFormat("dd.MM.yyyy");
    // Construiesc un obiect din JSON
    public static Experience parseJson(JSONObject json) throws ParseException, InvalidDatesException {
        return new Experience(
                json.getString("company"),
                json.getString("position"),
                format.parse(json.getString("start_date")),
                format.parse(json.getString("end_date"))
        );
    }

    @Override
    public String toString() {
        if(endDate == null){
            return "startDate=" + startDate.getDay() +"." + startDate.getMonth() + "." + startDate.getYear()+
                    "\n position='" + position + '\'' +
                    "\n companyName='" + companyName + '\'';
        }
        return "startDate=" + startDate.getDay() +"." + startDate.getMonth() + "." + startDate.getYear()+
                "\n endDate=" + endDate.getDay() +"." + endDate.getMonth() + "." + endDate.getYear()+
                "\n position='" + position + '\'' +
                "\n companyName='" + companyName + '\'';

    }
}