package com.yangqiang.tuku.mapper;

import com.yangqiang.tuku.model.User;
import com.yangqiang.tuku.model.UserActionCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id,openId,nickName,avatarUrl,gender,regdate from user where openId=#{openId}")
    User getUserByOpenId(String openId);

    @Insert("insert into user values (null,#{openId},#{nickName},#{avatarUrl},#{gender},#{regdate})")
    int addUser(User user);

    @Select("select\n" +
            "(select COUNT(id) from user_action where ${field}=#{fieldValue} and thumbsUp=1) thumbsUpCount ,\n" +
            "(select COUNT(id) from user_action where ${field}=#{fieldValue} and fenXiang=1) fenXiangCount ,\n" +
            "(select COUNT(id) from user_action where ${field}=#{fieldValue} and pingLun=1) pingLunCount")
    UserActionCount getUserActionCount(String field,String fieldValue);


}
