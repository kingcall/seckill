package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.entity.Order;
import com.kingcall.seckill.entity.sequenceInfo;
import com.kingcall.seckill.mapper.OrderMapper;
import com.kingcall.seckill.mapper.SequenceInfoMapper;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.model.OrderModel;
import com.kingcall.seckill.model.PromoModel;
import com.kingcall.seckill.model.UserModel;
import com.kingcall.seckill.service.ItemService;
import com.kingcall.seckill.service.OrderService;
import com.kingcall.seckill.service.PromoService;
import com.kingcall.seckill.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;


    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private SequenceInfoMapper sequenceInfoMapper;

    @Autowired
    PromoService promoService;


    /**
     * 秒杀活动
     *
     * @param userId
     * @param itemId
     * @param amount
     * @param promoId
     * @return
     * @throws BusinessException
     */
    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId, Integer amount, Integer promoId) throws BusinessException {
        // 参数校验
        if (userId == null || itemId == null || amount <= 0) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "参数不合法");
        }

        ItemModel itemModel = itemService.getItem(itemId);
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST_ERROR);
        }

        UserModel userModel = userService.getUserById(userId);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXISTT);
        }

        // 落单减库存(锁定给这个用户)
        boolean isValid = itemService.decreaseStock(itemId, amount);
        if (isValid == false) {
            throw new BusinessException(EmBusinessError.ORDER_ERROR, "库存不足");
        }


        // 订单入库
        OrderModel orderModel = new OrderModel();
        orderModel.setId(generateOrderId(userId));
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        orderModel.setUserId(userId);

        /**
         * 是秒杀活动
         */
        PromoModel promoModel = null;
        if (promoId != null) {
            // 活动信息校验 是否存在活动 活动和商品是否匹配  活动是否在进行中
            promoModel = promoService.getPromoByPrimaryKey(promoId);
            if (promoModel == null || promoModel.getItemId() != itemId || promoModel.getStatus() != 2) {
                log.warn(promoModel.toString());
                throw new BusinessException(EmBusinessError.PROMO_ACTION_ERROR);
            }
            orderModel.setItemPrice(promoModel.getPromoPrice());
            orderModel.setPromoId(promoId);
        } else {
            orderModel.setItemPrice(itemModel.getPrice());
        }

        orderModel.setOrderPrice(orderModel.getItemPrice().multiply(new BigDecimal(amount)));
        Order order = convertOrder(orderModel);
        orderMapper.insertSelective(order);
        // 这里应该考虑支付是否成功

        // 增加销量
        if (itemService.increaseSales(itemId, amount) == false) {
            throw new BusinessException(EmBusinessError.ORDER_ERROR, "增加销量失败");
        }
        return orderModel;
    }

    private Order convertOrder(OrderModel orderModel) {
        Order order = new Order();
        BeanUtils.copyProperties(orderModel, order);
        return order;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateOrderId(int userId) {
        StringBuilder stringBuilder = new StringBuilder();
        // 订单号18位
        // 前8位是时间

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime localDateTime = LocalDateTime.now();
        stringBuilder.append(localDateTime.format(formatter));
        // 中间8位是自增序列
        sequenceInfo info = sequenceInfoMapper.getSequenceByName("order");
        int sequenceNumber = info.getCurrentValue();
        info.setCurrentValue(sequenceNumber + info.getStep());
        sequenceInfoMapper.updateByPrimaryKeySelective(info);
        String sequence = String.valueOf(sequenceNumber);
        for (int i = 0; i < 8 - sequence.length(); i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(sequence);
        // 最后两位是分库分表信息
        stringBuilder.append(String.valueOf(userId % 100));
        return stringBuilder.toString();
    }


}
