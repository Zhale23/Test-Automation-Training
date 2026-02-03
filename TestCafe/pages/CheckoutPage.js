import { Selector, t } from "testcafe";
import { InventoryPage } from "./InventoryPage.js";

class CheckoutPage {
    constructor(){
        this.nameInput = Selector('#first-name');
        this.lastNameInput = Selector('#last-name');
        this.postalCodeInput = Selector('#postal-code');
        this.continueBtn = Selector('input').withAttribute('value', 'Continue');
        this.finishBtn = Selector('button').withText('Finish');
        this.itemTotal = Selector('.summary_subtotal_label');
    }

    async fillCheckoutInformation(name, lastName, postalCode){
        await t
            .typeText(this.nameInput, name)
            .typeText(this.lastNameInput, lastName)
            .typeText(this.postalCodeInput, postalCode);
    }

    async continueCheckout(){
        await t.click(this.continueBtn);
    }

    async finishCheckout(){
            await t.click(this.finishBtn);
        }

    async returnItemsTotal(){
        const itemTotalText = await this.itemTotal.innerText;
        console.log("Item total text:", parseFloat(itemTotalText.replace('Item total: $', '')));
        return parseFloat(itemTotalText.replace('Item total: $', ''));

    }
}

export default new CheckoutPage();