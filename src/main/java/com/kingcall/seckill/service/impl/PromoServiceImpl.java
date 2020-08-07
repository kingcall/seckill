package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.entity.PromoAction;
import com.kingcall.seckill.mapper.PromoActionMapper;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.model.PromoModel;
import com.kingcall.seckill.service.ItemService;
import com.kingcall.seckill.service.PromoService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoServiceImpl implements PromoService {
    @Autowired
    PromoActionMapper promoActionMapper;

    @Autowired
    ItemService itemService;

    @Override
    public PromoModel getPromo(int itemId) {
        PromoAction promoAction = promoActionMapper.selectByItemId(itemId);
        return convertPromoModel(promoAction);
    }

    @Override
    public Boolean createPromo(PromoModel promoModel) throws BusinessException {
        //商品是否存在
        ItemModel itemModel = itemService.getItem(promoModel.getItemId());
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST_ERROR);
        }
        // 时间先后关系判断
        PromoAction promoAction = new PromoAction();
        BeanUtils.copyProperties(promoModel, promoAction);
        promoActionMapper.insertSelective(promoAction);
        return null;
    }


    private PromoModel convertPromoModel(PromoAction promoAction) {
        PromoModel promoModel = new PromoModel();
        if (promoAction == null) {
            return null;
        }
        BeanUtils.copyProperties(promoAction, promoModel);
        promoModel.setEndTime(new DateTime(promoAction.getStartTime()));
        promoModel.setStartTime(new DateTime(promoAction.getEndTime()));
        modelStatusProcess(promoModel);
        return promoModel;
    }

    private void modelStatusProcess(PromoModel model) {
        if (model == null) {
            return;
        }
        if (model.getStartTime().isAfterNow()) {
            model.setStatus(1);
        } else if (model.getEndTime().isBeforeNow()) {
            model.setStatus(3);
        } else {
            model.setStatus(2);
        }
    }
}
