package com.shuyi.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.shuyi.model.Admin;

@Mapper
public interface AdminService {

	@Select("SELECT * FROM `shuyi`.`admin` where userName = #{userName} and password = #{password} and state = 1;")
	Admin findByNameAndPassword(Admin admin);

	@Select("SELECT * FROM `shuyi`.`admin` where userName = #{userName};")
	Admin findByName(Admin admin);

	@Insert("INSERT INTO `shuyi`.`admin` (`id`, `userName`, `password`,`email`, `realName`, `age`, `phoneNumber`, `headPicture`, `addDate`, `updateDate`, `state`) VALUES (null, #{userName}, #{password},#{email}, #{realName}, #{age}, #{phoneNumber}, #{headPicture}, now(), now(), 1);")
	int insert(Admin admin);

}
