package com.yangqiang.tuku.mapper;

import com.yangqiang.tuku.model.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsMapper {


    //添加评论/回复
    @Insert("insert into comments values (null,#{openId},#{imagesId},#{targetCommentsId},#{content},#{type},#{createTime})")
    int addComments(Comments comments);

    //通过imagesId分页查询评论
    @Select("select id,openId,imagesId,targetCommentsId,content,type,createTime from comments where imagesId=#{imagesId}")
    List<Comments> getComments(int imagesId);


}
