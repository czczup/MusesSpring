package muses.art.service.operation;

import muses.art.model.operation.CommentModel;

import java.util.List;

public interface CommentService {
    /**
     *
     * @param comment 评论内容
     * @param commodityId 商品id
     * @param orderId 订单id
     * @param userId 用户id
     * @return
     */
    boolean addComment(String comment, Integer commodityId, Integer orderId, Integer userId);

    /**
     *
     * @param id 评论id
     * @return
     */
    boolean deleteComment(Integer id);

    /**
     *
     * @param id 评论id
     * @param content 评论内容
     * @return
     */
    boolean updateComment(Integer id, String content);

    /**
     * 根据用户id查找评论
     * @param id 评论id
     * @return
     */
    CommentModel findCommentById(Integer id);

    /**
     * 根据用户id查找评论
     * @param userId 用户id
     * @return
     */
    List<CommentModel> findCommentByUserId(Integer userId);

    /**
     * 根据商品id查找评论
     * @param commodityId 商品id
     * @return
     */
    List<CommentModel> findCommentByCommodityId(Integer commodityId);

    /**
     * 查找用户是否给某个商品进行评论
     * @param commodityId 商品id
     * @param userId 用户id
     * @return
     */
    CommentModel findCommentByCommodityIdAndUserID(Integer commodityId, Integer userId);
}
