package com.sumanth.backendconcepts.serviceimpl;

import com.sumanth.backendconcepts.entity.Users;
import com.sumanth.backendconcepts.payload.UserDto;
import com.sumanth.backendconcepts.repository.UserRepo;
import com.sumanth.backendconcepts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userrepo;
   @Autowired
  private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createuser(UserDto userdto) {

       userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
           Users user= userDtoToEntity(userdto);
       Users saveduser=   userrepo.save(user);
      UserDto dto= userentitytodto(saveduser);
      return dto;


    }
///////////////////////////////////////////////////////////////////////

    private Users userDtoToEntity(UserDto userdto)
    {
        Users users= new Users();
        users.setName(userdto.getName());
        users.setEmail(userdto.getEmail());
        users.setPassword(userdto.getPassword());
        return users;


    }

    private UserDto userentitytodto (Users user)
    {
          UserDto userdto= new UserDto();
          userdto.setId(user.getId());
          userdto.setName(user.getName());
          userdto.setEmail(user.getEmail());
          userdto.setPassword(user.getPassword());


          return userdto;

    }

}
