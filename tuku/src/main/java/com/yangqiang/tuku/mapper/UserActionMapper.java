package com.yangqiang.tuku.mapper;

import com.yangqiang.tuku.model.UserAction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserActionMapper {

    //获取图片
    @Select({"<script> " +
            "select id,openId,imagesId,targetOpenId,thumbsUp,fenXiang,pingLun,content from user_action " +
            "where openId=#{openId} and imagesId=#{imagesId} " +
            "<if test='thumbsUp!=0'> " +
            "and thumbsUp=#{thumbsUp} " +
            "</if> " +
            "</script>"})
    UserAction getUserAction(int imagesId, String openId,int thumbsUp);


    @Update({"<script> " +
            "update user_action set " +
            "<if test='fenXiang!=0'> fenXiang=#{fenXiang} </if> " +
            "<if test='fenXiang==0'> thumbsUp=#{thumbsUp} </if> " +
            "where openId=#{openId} and imagesId=#{imagesId} " +
            "</script>"})
    int thumbsUp(UserAction userAction);

    //保存关系表
    @Insert("insert into user_action values (null,#{openId},#{imagesId},#{targetOpenId},#{thumbsUp},#{fenXiang},#{pingLun},#{content})")
    int addUserAction(UserAction userAction);

}
