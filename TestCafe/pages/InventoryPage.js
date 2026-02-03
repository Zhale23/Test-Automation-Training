import { Selector, t } from 'testcafe';

class InventoryPage {
    constructor() {
        this.inventoryItem = Selector('.inventory_item');
        this.cartLink = Selector('.shopping_cart_link');
        this.cartBadge = Selector('.shopping_cart_badge');
    }

    async addItemToCart(itemName) {
        // Buscamos el contenedor que tiene el texto del producto y luego el botón dentro de él
        const productBtn = this.inventoryItem.withText(itemName).find('button').withText('Add to cart');
        await t.click(productBtn);
    }

    async goToCart() {
        await t.click(this.cartLink);
    }

    async addRandomItemsToCart(quantity) {
        const totalItems = await this.inventoryItem.count;
        let accumulatedPrice = 0;
        let selectedNames = []; 

        let selectedIndexes = new Set();
        while (selectedIndexes.size < quantity) {
            selectedIndexes.add(Math.floor(Math.random() * totalItems));
        }

        for (let index of selectedIndexes) {
            const item = this.inventoryItem.nth(index);
            const name = await item.find('.inventory_item_name').innerText;
            const priceText = await item.find('.inventory_item_price').innerText;

            selectedNames.push(name);
            accumulatedPrice += parseFloat(priceText.replace('$', ''));
        }

        for (let name of selectedNames) {
            const productBtn = this.inventoryItem
                .withText(name)
                .find('button')
                .withText('Add to cart');

            await t.click(productBtn); 

        console.log("Productos seleccionados:", selectedNames);
        console.log("Total acumulado:", accumulatedPrice);

        return parseFloat(accumulatedPrice.toFixed(2));
    }

}
}
export default new InventoryPage();