package com.kingcall.seckill.service;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.model.PromoModel;

public interface PromoService {
    /**
     * 根据商品ID 查询对应的秒杀活动(即将进行或正在进行的活动)
     * @param itemId
     * @return
     */
    PromoModel getPromoByItemId(int itemId);

    /**
     * 创建秒杀活动
     * @return
     */
    Boolean createPromo(PromoModel promoModel) throws BusinessException;

    /**
     * 根据活动ID 获取活动西悉尼
     * @param promoId
     * @return
     */
    PromoModel getPromoByPrimaryKey(int promoId);


}
