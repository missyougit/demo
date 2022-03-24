package com.yangqiang.tuku.mapper;

import com.yangqiang.tuku.model.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {


    //添加评论/回复
    @Insert("insert into comments values (null,#{openId},#{imagesId},#{targetCommentsId},#{content},#{type},#{createTime})")
    int addComments(Comments comments);


}
