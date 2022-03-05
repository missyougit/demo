package com.yangqiang.tuku.mapper;


import com.yangqiang.tuku.model.Tuku;
import com.yangqiang.tuku.model.UserAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TukuMapper {

    //获取图片
    @Select("select id,title,images,createTime from yq_images ORDER BY createTime DESC limit #{offset} , #{pageSize}")
    List<Tuku> getImages(int offset, int pageSize);

    //获取图片总数
    @Select("select COUNT(id) from yq_images")
    int getTukuTotal();

//    private int id;
//    private String openId;        //操作人
//    private int imagesId;         //
//    private String targetOpenId;  //操作人回复targetOpenId的评论
//    private int thumbsUp;         //动作类型  0.未喜欢  1.喜欢
//    private int fenXiang;         //动作类型  0.未分享  1.分享
//    private int pingLun;          //动作类型  0.未评论  1.评论
//    private String content;       //评论内容


    //获取图片
    @Select("select id,openId,imagesId,targetOpenId,thumbsUp,fenXiang,pingLun,content from user_action" +
            " where openId=#{openId} and imagesId=#{imagesId} and thumbsUp=1")
    UserAction getUserAction(int imagesId, String openId);

}
