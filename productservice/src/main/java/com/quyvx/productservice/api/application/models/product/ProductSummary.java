package com.quyvx.productservice.api.application.models.product;

import java.math.BigDecimal;

public interface ProductSummary {
    String getId();
    String getName();
    String getDescription();
    BigDecimal getPrice();
    String getCategory();
}
