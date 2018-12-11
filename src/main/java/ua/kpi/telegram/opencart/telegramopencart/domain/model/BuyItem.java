package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class BuyItem implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Goods goods;

    private long amount;

    public BuyItem() {
    }

    public BuyItem(Goods goods, long amount) {
        this.goods = goods;
        this.amount = amount;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyItem buyItem = (BuyItem) o;
        return id == buyItem.id &&
                amount == buyItem.amount &&
                goods.equals(buyItem.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goods, amount);
    }

    @Override
    public String toString() {
        return "BuyItem{" +
                "id=" + id +
                ", goods=" + goods +
                ", amount=" + amount +
                '}';
    }
}
