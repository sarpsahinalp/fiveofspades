package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.common.BookingModel;
import server.common.POIModel;
import server.common.UserModel;
import server.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(UserModel user) {
        Optional<UserModel> userOptional =  userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email is already in use");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        if (! userRepository.existsById(userId)) {
            throw new IllegalStateException("user does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String email, String password) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("user does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<UserModel> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email is already in use");
            }
            user.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
    }

    @Transactional
    public void addBooking(BookingModel bookingModel) {
        UserModel user = userRepository.findById(bookingModel.getUserModel().getId())
                .orElseThrow(()->new IllegalStateException("user does not exist"));
        user.addBooking(bookingModel);
    }

    @Transactional
    public void removeBooking(BookingModel bookingModel) {
        UserModel user = userRepository.findById(bookingModel.getUserModel().getId())
                .orElseThrow(()->new IllegalStateException("user does not exist"));
        user.removeBooking(bookingModel);
    }

    @Transactional
    public void addPOI(Long userId, POIModel poiModel) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("user does not exist"));
        user.addPOI(poiModel);
    }

    @Transactional
    public void removePOI(Long userId, POIModel poiModel) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("user does not exist"));
        user.removePOI(poiModel);
    }
}
