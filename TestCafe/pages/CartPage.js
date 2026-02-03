import { Selector, t } from 'testcafe';

class CartPage {
    constructor() {
        this.cartItems = Selector('.cart_item');
        this.checkoutBtn = Selector('button').withText('Checkout');
    }

    async confirmItemIsInTheCart(itemName) {
        const item = this.cartItems.withText(itemName);
        await t.expect(item.exists).ok(`Error: El ítem "${itemName}" no se encontró en el carrito`);
    }

    async goToCheckout() {
        await t.click(this.checkoutBtn);
    }
}

export default new CartPage();