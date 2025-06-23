//package org.ashara.chennai.transport.tripsheet.service;
//
//import org.apache.logging.log4j.util.Strings;
//import org.ashara.chennai.transport.tripsheet.beans.LoginCredentials;
//import org.ashara.chennai.transport.tripsheet.beans.NewUserBean;
//import org.ashara.chennai.transport.tripsheet.beans.UserBean;
//import org.ashara.chennai.transport.tripsheet.entities.User;
//import org.ashara.chennai.transport.tripsheet.exceptions.ActCommonException;
//import org.ashara.chennai.transport.tripsheet.repository.UserRepository;
////import org.ashara.chennai.transport.tripsheet.utils.PasswordUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PasswordUtils passwordUtils;
//
//    public UserBean loginUser(LoginCredentials loginCredentials) {
//
//        if (loginCredentials == null || loginCredentials.getItsNumber() == null || loginCredentials.getPassword() == null)
//            throw new ActCommonException("Invalid Login Credentials");
//        UserBean userBean = new UserBean();
//
//        List<User> userList = userRepository.findByItsNumberAndIsActive(loginCredentials.getItsNumber(),true);
//
//        if(userList != null && !userList.isEmpty()) {
//            User user = userList.getFirst();
//            if (PasswordUtils.checkPassword(loginCredentials.getPassword(), user.getPassword())) {
//                userBean.setId(user.getId());
//                userBean.setName(user.getName());
//                userBean.setItsNumber(user.getItsNumber());
//                userBean.setLoginStatus("LOGIN_SUCCESS");
//            }
//            else
//                userBean.setLoginStatus("INCORRECT_PASSWORD");
//        }
//        else
//            userBean.setLoginStatus("INVALID_USERNAME");
//
//        return userBean;
//    }
//
//    public String addUser(NewUserBean newUserBean) {
//
//        if (newUserBean == null || newUserBean.getItsNumber() == null
//                || newUserBean.getPassword() == null || newUserBean.getFirstName() == null)
//            throw new ActCommonException("Invalid Input");
//        List<User> userList = userRepository.findByItsNumberAndIsActive(newUserBean.getItsNumber(), true);
//
//        if(userList != null && !userList.isEmpty())
//            return "FAILED_DUPLICATE_USER";
//
//        User user = new User();
//
//        String firstName = newUserBean.getFirstName().trim();
//        String lastName = newUserBean.getLastName() == null ? "" : newUserBean.getLastName().trim();
//        String fullName = Strings.isBlank(lastName) ? firstName : firstName.concat(" ").concat(lastName);
//
//        user.setName(fullName);
//        user.setItsNumber(newUserBean.getItsNumber());
//        user.setPassword(PasswordUtils.encryptPassword(newUserBean.getPassword()));
//        user.setActive(true);
//        user.setCreatedTime(LocalDateTime.now());
//        userRepository.save(user);
//        return "USER SAVED SUCCESSFULLY";
//    }
//}