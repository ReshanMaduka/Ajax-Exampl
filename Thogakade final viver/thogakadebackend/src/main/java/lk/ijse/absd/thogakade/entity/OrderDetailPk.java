package lk.ijse.absd.thogakade.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@Embeddable
public class OrderDetailPk implements Serializable {
    private String orderId;
    private String code;

    public OrderDetailPk() {
    }

    public OrderDetailPk(String orderId, String code) {
        this.orderId = orderId;
        this.code = code;
    }
}
