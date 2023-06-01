package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.common.BookingModel;
import server.common.POIModel;
import server.common.UserModel;
import server.services.UserService;

@RestController
@RequestMapping(path="api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // postman: GET, http://localhost:8080/api/user/1
    @GetMapping(path = "{userId}")
    public ResponseEntity<UserModel> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.of(userService.getUser(userId));
    }

    // postman: POST, http://localhost:8080/api/user, {"name":"Zara", "email":"zara@mail.de", "password":"1234", "birthDate":"2003-01-06", "userRole":"CUSTOMER"}
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserModel userModel) {
        userService.addNewUser(userModel);
        return ResponseEntity.ok().build();
    }

    // postman: PUT, http://localhost:8080/api/user/1?name=Krasi&email=krasi@mail.com
    @PutMapping(path = "{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String password) {
        userService.updateUser(userId, name, email, password);
        return ResponseEntity.ok().build();
    }

    // postman: DELETE, http://localhost:8080/api/user/1
    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    // http://localhost:8080/api/user/addBooking {"flightId":"1", "seat":"A1", "userId":"1", "journeyId":"1"}
    @PutMapping(path = "addBooking")
    public ResponseEntity<Void> addBooking(@RequestBody BookingModel bookingModel) {
        userService.addBooking(bookingModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "removeBooking")
    public ResponseEntity<Void> removeBooking(@RequestBody BookingModel bookingModel) {
        userService.removeBooking(bookingModel);
        return ResponseEntity.ok().build();
    }


    @PutMapping(path = "addPOI/{userId}")
    public ResponseEntity<Void> addPOI(@PathVariable("userId") Long userId, @RequestBody POIModel poiModel) {
        userService.addPOI(userId, poiModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "removePOI/{userId}")
    public ResponseEntity<Void> removePOI(@PathVariable("userId") Long userId, @RequestBody POIModel poiModel) {
        userService.removePOI(userId, poiModel);
        return ResponseEntity.ok().build();
    }
}
