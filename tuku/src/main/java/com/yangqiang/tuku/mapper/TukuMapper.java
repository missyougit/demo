package com.yangqiang.tuku.mapper;


import com.yangqiang.tuku.model.Tuku;
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



}
