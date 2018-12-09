package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByName(String name);

    Goods findByCategory(Category category);
}
