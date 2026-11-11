package com.yf.ecommerce.backend.domain.model;

public enum OrderState {
    /*
    CANCELED: Es cuando el usuario añade unos productos al carrito de compras
    pero no hizo el pago.
    CONFIRMED: Es cuando el usuario añade unos productos al carrito de compras
    y también hizo el pago.
     */
    CANCELED,
    CONFIRMED
}
