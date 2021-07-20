package consumer.resume;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.*;

public final class Education implements Comparable<Education> {
    private Date startDate;
    private Date endDate;
    private java.lang.String institutionName;
    private java.lang.String educationLevel;
    private Double GPA;

    public Education(java.lang.String level, java.lang.String name, Date start_date, Date end_data, Double grade)
            throws InvalidDatesException {
        try {
            if (end_data != null && start_date.compareTo(end_data) > 0) {
                throw new InvalidDatesException();
            }

            this.startDate = start_date;
            this.endDate = end_data;
            this.institutionName = name;
            this.educationLevel = level;
            this.GPA = grade;
        }
        catch(InvalidDatesException e){
            e.printStackTrace();
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getGPA() {
        return GPA;
    }

    @Override
    public int compareTo(Education o) {
        // Daca datele de final sunt nule compar dupa cele de start
        if (endDate == null && o.endDate == null) {
            return startDate.compareTo(o.startDate);
        }
        // Data de final a obiectului e nula e mai mic
        if (endDate == null) {
            return -1;
        }
        // Data de final a lui other e nula e mai mic
        if (o.endDate == null) {
            return 1;
        }
        // Daca datele de final sunt egale, compar dupa medie
        if (endDate.equals(o.endDate)) {
            return GPA > o.GPA ? -1 : 1;
        }
        // Comparatorul default
        return o.endDate.compareTo(endDate);
    }

    // Un format pentru data
    private static final SimpleDateFormat format =new SimpleDateFormat("dd.MM.yyyy");
    // Construiesc un obiect din JSON
    public static Education parseJson(JSONObject json) throws ParseException, InvalidDatesException {
        return new Education(
                json.getString("level"),
                json.getString("name"),
                format.parse(json.getString("start_date")),
                format.parse(json.getString("end_data")),
                Double.parseDouble(json.getString("grade"))
        );
    }

    @Override
    public String toString() {
        if(endDate == null){
            return "startDate=" + startDate.getDay() +"." + startDate.getMonth() + "." + startDate.getYear()+
                    "\n endDate=" + null+"." + null + "." + null+
                    "\n institutionName='" + institutionName + '\'' +
                    "\n educationLevel='" + educationLevel + '\'' +
                    "\n GPA=" + GPA ;
        }
        return "startDate=" + startDate.getDay() +"." + startDate.getMonth() + "." + startDate.getYear()+
                "\n endDate=" + endDate.getDay() +"." + endDate.getMonth() + "." + endDate.getYear()+
                "\n institutionName='" + institutionName + '\'' +
                "\n educationLevel='" + educationLevel + '\'' +
                "\n GPA=" + GPA ;

    }
}
