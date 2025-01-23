/*
 * Copyright (c) 2025 Gabriel Malosto.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at <https://www.gnu.org/licenses/agpl-3.0.txt>.
 */

package assignments.shipping;

public class Order {

    OrderState state;
    private String code;
    private double price;
    private double shippingFee;

    public Order() {
        this.state = PendingOrder.getInstance();
    }

    public void setState(OrderState orderState) {
        this.state = orderState;
    }

}