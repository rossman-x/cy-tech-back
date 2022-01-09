package com.cytech.cytechback.user;

import com.cytech.cytechback.option.Option;
import com.cytech.cytechback.orientation.Orientation;
import com.cytech.cytechback.orientation.OrientationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrientationRepository orientationRepository;

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userAssembler.toDtoList(users);
    }

    @Override
    public UserDTO auth(String email, String password) throws Exception {
        try {
            User user = userRepository.findUserByEmailAddressAndPassword(email, password);
            if (user == null)
                throw new Exception("User not found");
            return this.userAssembler.toDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    @Override
    public UserDTO getUserById(int id) {
        User u = userRepository.findUserById(id);
        return this.userAssembler.toDto(u);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User u = this.userAssembler.fromDto(userDTO);
        User savedUser = this.userRepository.save(u);
        return this.userAssembler.toDto(savedUser);
    }

    @Override
    public void createUserOrientation(Long userId, Long optionId) {

        Orientation o = new Orientation();
        o.setRemarque("Set manually after a request.");
        Option op = new Option();
        op.setId(optionId);
        o.setOption(op);
        User user = new User();
        user.setId(userId);
        o.setUserOption(user);
        this.orientationRepository.deleteAllByUserOptionId(userId);
        this.orientationRepository.save(o);

    }

    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
