package com.onlineJobPortal.services.user;


import com.onlineJobPortal.dto.ChangePasswordDto;
import com.onlineJobPortal.dto.SignupRequest;
import com.onlineJobPortal.dto.UserDto;
import com.onlineJobPortal.responce.GeneralResponse;

public interface UserService {

     UserDto createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

     UserDto getUser(Long userId);

     GeneralResponse updateUser(UserDto userDto);

     GeneralResponse updatePasswordById(ChangePasswordDto changePasswordDto);
}
