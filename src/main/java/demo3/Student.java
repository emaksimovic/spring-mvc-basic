package demo3;

import demo3.validation.CourseCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashMap;

/**
 * Created by maxa on 12/19/2017.
 */
public class Student {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value=1,message = "minimal number of passes is 1")
    @Max(value = 10, message="maximal number of passes iz 10")
    private Integer freePasses;
    private String country;
    @NotNull(message="is required")
    @CourseCode(value={"LUV", "TOP"}, message="Must be start of course code")
    private String courseCode;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        LinkedHashMap<String, String> tmp = new LinkedHashMap<String, String>();
        tmp.put("BR", "Brazil");
        tmp.put("ENG", "England");
        tmp.put("FR","France");
        tmp.put("DE","Germany");
        countryOptions = tmp;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
