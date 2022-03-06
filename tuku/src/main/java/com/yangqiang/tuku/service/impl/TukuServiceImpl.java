package com.yangqiang.tuku.service.impl;


import com.yangqiang.tuku.mapper.TukuMapper;
import com.yangqiang.tuku.mapper.UserActionMapper;
import com.yangqiang.tuku.mapper.UserMapper;
import com.yangqiang.tuku.model.*;
import com.yangqiang.tuku.service.TukuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TukuServiceImpl implements TukuService {

    @Resource
    private TukuMapper tukuMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserActionMapper userActionMapper;

    /**
     * 获取图片
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public CommonResult getImages(int pageNo, int pageSize, String openId) {

        int offset = (pageNo - 1) * pageSize;
        List<Tuku> tukuList = tukuMapper.getImages(offset, pageSize);

        if (tukuList.isEmpty()) {
            return new CommonResult(400, "图库是空的", null);
        }

        for (Tuku tuku : tukuList) {
            String images = tuku.getImages();
            String[] imageArray = images.split(";");
            List<String> imageList = new ArrayList<>(Arrays.asList(imageArray));
            tuku.setImagesList(imageList);
            int id = tuku.getId();
            UserActionCount userActionCount = userMapper.getUserActionCount("imagesId",Integer.toString(id));
            tuku.setUserActionCount(userActionCount);

            UserAction userAction = userActionMapper.getUserAction(id, openId,1);

            if (userAction != null) {
                tuku.setMyThumbsUp(true);
            }

        }

        int tukuTotal = tukuMapper.getTukuTotal();

        Integer pageCount;
        if (tukuTotal % pageSize == 0){
            pageCount = tukuTotal / pageSize;
        }else {
            pageCount = (int)Math.ceil((double)tukuTotal / (double)pageSize);
        }

        ImagesPageData imagesPageData = new ImagesPageData(tukuList, pageCount, tukuTotal);

        return new CommonResult(200, "Success", imagesPageData);

    }




}
