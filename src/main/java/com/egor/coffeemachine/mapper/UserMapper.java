package com.egor.coffeemachine.mapper;

import com.egor.coffeemachine.dto.UserDto;
import com.egor.coffeemachine.entity.User;
import com.egor.coffeemachine.mapper.util.EncodedMapping;
import com.egor.coffeemachine.mapper.util.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = PasswordEncoderMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(source = "password", target = "password", qualifiedBy = EncodedMapping.class)
    User map(UserDto userDto);
    UserDto map(User user);
}
