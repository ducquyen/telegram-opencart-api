package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.GoodsService;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class GoodsController {
    private final Logger logger = getLogger(GoodsController.class);

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/goods")
    public List<Goods> findAll() {
        logger.info("Finding all goods");
        return goodsService.getAll();
    }

    @GetMapping("/goods/{categoryId}")
    public List<Goods> findByCategory(@PathVariable("categoryId") long categoryId) {
        logger.info("Finding all goods by category");

        return goodsService.getAllByCategory(categoryId);
    }

    @PutMapping("/goods")
    public Goods createGoods(@RequestBody Goods goods) {
        return goodsService.add(goods);
    }

    @PostMapping("/goods")
    public Goods updateGoods(@RequestBody Goods goods,
                             @RequestParam("id") long goodsId) {
        return goodsService.update(goods, goodsId);
    }

    @DeleteMapping("/goods")
    public void deleteGoods(@RequestParam("id") long goodsId) {
        goodsService.remove(goodsId);
    }
}
