package com.yangqiang.tukuserver.mapper;


import com.yangqiang.tukuserver.model.Tuku;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TukuMapper {

    //添加图片进数据库
    @Insert("insert into yq_images values (null,#{title},#{images},#{createTime})")
    int addImages(Tuku tuku);

}
