/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class ShippedOrder
        extends OrderState {

    private static final ShippedOrder instance = new ShippedOrder(false);
    private              boolean      hasShipped;

    private ShippedOrder(boolean hasShipped) {
        this.hasShipped = hasShipped;
    }

    public static ShippedOrder getInstance() {
        return ShippedOrder.instance;
    }

    public void setHasShipped(boolean hasShipped) {
        this.hasShipped = hasShipped;
    }

    public OrderStateEnum getState() {
        return OrderStateEnum.SHIPPED;
    }

    @Override
    public double getPaidValue(Order order) {
        return order.getPrice() + order.getShippingFee();
    }

    @Override
    public boolean deliver(Order order) {
        order.setState(DeliveredOrder.getInstance());
        return true;
    }

    @Override
    public boolean returnToStore(Order order) {
        order.setState(ReturnedOrder.getInstance());
        return true;
    }

}
