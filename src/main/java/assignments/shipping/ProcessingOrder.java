/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class ProcessingOrder
        extends OrderState {

    private static final ProcessingOrder instance = new ProcessingOrder();

    private ProcessingOrder() {
    }

    public static ProcessingOrder getInstance() {
        return ProcessingOrder.instance;
    }

    public OrderStateEnum getState() {
        return OrderStateEnum.PROCESSING;
    }

    @Override
    public double getPaidValue(Order order) {
        return order.getPrice() + order.getShippingFee();
    }

    @Override
    public boolean cancel(Order order) {
        order.setState(CancelledOrder.getInstance());
        return true;
    }

    @Override
    public boolean ship(Order order) {
        order.setState(ShippedOrder.getInstance());
        return true;
    }

}
