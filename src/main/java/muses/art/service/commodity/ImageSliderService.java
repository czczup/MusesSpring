package muses.art.service.commodity;

import muses.art.entity.commodity.ImageSlider;
import muses.art.model.commodity.ImageSliderModel;

import java.util.List;

public interface ImageSliderService {
    //管理员添加轮播图
    boolean addImageSlider(ImageSliderModel imageSliderModel, int user_id);
    //管理员撤销轮播图(id为轮播图id)
    boolean deleteImageSlider(int id);
    //更新轮播图相关信息
    boolean updateImageSlider(ImageSliderModel imageSliderModel);
    //展示轮播图
    List<ImageSliderModel> listImageSlider();
}
