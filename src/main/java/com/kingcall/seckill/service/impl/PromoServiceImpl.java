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

import java.util.Date;

@Service
public class PromoServiceImpl implements PromoService {
    @Autowired
    PromoActionMapper promoActionMapper;

    @Autowired
    ItemService itemService;

    @Override
    public PromoModel getPromoByItemId(int itemId) {
        PromoAction promoAction = promoActionMapper.selectByItemId(itemId);
        return convertPromoModel(promoAction);
    }

    @Override
    public PromoModel getPromoByPrimaryKey(int promoId) {
        PromoAction promoAction = promoActionMapper.selectByPrimaryKey(promoId);
        return convertPromoModel(promoAction);
    }



    @Override
    public Boolean createPromo(PromoModel promoModel) throws BusinessException {

        //商品是否存在
        ItemModel itemModel = itemService.getItem(promoModel.getItemId());
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST_ERROR);
        }

        if (itemModel.getPrice().compareTo(promoModel.getPromoPrice()) == -1) {
            throw new BusinessException(EmBusinessError.PROMO_ACTION_ERROR, "活动价格不能大于原来价格");
        }

        if (itemModel.getPromoModel() != null) {
            throw new BusinessException(EmBusinessError.PROMO_ACTION_ERROR, "商品已经存在活动");
        }


        PromoAction promoAction = convertPromoAction(promoModel);
        promoActionMapper.insertSelective(promoAction);
        return true;
    }


    private PromoAction convertPromoAction(PromoModel promoModel) {
        PromoAction promoAction = new PromoAction();
        if (promoModel == null) {
            return null;
        }
        BeanUtils.copyProperties(promoModel, promoAction);
        promoAction.setEndTime(promoModel.getEndTime().toDate());
        promoAction.setStartTime(promoModel.getStartTime().toDate());
        return promoAction;
    }

    private PromoModel convertPromoModel(PromoAction promoAction) {
        PromoModel promoModel = new PromoModel();
        if (promoAction == null) {
            return null;
        }
        BeanUtils.copyProperties(promoAction, promoModel);
        promoModel.setEndTime(new DateTime(promoAction.getEndTime()));
        promoModel.setStartTime(new DateTime(promoAction.getStartTime()));
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
