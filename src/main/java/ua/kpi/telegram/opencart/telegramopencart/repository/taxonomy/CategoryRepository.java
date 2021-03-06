package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);

    Category findByName(String name);

    void deleteByName(String name);
}
