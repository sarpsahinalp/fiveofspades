package server.common;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class UserModel {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private UserRoleEnum userRole;
    @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookingModel> bookings;
    @ElementCollection
    private List<POIModel> poiModels;

    public UserModel(){
        this.bookings = new ArrayList<>();
        this.poiModels = new ArrayList<>();
    }

    public UserModel(String name, String email, String password, LocalDate birthDate, UserRoleEnum userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.userRole = userRole;
        this.bookings = new ArrayList<>();
        this.poiModels = new ArrayList<>();
    }

    public UserModel(Long id, String name, String password, String email, LocalDate birthDate, UserRoleEnum userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.userRole = userRole;
        this.bookings = new ArrayList<>();
        this.poiModels = new ArrayList<>();
    }

    public void addBooking(BookingModel booking) {
        bookings.add(booking);
    }

    public void removeBooking(BookingModel booking) {
        bookings.remove(booking);
    }

    public void addPOI(POIModel poiModel) {
        poiModels.add(poiModel);
    }

    public void removePOI(POIModel poiModel) {
        poiModels.remove(poiModel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public List<POIModel> getPoiModels() {
        return poiModels;
    }

    public void setPoiModels(List<POIModel> poiModels) {
        this.poiModels = poiModels;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birth date=" + birthDate +
                ", user role=" + userRole +
                '}';
    }

}
